package com.vieiratelier.access.domain.usecase.address;

import com.vieiratelier.access.domain.entity.address.AddressEntity;

public interface FindAddress {
	AddressEntity execute(String addressId);
}
