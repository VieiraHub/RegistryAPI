package com.vieiratelier.access.infra.presenter.user.request;

public class UserLoginRequest {

	public String email;
	public String password;

	public UserLoginRequest() {}

	public UserLoginRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
