package com.vieiratelier.access.infra.database.address;

import com.vieiratelier.access.boundary.dto.address.AddressDto;
import com.vieiratelier.access.infra.database.user.UserDbConverter;

public class AddressDbConverter {
	public static final AddressTable fromDto(AddressDto addressDto) { 
		return addressDto != null
				? new AddressTable(addressDto.id, addressDto.addressId, addressDto.city, addressDto.country,
						addressDto.streetName, addressDto.postalCode, addressDto.type,
						UserDbConverter.fromDto(addressDto.userDto))
				: null;
	}

	public static final AddressDto fromTable(AddressTable addressTable) {
		return addressTable != null
				? new AddressDto(addressTable.getId(), UserDbConverter.fromTable(addressTable.getUserDetails()),
						addressTable.getAddressId(), addressTable.getCity(), addressTable.getCountry(),
						addressTable.getStreetName(), addressTable.getPostalCode(), addressTable.getType())
				: null;
	}
	
}
