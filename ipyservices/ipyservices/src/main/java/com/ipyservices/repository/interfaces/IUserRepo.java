package com.ipyservices.repository.interfaces;

import com.ipyservices.entities.*;

public interface IUserRepo {

	void Create(User user);

	User Get(int id);

	boolean Auth(com.ipyservices.entities.AuthUser user);

	void Update(User user);

	void Delete(int id);
}