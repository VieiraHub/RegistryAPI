package com.vieiratelier.access.boundary.repository.address;

import java.util.List;

import com.vieiratelier.access.boundary.dto.address.AddressConverter;
import com.vieiratelier.access.boundary.dto.address.AddressDto;
import com.vieiratelier.access.domain.entity.address.AddressEntity;

public class AddressRepositoryImpl implements AddressRepository{

	private final AddressDataProvider dataprovider;
	
	public AddressRepositoryImpl(AddressDataProvider dataprovider) {
		this.dataprovider = dataprovider;
	}


	@Override
	public AddressEntity create(AddressEntity addressEntity) {
		AddressDto addDto = AddressConverter.fromEntity(addressEntity);
		AddressDto addressDto = dataprovider.create(addDto);
		return AddressConverter.fromDto(addressDto);
	}

	@Override
	public Boolean delete(AddressEntity addressEntity) {
		// TESTAR VER SE O CONVERSOR QUE EXISTE RESULTA POIS DTO NAO TEM MORADA
		AddressDto address = AddressConverter.fromEntity(addressEntity);
		if(dataprovider.delete(address)) return true;
		return false;
	}

	@Override
	public AddressEntity findByAddressId(String addressId) {
		AddressDto address = dataprovider.findByAddressId(addressId);
		// TESTAR VER SE O CONVERSOR QUE EXISTE RESULTA POIS DTO NAO TEM MORADA
		AddressEntity response = AddressConverter.fromDto(address);
		return response;
	}


	@Override
	public List<AddressEntity> findAddresses(int page, int limit) {
		List<AddressDto> listDto = dataprovider.findAddresses(page, limit);
		List<AddressEntity> response = AddressConverter.fromDtoList(listDto);
		return response;
	}

}
