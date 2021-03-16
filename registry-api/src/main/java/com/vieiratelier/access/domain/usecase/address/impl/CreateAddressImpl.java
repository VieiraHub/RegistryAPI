package com.vieiratelier.access.domain.usecase.address.impl;

import com.vieiratelier.access.boundary.port.IdGenerator;
import com.vieiratelier.access.boundary.repository.address.AddressRepository;
import com.vieiratelier.access.boundary.repository.user.UserRepository;
import com.vieiratelier.access.domain.entity.address.AddressEntity;
import com.vieiratelier.access.domain.entity.user.UserEntity;
import com.vieiratelier.access.domain.usecase.address.CreateAddress;

public class CreateAddressImpl implements CreateAddress {

	private final UserRepository userRepository;
	private final AddressRepository addressRepository;
	private final IdGenerator idGenerator;
	
	public CreateAddressImpl(UserRepository userRepository, AddressRepository addressRepository,
			IdGenerator idGenerator) {
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
		this.idGenerator = idGenerator;
	}


	@Override
	public AddressEntity execute(String userId, String city, String country, String streetName, String postalCode,
			String type) {
		UserEntity user = userRepository.findByUserId(userId);
		if(user != null) {
			// DEVERIA DE TER UM METODO PARA VERIFICAR SE A MORADA JA EXISTE MAS AINDA NÂO SEI COMO
			String addressId = idGenerator.execute();
			AddressEntity address = new AddressEntity(user, addressId, city, country, streetName, postalCode, type);
			return addressRepository.create(address);
		}
		return null;
	}

}
