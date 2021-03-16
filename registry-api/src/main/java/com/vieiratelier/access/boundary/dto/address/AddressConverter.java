package com.vieiratelier.access.boundary.dto.address;

import java.util.ArrayList;
import java.util.List;

import com.vieiratelier.access.boundary.dto.user.UserConverter;
import com.vieiratelier.access.domain.entity.address.AddressEntity;

public class AddressConverter {
	public static final AddressDto fromEntity(AddressEntity addressEntity) {
		if (addressEntity == null) return null;
		
		return new AddressDto(addressEntity.getId(), UserConverter.fromEntity(addressEntity.getUser()), 
				addressEntity.getAddressId(), addressEntity.getCity(), addressEntity.getCountry(), 
				addressEntity.getStreetName(), addressEntity.getPostalCode(), addressEntity.getType());
	}

	public static final AddressEntity fromDto(AddressDto addressDto) {
		if (addressDto == null) return null;
		
		return new AddressEntity(addressDto.id, UserConverter.fromDto(addressDto.userDto), 
				addressDto.addressId, addressDto.city, addressDto.country, addressDto.streetName, 
				addressDto.postalCode, addressDto.type);
	}
	
	public static final List<AddressDto> fromEntityList(List<AddressEntity> entityList) {
		List<AddressDto> dtoList = new ArrayList<>();
		for (AddressEntity addressEntity : entityList) {
			dtoList.add(fromEntity(addressEntity));
		}
		return dtoList;
	}
	
	public static final List<AddressEntity> fromDtoList(List<AddressDto> dtoList) {
		List<AddressEntity> entityList = new ArrayList<>();
		for (AddressDto addressDto : dtoList) {
			entityList.add(fromDto(addressDto));
		}
		return entityList;
	}
}
