package com.vieiratelier.access.boundary.service.user;

import java.util.List;

import com.vieiratelier.access.boundary.dto.user.UserDto;

public interface UserService { 
	
	UserDto create(String firstName, String lastName, String email, String password);
	Boolean delete(String userId);
	UserDto getByEmail(String email);
	UserDto getByUserId(String userId);
	List<UserDto> findUsers(int page, int limit);
	UserDto update(String userId, String firstName, String lastName);
	
}
