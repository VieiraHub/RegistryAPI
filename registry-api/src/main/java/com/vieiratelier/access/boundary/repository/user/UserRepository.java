package com.vieiratelier.access.boundary.repository.user;

import java.util.List;

import com.vieiratelier.access.domain.entity.user.UserEntity;

public interface UserRepository {
	UserEntity create(UserEntity userEntity);
	Boolean delete(UserEntity userEntity);
	UserEntity findByEmail(String email);
	UserEntity findByUserId(String userId);
	List<UserEntity> findUsers(int page, int limit);
	UserEntity update(UserEntity userEntity);
}
