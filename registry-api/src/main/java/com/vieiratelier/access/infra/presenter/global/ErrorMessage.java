package com.vieiratelier.access.infra.presenter.global;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorMessage {

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	
	public ErrorMessage(LocalDateTime timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
