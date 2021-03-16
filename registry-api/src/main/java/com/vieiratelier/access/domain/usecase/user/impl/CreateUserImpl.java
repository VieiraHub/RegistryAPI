package com.vieiratelier.access.domain.usecase.user.impl;

import com.vieiratelier.access.boundary.port.IdGenerator;
import com.vieiratelier.access.boundary.port.PasswordEncoder;
import com.vieiratelier.access.boundary.repository.user.UserRepository;
import com.vieiratelier.access.domain.entity.user.UserEntity;
import com.vieiratelier.access.domain.exception.user.UserAlreadyExistsException;
import com.vieiratelier.access.domain.usecase.user.CreateUser;

public class CreateUserImpl implements CreateUser {

	private final UserRepository repository;
	private final IdGenerator idGenerator;
	private final PasswordEncoder passwordEncoder;


	public CreateUserImpl(UserRepository repository, IdGenerator idGenerator, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.idGenerator = idGenerator;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public final UserEntity execute(String firstName, String lastName, String email, String password) {
		if(repository.findByEmail(email) != null) {
			throw new UserAlreadyExistsException(email);
		}
//		FALTA VALIDAR OS DADOS E CRIAR
		String userId = idGenerator.execute();
		String encryptedPassword = passwordEncoder.execute(password);
		String emailVerificationToken = null;
		UserEntity userEntity = new UserEntity(userId, firstName, lastName, email, encryptedPassword, emailVerificationToken);
		return repository.create(userEntity);
	}
}
