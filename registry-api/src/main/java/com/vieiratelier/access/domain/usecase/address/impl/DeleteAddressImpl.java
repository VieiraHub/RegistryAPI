package com.vieiratelier.access.domain.usecase.address.impl;

import com.vieiratelier.access.boundary.repository.address.AddressRepository;
import com.vieiratelier.access.domain.entity.address.AddressEntity;
import com.vieiratelier.access.domain.exception.address.AddressAlreadyExistsException;
import com.vieiratelier.access.domain.usecase.address.DeleteAddress;

public class DeleteAddressImpl implements DeleteAddress {

	private final AddressRepository repository;
	
	public DeleteAddressImpl(AddressRepository repository) {
		this.repository = repository;
	}

	@Override
	public Boolean execute(String addressId) {
		AddressEntity addressEntity = repository.findByAddressId(addressId);
		if(addressEntity == null) throw new AddressAlreadyExistsException(addressId);
		return repository.delete(addressEntity);
	}

}
