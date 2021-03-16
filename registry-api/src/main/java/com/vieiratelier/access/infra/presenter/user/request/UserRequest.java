package com.vieiratelier.access.infra.presenter.user.request;

public class UserRequest {
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	
	public UserRequest(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
}
