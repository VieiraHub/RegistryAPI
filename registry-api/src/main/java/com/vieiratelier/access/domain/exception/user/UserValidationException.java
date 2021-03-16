package com.vieiratelier.access.domain.exception.user;

public class UserValidationException extends RuntimeException {

	private static final long serialVersionUID = -6266844440139529240L;

	public UserValidationException(final String message) {
		super(message);
	}
}
