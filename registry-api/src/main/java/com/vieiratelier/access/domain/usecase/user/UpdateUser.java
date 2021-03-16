package com.vieiratelier.access.domain.usecase.user;

import com.vieiratelier.access.domain.entity.user.UserEntity;

public interface UpdateUser {
	UserEntity execute(String userId, String firstName, String lastName);
}
