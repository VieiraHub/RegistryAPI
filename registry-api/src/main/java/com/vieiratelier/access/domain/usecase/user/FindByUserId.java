package com.vieiratelier.access.domain.usecase.user;

import com.vieiratelier.access.domain.entity.user.UserEntity;

public interface FindByUserId {
	UserEntity execute(String userId);
}
