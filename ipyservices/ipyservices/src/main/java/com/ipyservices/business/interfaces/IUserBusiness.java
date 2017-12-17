package com.ipyservices.business.interfaces;

import com.ipyservices.entities.*;

public interface IUserBusiness {

	void Create(User user) throws Exception;

	User Get(int id);

	boolean AuthUser(com.ipyservices.entities.AuthUser user);

	void Update(User user) throws Exception;

	void Delete(int id);
}
