package com.vieiratelier.access.boundary.service.address;

import java.util.List;

import com.vieiratelier.access.boundary.dto.address.AddressConverter;
import com.vieiratelier.access.boundary.dto.address.AddressDto;
import com.vieiratelier.access.domain.usecase.address.CreateAddress;
import com.vieiratelier.access.domain.usecase.address.DeleteAddress;
import com.vieiratelier.access.domain.usecase.address.FindAddress;
import com.vieiratelier.access.domain.usecase.address.FindAddresses;

public class AddressServiceImpl implements AddressService {

	private final CreateAddress create;
	private final DeleteAddress delete;
	private final FindAddress findAddress;
	private final FindAddresses findAddresses;

	public AddressServiceImpl(CreateAddress create, DeleteAddress delete, FindAddress findAddress,
			FindAddresses findAddresses) {
		this.create = create;
		this.delete = delete;
		this.findAddress = findAddress;
		this.findAddresses = findAddresses;
	}

	@Override
	public AddressDto create(String userId, String city, String country, String streetName, String postalCode,
			String type) {
		return AddressConverter.fromEntity(create.execute(userId, city, country, streetName, postalCode, type));
	}

	@Override
	public Boolean delete(String addressId) {
		return delete.execute(addressId);
	}

	@Override
	public AddressDto findAddress(String addressId) {
		return AddressConverter.fromEntity(findAddress.execute(addressId));
	}

	@Override
	public List<AddressDto> findAddresses(int page, int limit) {
		return AddressConverter.fromEntityList(findAddresses.execute(page, limit));
	}

}
