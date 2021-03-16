package com.vieiratelier.access.domain.usecase.address.impl;

import com.vieiratelier.access.boundary.repository.address.AddressRepository;
import com.vieiratelier.access.domain.entity.address.AddressEntity;
import com.vieiratelier.access.domain.exception.address.AddressNotFoundException;
import com.vieiratelier.access.domain.usecase.address.FindAddress;

public class FindAddressImpl implements FindAddress {

	private final AddressRepository repository;
	
	public FindAddressImpl(AddressRepository repository) {
		this.repository = repository;
	}

	@Override
	public AddressEntity execute(String addressId) {
		AddressEntity addressEntity = repository.findByAddressId(addressId);
		if(addressEntity == null) throw new AddressNotFoundException(addressId);
		return addressEntity;
	}

}
