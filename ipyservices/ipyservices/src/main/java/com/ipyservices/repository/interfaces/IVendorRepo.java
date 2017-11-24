package com.ipyservices.repository.interfaces;

import com.ipyservices.entities.Vendor;

public interface IVendorRepo {

	void Create(Vendor vendor);

	Vendor Get(int id);

	void Update(Vendor vendor);

	void Delete(int id);

}
