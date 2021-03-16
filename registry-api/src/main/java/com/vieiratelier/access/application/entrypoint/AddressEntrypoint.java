package com.vieiratelier.access.application.entrypoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vieiratelier.access.infra.controller.address.AddressController;
import com.vieiratelier.access.infra.presenter.address.request.AddressRequest;
import com.vieiratelier.access.infra.presenter.address.response.AddressResponse;
import com.vieiratelier.access.infra.presenter.global.OperationResult;


@RestController
@RequestMapping("users/addresses") // AINDA TENHO QUE VER users/addresses ou addresses
public class AddressEntrypoint {

	@Autowired
	private final AddressController controller;

	public AddressEntrypoint(AddressController controller) {
		this.controller = controller;
	}
	
	@PostMapping(path = "/{userId}")
	AddressResponse createAddress(@PathVariable String userId, @RequestBody AddressRequest addressRequest) {
		return controller.create(userId, addressRequest);
	}	
	
	@DeleteMapping(path = "/{addressId}")
	public OperationResult deleteUser(@PathVariable String addressId) {
		return controller.delete(addressId);
	}
	
	@GetMapping(path = "/{addressId}")
	public AddressResponse findAddress(@PathVariable String addressId) {
		return controller.findAddress(addressId);
	}
	
	@GetMapping
	public List<AddressResponse> findAddresses(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "5") int limit) {
		return controller.findAddresses(page, limit);
	}
}
