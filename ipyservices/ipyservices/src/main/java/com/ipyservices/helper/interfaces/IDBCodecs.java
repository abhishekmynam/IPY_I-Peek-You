package com.ipyservices.helper.interfaces;

import org.bson.Document;

import com.ipyservices.entities.User;

public interface IDBCodecs {
	Document UserDoc (User user);
}
