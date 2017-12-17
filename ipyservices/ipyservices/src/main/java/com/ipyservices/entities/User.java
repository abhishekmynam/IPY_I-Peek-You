package com.ipyservices.entities;

import javax.validation.constraints.NotNull;

public class User {
	public int Id;
	@NotNull
	public String FirstName;
	@NotNull
	public String LastName;
	public String MiddleName;
	@NotNull
	public String UserName;
	@NotNull
	public String EmailId;
	@NotNull
	public String PhoneNo;
	@NotNull
	public String Address;
	@NotNull
	public boolean IsConsumer;
	@NotNull
	public boolean IsVendor;
}
