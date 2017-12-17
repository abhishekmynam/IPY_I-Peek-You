package com.ipyservices.repository.interfaces;

import com.ipyservices.entities.*;

public interface IUserRepo {

	void Create(User user) throws Exception;

	User Get(int id);

	boolean Auth(com.ipyservices.entities.AuthUser user);

	void Update(User user) throws Exception;

	void Delete(int id);
}
