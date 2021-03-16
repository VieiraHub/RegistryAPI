package com.vieiratelier.access.infra.presenter.address.request;

public class AddressRequest {
	
	public String city;
	public String country;
	public String streetName;
	public String postalCode;
	public String type;
	
	public AddressRequest(String city, String country, String streetName, String postalCode, String type) {
		this.city = city;
		this.country = country;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.type = type;
	}	
}
