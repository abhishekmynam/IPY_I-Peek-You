package com.ipyservices.repository.interfaces;

import com.ipyservices.entities.Customer;

public interface ICustomerRepo {

	void Create(Customer customer);

	Customer Get(int id);

	void Update(Customer customer);

	void Delete(int id);

}
