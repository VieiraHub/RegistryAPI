package com.vieiratelier.access.domain.usecase.address.impl;

import java.util.List;

import com.vieiratelier.access.boundary.repository.address.AddressRepository;
import com.vieiratelier.access.domain.entity.address.AddressEntity;
import com.vieiratelier.access.domain.usecase.address.FindAddresses;

public class FindAddressesImpl implements FindAddresses {

	private final AddressRepository repository;
	
	public FindAddressesImpl(AddressRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<AddressEntity> execute(int page, int limit) {
		if (page > 0) page = page - 1;
		return repository.findAddresses(page, limit);
	}
	
}
