package com.vieiratelier.access.infra.database.address;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.vieiratelier.access.boundary.dto.address.AddressDto;
import com.vieiratelier.access.boundary.repository.address.AddressDataProvider;

@Component
public class AddressDataProviderImpl implements AddressDataProvider {

	private final AddressJpaProvider provider;

	public AddressDataProviderImpl(AddressJpaProvider provider) {
		this.provider = provider;
	}

	@Override
	public AddressDto create(AddressDto addressDto) {
		AddressTable request = AddressDbConverter.fromDto(addressDto);
		AddressTable response = provider.save(request);
		return AddressDbConverter.fromTable(response);
	}

	@Override
	public Boolean delete(AddressDto addressDto) {
		// TESTAR VER SE O CONVERSOR QUE EXISTE RESULTA POIS DTO NAO TEM MORADA
		AddressTable address = AddressDbConverter.fromDto(addressDto);
		provider.delete(address);
		return true;
	}

	@Override
	public AddressDto findByAddressId(String addressId) {
		// TESTAR VER SE O CONVERSOR QUE EXISTE RESULTA POIS DTO NAO TEM MORADA
		AddressTable address = provider.findByAddressId(addressId);
		AddressDto response = AddressDbConverter.fromTable(address);
		return response;
	}

	@Override
	public List<AddressDto> findAddresses(int page, int limit) {
		List<AddressDto> returnValue = new ArrayList<>();
		Pageable pageableRequest = PageRequest.of(page, limit);
		List<AddressTable> addressesList = provider.findAll(pageableRequest).getContent();
		for (AddressTable addressTable : addressesList) {
			AddressDto addressDto = AddressDbConverter.fromTable(addressTable);
			returnValue.add(addressDto);
		}
		return returnValue;
	}
}
