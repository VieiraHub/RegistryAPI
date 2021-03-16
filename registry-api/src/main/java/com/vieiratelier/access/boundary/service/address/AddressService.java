package com.vieiratelier.access.boundary.service.address;

import java.util.List;

import com.vieiratelier.access.boundary.dto.address.AddressDto;

public interface AddressService {
	AddressDto create(String userId, String city, String country, String streetName, String postalCode, String type);
	Boolean delete(String addressId);
	AddressDto findAddress(String addressId);
	List<AddressDto> findAddresses(int page, int limit);
}
