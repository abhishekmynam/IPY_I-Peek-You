package com.ipyservices.business;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ipyservices.business.interfaces.IUserBusiness;
import com.ipyservices.entities.User;
import com.ipyservices.repository.UserRepo;
import com.ipyservices.repository.interfaces.IUserRepo;


@Service
public class UserBusiness implements IUserBusiness {

	IUserRepo _userRepo;
	@Inject
	public UserBusiness(UserRepo userRepo)
	{
		_userRepo = userRepo;
	}

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
