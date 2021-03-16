package com.vieiratelier.access.boundary.service.user;

import java.util.List;

import com.vieiratelier.access.boundary.dto.user.UserConverter;
import com.vieiratelier.access.boundary.dto.user.UserDto;
import com.vieiratelier.access.domain.entity.user.UserEntity;
import com.vieiratelier.access.domain.usecase.user.CreateUser;
import com.vieiratelier.access.domain.usecase.user.DeleteUser;
import com.vieiratelier.access.domain.usecase.user.FindByEmail;
import com.vieiratelier.access.domain.usecase.user.FindByUserId;
import com.vieiratelier.access.domain.usecase.user.FindUsers;
import com.vieiratelier.access.domain.usecase.user.UpdateUser;

public class UserServiceImpl implements UserService {

	private final CreateUser create;
	private final DeleteUser delete;
	private final FindByEmail findByEmail;
	private final FindByUserId findByUserId;
	private final FindUsers findUsers;
	private final UpdateUser update;
	
	public UserServiceImpl(CreateUser create, DeleteUser delete, FindByEmail findByEmail, FindByUserId findByUserId,
			FindUsers findUsers, UpdateUser update) {
		this.create = create;
		this.delete = delete;
		this.findByEmail = findByEmail;
		this.findByUserId = findByUserId;
		this.findUsers = findUsers;
		this.update = update;
	}

	@Override
	public UserDto create(String firstName, String lastName, String email, String password) {
		return UserConverter.fromEntity(create.execute(firstName, lastName, email, password));
	}

	@Override
	public Boolean delete(String userId) {
		return delete.execute(userId);
	}

	@Override
	public UserDto getByEmail(String email) {
		return UserConverter.fromEntity(findByEmail.execute(email));
	}

	@Override
	public UserDto getByUserId(String userId) {
		return UserConverter.fromEntity(findByUserId.execute(userId));
	}

	@Override
	public List<UserDto> findUsers(int page, int limit) {
		return UserConverter.fromEntityList(findUsers.execute(page, limit));
	}

	@Override
	public UserDto update(String userId, String firstName, String lastName) {
		UserEntity response = update.execute(userId, firstName, lastName);
		return UserConverter.fromEntity(response);
	}
}
