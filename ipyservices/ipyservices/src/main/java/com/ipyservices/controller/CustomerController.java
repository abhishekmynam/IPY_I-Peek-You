package com.ipyservices.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipyservices.business.CustomerBusiness;
import com.ipyservices.business.interfaces.ICustomerBusiness;
import com.ipyservices.entities.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	ICustomerBusiness _customerBusiness = new CustomerBusiness();

	@POST
	@RequestMapping("/create")
	public void Create(@RequestBody Customer customer) {
		_customerBusiness.Create(customer);
	}

	@GET
	@RequestMapping("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer Get(int id) {
		return _customerBusiness.Get(id);
	}

	@PUT
	@RequestMapping("/update")
	public void Update(@RequestBody Customer customer) {
		_customerBusiness.Update(customer);
	}

	@DELETE
	@RequestMapping("/delete/{id}")
	public void Delete(int id) {
		_customerBusiness.Delete(id);
	}
}
