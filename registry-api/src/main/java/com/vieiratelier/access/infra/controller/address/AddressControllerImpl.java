package com.vieiratelier.access.infra.controller.address;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vieiratelier.access.boundary.dto.address.AddressDto;
import com.vieiratelier.access.boundary.service.address.AddressService;
import com.vieiratelier.access.infra.presenter.address.request.AddressRequest;
import com.vieiratelier.access.infra.presenter.address.response.AddressResponse;
import com.vieiratelier.access.infra.presenter.global.OperationNameEnum;
import com.vieiratelier.access.infra.presenter.global.OperationResult;
import com.vieiratelier.access.infra.presenter.global.OperationResultEnum;

@Service
public class AddressControllerImpl implements AddressController {

	private final AddressService service;
	
	public AddressControllerImpl(AddressService service) {
		this.service = service;
	}
	
	private final AddressResponse fromDto(AddressDto addressDto) {
		return new AddressResponse(addressDto.addressId, addressDto.city, addressDto.country, 
				addressDto.streetName, addressDto.postalCode, addressDto.type);
	}

	@Override
	public AddressResponse create(String userId, AddressRequest addressRequest) {
		AddressDto response = service.create(userId, addressRequest.city, addressRequest.country, 
				addressRequest.streetName, addressRequest.postalCode, addressRequest.type);
		return fromDto(response);
	}

	@Override
	public OperationResult delete(String addressId) {
		OperationResult response = new OperationResult(OperationNameEnum.DELETE);
		Boolean result = service.delete(addressId);
		if (result)  response.setOperationResult(OperationResultEnum.SUCCESS);
		else response.setOperationResult(OperationResultEnum.ERROR);
		return response;
	}

	@Override
	public AddressResponse findAddress(String addressId) {
		return fromDto(service.findAddress(addressId));
	}

	@Override
	public List<AddressResponse> findAddresses(int page, int limit) {
		List<AddressDto> listDto = service.findAddresses(page, limit);
		List<AddressResponse> response = new ArrayList<>();
		for(AddressDto address : listDto) {
			response.add(fromDto(address));
		}
		return response;
	}
}
