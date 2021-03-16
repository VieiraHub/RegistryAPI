package com.vieiratelier.access.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vieiratelier.access.boundary.port.IdGenerator;
import com.vieiratelier.access.boundary.repository.address.AddressDataProvider;
import com.vieiratelier.access.boundary.repository.address.AddressRepository;
import com.vieiratelier.access.boundary.repository.address.AddressRepositoryImpl;
import com.vieiratelier.access.boundary.repository.user.UserRepository;
import com.vieiratelier.access.boundary.service.address.AddressService;
import com.vieiratelier.access.boundary.service.address.AddressServiceImpl;
import com.vieiratelier.access.domain.usecase.address.CreateAddress;
import com.vieiratelier.access.domain.usecase.address.DeleteAddress;
import com.vieiratelier.access.domain.usecase.address.FindAddress;
import com.vieiratelier.access.domain.usecase.address.FindAddresses;
import com.vieiratelier.access.domain.usecase.address.impl.CreateAddressImpl;
import com.vieiratelier.access.domain.usecase.address.impl.DeleteAddressImpl;
import com.vieiratelier.access.domain.usecase.address.impl.FindAddressImpl;
import com.vieiratelier.access.domain.usecase.address.impl.FindAddressesImpl;

@Configuration
public class AddressConfig {

	@Bean
	public AddressRepository addressRepositoryConfig(AddressDataProvider dataprovider) {
		return new AddressRepositoryImpl(dataprovider);
	}

	@Bean
	public AddressService addressServiceConfig(CreateAddress create, DeleteAddress delete, FindAddress findAddress, FindAddresses findAddresses) {
		return new AddressServiceImpl(create, delete, findAddress, findAddresses);
	}

	@Bean
	public CreateAddress createAddressConfig(AddressRepository addressRepo, IdGenerator idGenerator,
			UserRepository userRepo) {
		return new CreateAddressImpl(userRepo, addressRepo, idGenerator);
	}

	@Bean
	public DeleteAddress deleteAddressConfig(AddressRepository repository) {
		return new DeleteAddressImpl(repository);
	}
	
	@Bean
	public FindAddress findAddressConfig(AddressRepository repository) {
		return new FindAddressImpl(repository);
	}
	
	@Bean
	public FindAddresses findAddressesConfig(AddressRepository repository) {
		return new FindAddressesImpl(repository);
	}
}
