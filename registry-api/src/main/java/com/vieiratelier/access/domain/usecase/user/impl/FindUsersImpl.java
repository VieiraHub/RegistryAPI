package com.vieiratelier.access.domain.usecase.user.impl;

import java.util.List;

import com.vieiratelier.access.boundary.repository.user.UserRepository;
import com.vieiratelier.access.domain.entity.user.UserEntity;
import com.vieiratelier.access.domain.usecase.user.FindUsers;

public class FindUsersImpl implements FindUsers {

	private final UserRepository repository;
	
	public FindUsersImpl(UserRepository repository) {
		this.repository = repository;
	}


	@Override
	public List<UserEntity> execute(int page, int limit) {
		if (page > 0) page = page - 1;
		return repository.findUsers(page, limit);
	}

}
