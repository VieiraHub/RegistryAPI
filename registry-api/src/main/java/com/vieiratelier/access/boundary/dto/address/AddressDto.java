package com.vieiratelier.access.boundary.dto.address;

import java.io.Serializable;

import com.vieiratelier.access.boundary.dto.user.UserDto;

public class AddressDto implements Serializable {

	private static final long serialVersionUID = 6368607520799475434L;
	
	public Long id;
	public UserDto userDto;
	public String addressId;
	public String city;
	public String country;
	public String streetName;
	public String postalCode;
	public String type;
	
	public AddressDto(Long id, UserDto userDto, String addressId, String city, String country, String streetName,
			String postalCode, String type) {
		this.id = id;
		this.userDto = userDto;
		this.addressId = addressId;
		this.city = city;
		this.country = country;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.type = type;
	}	
}
