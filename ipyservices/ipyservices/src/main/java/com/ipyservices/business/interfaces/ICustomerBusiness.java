package com.ipyservices.business.interfaces;

import com.ipyservices.entities.Customer;

public interface ICustomerBusiness {

	void Create(Customer customer);

	Customer Get(int id);

	void Update(Customer customer);

	void Delete(int id);

}
