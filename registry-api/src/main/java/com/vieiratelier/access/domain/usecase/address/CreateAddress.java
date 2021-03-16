package com.vieiratelier.access.domain.usecase.address;

import com.vieiratelier.access.domain.entity.address.AddressEntity;

public interface CreateAddress {
	AddressEntity execute(String userId, String city, String country, String streetName, String postalCode, String type);
}
