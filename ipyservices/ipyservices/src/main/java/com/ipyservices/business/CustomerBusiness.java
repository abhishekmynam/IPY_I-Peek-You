package com.ipyservices.business;

import com.ipyservices.business.interfaces.ICustomerBusiness;
import com.ipyservices.entities.Customer;
import com.ipyservices.repository.CustomerRepo;
import com.ipyservices.repository.interfaces.ICustomerRepo;

public class CustomerBusiness implements ICustomerBusiness {
	
	ICustomerRepo _customerRepo = new CustomerRepo();
	public void Create(Customer customer) {
		_customerRepo.Create(customer);
		
	}

	public Customer Get(int id) {
		return _customerRepo.Get(id);
	}

	public void Update(Customer customer) {
		_customerRepo.Update(customer);
		
	}

	public void Delete(int id) {
		_customerRepo.Delete(id);
		
	}

}
