package com.vieiratelier.access.infra.presenter.address.response;

public class AddressResponse {
	
	public String addressId;
	public String city;
	public String country;
	public String streetName;
	public String postalCode;
	public String type;
	
	public AddressResponse(String addressId, String city, String country, String streetName, String postalCode,
			String type) {
		this.addressId = addressId;
		this.city = city;
		this.country = country;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.type = type;
	}	
}
