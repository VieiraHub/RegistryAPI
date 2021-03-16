package com.vieiratelier.access.boundary.repository.address;

import java.util.List;

import com.vieiratelier.access.domain.entity.address.AddressEntity;

public interface AddressRepository {
	AddressEntity create(AddressEntity addressEntity);
	Boolean delete(AddressEntity addressEntity);
	AddressEntity findByAddressId(String addressId);
	List<AddressEntity> findAddresses(int page, int limit);

	
}
