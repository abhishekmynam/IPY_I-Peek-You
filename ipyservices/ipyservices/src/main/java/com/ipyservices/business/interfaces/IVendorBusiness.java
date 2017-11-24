package com.ipyservices.business.interfaces;

import com.ipyservices.entities.Vendor;

public interface IVendorBusiness {

	void Create(Vendor vendor);

	Vendor Get(int id);

	void Update(Vendor vendor);

	void Delete(int id);

}
