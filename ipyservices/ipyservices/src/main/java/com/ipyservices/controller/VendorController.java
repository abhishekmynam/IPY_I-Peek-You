package com.ipyservices.controller;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipyservices.business.VendorBusiness;
import com.ipyservices.business.interfaces.IVendorBusiness;
import com.ipyservices.entities.Vendor;

@RestController
@RequestMapping("/vendor")
public class VendorController {

	IVendorBusiness _vendorBusiness;

	@Inject
	public VendorController(VendorBusiness vendorBusiness)
	{
		_vendorBusiness = vendorBusiness;
	}
	@POST
	@RequestMapping("/create")
	public void Create(@RequestBody Vendor vendor) {
		_vendorBusiness.Create(vendor);
	}

	@GET
	@RequestMapping("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vendor Get(int id) {
		return _vendorBusiness.Get(id);
	}

	@PUT
	@RequestMapping("/update")
	public void Update(@RequestBody Vendor vendor) {
		_vendorBusiness.Update(vendor);
	}

	@DELETE
	@RequestMapping("/delete/{id}")
	public void Delete(int id) {
		_vendorBusiness.Delete(id);
	}
}
