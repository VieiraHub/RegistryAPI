package com.vieiratelier.access.domain.usecase.user.impl;

import com.vieiratelier.access.boundary.repository.user.UserRepository;
import com.vieiratelier.access.domain.entity.user.UserEntity;
import com.vieiratelier.access.domain.usecase.user.FindByUserId;

public class FindByUserIdImpl implements FindByUserId {

private final UserRepository repository;
	
	public FindByUserIdImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UserEntity execute(String userId) {
		// VALIDAR O USER ID BLABLA 
		return repository.findByUserId(userId);
	}

}
