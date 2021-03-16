package com.vieiratelier.access.domain.exception.address;

public class AddressAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = -5312235220531544879L;

	public AddressAlreadyExistsException(final String message) {
		super(message);
	}
}
