package com.vieiratelier.access.domain.exception.address;

public class AddressNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4089705718466196121L;

	public AddressNotFoundException(final String message) {
		super(message);
	}
}
