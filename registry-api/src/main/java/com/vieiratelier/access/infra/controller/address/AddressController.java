package com.vieiratelier.access.infra.controller.address;

import java.util.List;

import com.vieiratelier.access.infra.presenter.address.request.AddressRequest;
import com.vieiratelier.access.infra.presenter.address.response.AddressResponse;
import com.vieiratelier.access.infra.presenter.global.OperationResult;

public interface AddressController {
	AddressResponse create(String userId, AddressRequest addressRequest);
	OperationResult delete(String addressId);
	AddressResponse findAddress(String addressId);
	List<AddressResponse> findAddresses(int page, int limit);
}
