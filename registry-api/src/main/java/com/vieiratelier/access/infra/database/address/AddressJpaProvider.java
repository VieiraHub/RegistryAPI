package com.vieiratelier.access.infra.database.address;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressJpaProvider extends PagingAndSortingRepository<AddressTable, Long> {
	AddressTable findByAddressId(String addressId);
}
