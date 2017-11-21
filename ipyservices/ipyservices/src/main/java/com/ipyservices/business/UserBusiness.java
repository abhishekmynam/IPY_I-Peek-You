package com.ipyservices.business;

import com.ipyservices.business.interfaces.IUserBusiness;
import com.ipyservices.entities.User;
import com.ipyservices.repository.UserRepo;
import com.ipyservices.repository.interfaces.IUserRepo;

public class UserBusiness implements IUserBusiness {

	IUserRepo _userRepo = new UserRepo();

	public void Create(User user) {
		_userRepo.Create(user);
	}

	public User Get(int id) {

		return _userRepo.Get(id);
	}

	public boolean AuthUser(com.ipyservices.entities.AuthUser user) {

		return _userRepo.Auth(user);
	}

	public void Update(User user) {

		_userRepo.Update(user);
	}

	public void Delete(int id) {

		_userRepo.Delete(id);
	}

}
