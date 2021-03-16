package com.vieiratelier.access.infra.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.vieiratelier.access.infra.presenter.global.ErrorMessage;


@ControllerAdvice
public class AppExceptionsHandler {

	@ExceptionHandler(value = { UserServiceException.class })
	public ResponseEntity<Object> userServiceExceptionHandler(UserServiceException ex, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), ex.getMessage());
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> otherExceptionsHandler(Exception ex, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
