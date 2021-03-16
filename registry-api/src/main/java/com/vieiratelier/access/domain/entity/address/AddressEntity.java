package com.vieiratelier.access.domain.entity.address;

import java.io.Serializable;

import com.vieiratelier.access.domain.entity.user.UserEntity;

public class AddressEntity  implements Serializable {

	private static final long serialVersionUID = 3275410588472259694L;

	private Long id;
	private UserEntity user;
	private String addressId;
	private String city;
	private String country;
	private String streetName;
	private String postalCode;
	private String type;
	
	public AddressEntity(UserEntity user, String addressId, String city, String country, String streetName,
			String postalCode, String type) {
		this.user = user;
		this.addressId = addressId;
		this.city = city;
		this.country = country;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.type = type;
	}	
	
	public AddressEntity(Long id, UserEntity user, String addressId, String city, String country, String streetName,
			String postalCode, String type) {
		this.id = id;
		this.user = user;
		this.addressId = addressId;
		this.city = city;
		this.country = country;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public UserEntity getUser() {
		return user;
	}

	public String getAddressId() {
		return addressId;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getType() {
		return type;
	}	
}
