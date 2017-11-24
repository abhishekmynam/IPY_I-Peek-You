package com.ipyservices.business;

import com.ipyservices.business.interfaces.IVendorBusiness;
import com.ipyservices.entities.Vendor;
import com.ipyservices.repository.VendorRepo;
import com.ipyservices.repository.interfaces.IVendorRepo;

public class VendorBusiness implements IVendorBusiness{
	
	IVendorRepo _vendorRepo = new VendorRepo();
	public void Create(Vendor vendor) {
		_vendorRepo.Create(vendor);
	}

	public Vendor Get(int id) {
		return _vendorRepo.Get(id);
	}

	public void Update(Vendor vendor) {
		_vendorRepo.Update(vendor);
		
	}

	public void Delete(int id) {
		_vendorRepo.Delete(id);
		
	}

}
