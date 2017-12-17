package com.ipyservices.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import com.ipyservices.business.UserBusiness;
import com.ipyservices.business.interfaces.IUserBusiness;
import com.ipyservices.entities.*;

@RestController
@RequestMapping("/user")
public class UserController {
	IUserBusiness _userBusiness;

	@Inject
	public UserController(UserBusiness userBusiness)
	{
		_userBusiness = userBusiness;
	}
	@POST
	@RequestMapping("/create")
	public void Create(@RequestBody  User user) throws Exception {
		_userBusiness.Create(user);
	}

	@GET
	@RequestMapping("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody User Get(@PathVariable("id") int id) {
		return _userBusiness.Get(id);
	}

	@RequestMapping("/auth")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean Auth(@RequestBody AuthUser user) {
		return _userBusiness.AuthUser(user);
	}

	@PUT
	@RequestMapping("/update")
	public void Update(@RequestBody User user) throws Exception {
		_userBusiness.Update(user);
	}

	@DELETE
	@RequestMapping("/delete/{id}")
	public void Delete(int id) {
		_userBusiness.Delete(id);
	}
}
