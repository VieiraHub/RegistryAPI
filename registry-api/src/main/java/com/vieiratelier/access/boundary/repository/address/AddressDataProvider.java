package com.vieiratelier.access.boundary.repository.address;

import java.util.List;

import com.vieiratelier.access.boundary.dto.address.AddressDto;

public interface AddressDataProvider {
	AddressDto create(AddressDto addressDto);
	Boolean delete(AddressDto addressDto);
	AddressDto findByAddressId(String addressId);
	List<AddressDto> findAddresses(int page, int limit);
}
