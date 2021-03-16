package com.vieiratelier.access.domain.exception;

public class NotAllowedException extends RuntimeException {
	
	private static final long serialVersionUID = 3576516802080111927L;

	public NotAllowedException(final String message) {
		super(message);
	}
}
