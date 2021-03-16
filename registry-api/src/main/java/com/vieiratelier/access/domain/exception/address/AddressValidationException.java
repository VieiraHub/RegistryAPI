package com.vieiratelier.access.domain.exception.address;

public class AddressValidationException extends RuntimeException {

	private static final long serialVersionUID = -866462038190227207L;

	public AddressValidationException(final String message) {
		super(message);
	}
}
