package com.ipyservices.helper;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.ipyservices.entities.User;
import com.ipyservices.helper.interfaces.IDBCodecs;

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

}
