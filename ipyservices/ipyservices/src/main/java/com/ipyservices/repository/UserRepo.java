package com.ipyservices.repository;

import org.bson.Document;

import com.ipyservices.entities.AuthUser;
import com.ipyservices.entities.User;
import com.ipyservices.repository.interfaces.IUserRepo;
/*import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;*/

public class UserRepo implements IUserRepo {

	public void Create(User user) {
		/*MongoClient server = new MongoClient("localhost", 27017);
		MongoDatabase db = server.getDatabase("IPY_DB_Test");
		MongoCollection<Document> coll = db.getCollection("User");
		Document doc = new Document();
		DBObject obj = (DBObject) JSON.parse(user.toString());
		doc.append("User", obj);
		coll.insertOne(doc);
		server.close();*/
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
