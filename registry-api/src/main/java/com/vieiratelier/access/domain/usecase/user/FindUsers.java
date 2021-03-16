package com.vieiratelier.access.domain.usecase.user;

import java.util.List;

import com.vieiratelier.access.domain.entity.user.UserEntity;

public interface FindUsers {
	List<UserEntity> execute(int page, int limit);
}
