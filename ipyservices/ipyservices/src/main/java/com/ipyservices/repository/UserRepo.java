package com.ipyservices.repository;

import javax.inject.Inject;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.ipyservices.entities.AuthUser;
import com.ipyservices.entities.User;
import com.ipyservices.helper.DBCodecs;
import com.ipyservices.helper.DBHelper;
import com.ipyservices.helper.entities.DBContext;
import com.ipyservices.helper.interfaces.IDBCodecs;
import com.ipyservices.helper.interfaces.IDBHelper;
import com.ipyservices.repository.interfaces.IUserRepo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class UserRepo implements IUserRepo {

	IDBCodecs _codec;
	IDBHelper _dbHelper;
	@Inject
	public UserRepo(DBCodecs codec, DBHelper dbHelper)
	{
		_codec = codec;
		_dbHelper = dbHelper;
	}
	public void Create(User user) {
		try {
			Document doc = _codec.UserDoc(user);
			
			DBContext context = _dbHelper.GetDB();
			MongoClient server = new MongoClient(context.DBServer, context.Port);
			MongoDatabase db = server.getDatabase(context.DBName);
			MongoCollection<Document> collection = db.getCollection("dummyColl");

			collection.insertOne(doc);
			server.close();

			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean Auth(AuthUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	public void Update(User user) {
		// TODO Auto-generated method stub

	}

	public void Delete(int id) {
		// TODO Auto-generated method stub

	}

}
