package com.vieiratelier.access.domain.usecase.address;

import java.util.List;

import com.vieiratelier.access.domain.entity.address.AddressEntity;

public interface FindAddresses {
	List<AddressEntity> execute(int page, int limit);
}
