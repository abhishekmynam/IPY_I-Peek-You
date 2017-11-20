package com.ipyservices.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import com.ipyservices.business.UserBusiness;
import com.ipyservices.business.interfaces.IUserBusiness;
import com.ipyservices.entities.User;


@RestController
@RequestMapping("/user")
public class UserController {
	IUserBusiness _userBusiness = new UserBusiness();
	@POST
	@RequestMapping("/postuser")
	public void Create(@RequestBody User user)
	{
		_userBusiness.Create(user);
	}
	
	@GET
	@RequestMapping("/getuser")
	@Produces(MediaType.APPLICATION_JSON)
	public User Get()
	{
		User user = new User();
		user.Id = 10;
		user.FirstName = "Abhishek";
		user.LastName = "Mynam";
		return user;
	}
	
}

