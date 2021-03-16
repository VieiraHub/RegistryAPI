package com.vieiratelier.access.infra.exception;

public class UserServiceException extends RuntimeException {

	private static final long serialVersionUID = -5559969654498879848L;

	public UserServiceException(String message) {
		super(message);
	}
}
