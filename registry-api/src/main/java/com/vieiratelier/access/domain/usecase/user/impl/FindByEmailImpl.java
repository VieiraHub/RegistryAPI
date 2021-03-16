package com.vieiratelier.access.domain.usecase.user.impl;

import com.vieiratelier.access.boundary.repository.user.UserRepository;
import com.vieiratelier.access.domain.entity.user.UserEntity;
import com.vieiratelier.access.domain.usecase.user.FindByEmail;

public class FindByEmailImpl implements FindByEmail {

	private final UserRepository repository;
	
	public FindByEmailImpl(UserRepository repository) {
		this.repository = repository;
	}



	@Override
	public UserEntity execute(String email) {
		// CHEKAR VALIDADE DE EMAIL ETC SE E NULL BLABLA
		return repository.findByEmail(email);
	}

}
