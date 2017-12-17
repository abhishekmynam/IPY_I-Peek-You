package com.ipyservices.helper;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.ipyservices.entities.User;
import com.ipyservices.helper.interfaces.IDBCodecs;
import com.mongodb.BasicDBObject;

@Service
public class DBCodecs implements IDBCodecs{

	public Document UserDoc(User user) {
		Document doc = new Document();
		doc.put("Id",user.Id);
		doc.put("FirstName",user.FirstName);
		doc.put("LastName",user.LastName);
		doc.put("MiddleName",user.MiddleName);
		doc.put("UserName",user.UserName);
		doc.put("EmailId",user.EmailId);
		doc.put("PhoneNo",user.PhoneNo);
		doc.put("Address",user.Address);
		doc.put("IsConsumer" ,user.IsConsumer);
		doc.put("IsVendor" ,user.IsVendor);
		return doc;
	}

	public BasicDBObject UpdateUserDoc(User user) {
		
		BasicDBObject updateFields = new BasicDBObject();
		updateFields.append("Id",user.Id);
		updateFields.append("FirstName",user.FirstName);
		updateFields.append("LastName",user.LastName);
		updateFields.append("MiddleName",user.MiddleName);
		updateFields.append("UserName",user.UserName);
		updateFields.append("EmailId",user.EmailId);
		updateFields.append("PhoneNo",user.PhoneNo);
		updateFields.append("Address",user.Address);
		updateFields.append("IsConsumer" ,user.IsConsumer);
		updateFields.append("IsVendor" ,user.IsVendor);
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.append("$set", updateFields);

		return setQuery;
	}

}
