package com.vieiratelier.access.domain.exception.user;

public class UserAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = -300102289291186654L;

	public UserAlreadyExistsException(final String message) {
		super(message);
	}
}
