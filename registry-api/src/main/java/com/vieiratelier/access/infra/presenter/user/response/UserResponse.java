package com.vieiratelier.access.infra.presenter.user.response;

public class UserResponse {
	public String userId;
	public String firstName;
	public String lastName;
	public String email;

	public UserResponse() { }
	
	public UserResponse(String userId, String firstName, String lastName, String email) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
}
