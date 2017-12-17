package com.ipyservices.helper.interfaces;

import org.bson.Document;

import com.ipyservices.entities.User;
import com.mongodb.BasicDBObject;

public interface IDBCodecs {
	Document UserDoc (User user);

	BasicDBObject UpdateUserDoc(User user);
}
