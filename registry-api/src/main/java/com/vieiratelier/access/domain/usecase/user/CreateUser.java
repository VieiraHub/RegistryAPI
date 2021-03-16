package com.vieiratelier.access.domain.usecase.user;

import com.vieiratelier.access.domain.entity.user.UserEntity;

public interface CreateUser {
	UserEntity execute(String firstName, String lastName, String email, String password);
}
