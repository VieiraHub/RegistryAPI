package com.vieiratelier.access.boundary.repository.user;

import java.util.List;

import com.vieiratelier.access.boundary.dto.user.UserDto;

public interface UserDataProvider {
	UserDto create(UserDto userDto);
	Boolean delete(UserDto userDto);
	UserDto findByEmail(String email);
	UserDto findByUserId(String userId);
	List<UserDto> findUsers(int page, int limit);
	UserDto update(UserDto userDto);
}
