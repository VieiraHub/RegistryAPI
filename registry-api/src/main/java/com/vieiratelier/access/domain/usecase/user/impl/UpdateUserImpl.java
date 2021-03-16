package com.vieiratelier.access.domain.usecase.user.impl;

import com.vieiratelier.access.boundary.repository.user.UserRepository;
import com.vieiratelier.access.domain.entity.user.UserEntity;
import com.vieiratelier.access.domain.exception.user.UserAlreadyExistsException;
import com.vieiratelier.access.domain.usecase.user.UpdateUser;


public class UpdateUserImpl implements UpdateUser {

	private final UserRepository repository;
	
	
	public UpdateUserImpl(UserRepository repository) {
		this.repository = repository;
	}


	@Override
	public UserEntity execute(String userId, String firstName, String lastName) {
		UserEntity userEntity = repository.findByUserId(userId);
		if( userEntity == null) {
//			EXCEPÇAO ESTÁ MAL POIS È: USER_DOESNT_EXIST_EXCEPTION
			throw new UserAlreadyExistsException(userId);
		}
		userEntity.setFirstName(firstName);
		userEntity.setLastName(lastName);
		System.out.println(userEntity.getId() + "TESSTEEEEEEEE");
		return repository.update(userEntity);
	}

}
