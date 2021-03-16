package com.vieiratelier.access.domain.usecase.user.impl;

import com.vieiratelier.access.boundary.repository.user.UserRepository;
import com.vieiratelier.access.domain.entity.user.UserEntity;
import com.vieiratelier.access.domain.exception.user.UserAlreadyExistsException;
import com.vieiratelier.access.domain.usecase.user.DeleteUser;

public class DeleteUserImpl implements DeleteUser {

	private final UserRepository repository;
	
	public DeleteUserImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public Boolean execute(String userId) {
		UserEntity userEntity = repository.findByUserId(userId);
		if(userEntity == null) {
//			LANÇAR EXCEPÇAO DE USER NAO EXISTE
			throw new UserAlreadyExistsException(userId);
		}
		return repository.delete(userEntity);
	}
}
