package com.ipyservices.repository;

import javax.inject.Inject;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipyservices.entities.AuthUser;
import com.ipyservices.entities.User;
import com.ipyservices.helper.DBCodecs;
import com.ipyservices.helper.DBHelper;
import com.ipyservices.helper.entities.DBContext;
import com.ipyservices.helper.interfaces.IDBCodecs;
import com.ipyservices.helper.interfaces.IDBHelper;
import com.ipyservices.repository.interfaces.IUserRepo;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class UserRepo implements IUserRepo {

	IDBCodecs _codec;
	IDBHelper _dbHelper;
	ObjectMapper _objectMapper;

	@Inject
	public UserRepo(DBCodecs codec, DBHelper dbHelper) {
		_codec = codec;
		_dbHelper = dbHelper;
		_objectMapper = new ObjectMapper();
		_objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public void Create(User user) throws Exception {
		try {
			Document doc = _codec.UserDoc(user);

			DBContext context = _dbHelper.GetDB();
			MongoClient server = new MongoClient(context.DBServer, context.Port);
			MongoDatabase db = server.getDatabase(context.DBName);
			MongoCollection<Document> collection = db.getCollection("User");

			collection.insertOne(doc);
			server.close();

		} catch (MongoWriteException e) {
			String message ="";
			String x = e.getMessage();
			if (e.getCode() == 11000) 
			{
				message = x.substring(x.indexOf("key: { : ") + 10 , x.indexOf(" }") -1) + " Already exists";
			}
			throw new Exception(message);  
		}
	}

	public User Get(int id) {
		User user = new User();
		try {
			DBContext context = _dbHelper.GetDB();
			MongoClient server = new MongoClient(context.DBServer, context.Port);
			MongoDatabase db = server.getDatabase(context.DBName);
			MongoCollection<Document> collection = db.getCollection("User");

			BasicDBObject filter = new BasicDBObject().append("Id", id);
			FindIterable<Document> userCur = collection.find(filter);
			if (userCur.iterator().hasNext())
			{
				user = _objectMapper.readValue(userCur.iterator().next().toJson(), User.class); 
			}
			server.close();
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}
		return user;
		
	}

	public boolean Auth(AuthUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	public void Update(User user) throws Exception {
		try {
			DBContext context = _dbHelper.GetDB();
			MongoClient server = new MongoClient(context.DBServer, context.Port);
			MongoDatabase db = server.getDatabase(context.DBName);
			MongoCollection<Document> collection = db.getCollection("User");

			Bson filter = new Document("EmailId", user.EmailId);
			BasicDBObject updateFields = _codec.UpdateUserDoc(user);
			collection.updateOne(filter, updateFields);
			server.close();

		} catch (MongoWriteException e) {
			String message ="";
			String x = e.getMessage();
			if (e.getCode() == 11000) 
			{
				message = x.substring(x.indexOf("key: { : ") + 10 , x.indexOf(" }") -1) + " Already exists";
			}
			
			throw new Exception(message);  
		}

	}

	public void Delete(int id) {
		try {
				DBContext context = _dbHelper.GetDB();
				MongoClient server = new MongoClient(context.DBServer, context.Port);
				MongoDatabase db = server.getDatabase(context.DBName);
				MongoCollection<Document> collection = db.getCollection("User");
				
				Bson filter = new Document("Id", id);
			    collection.deleteOne(filter);
			    
			    server.close();
			} 
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}

	}

}
