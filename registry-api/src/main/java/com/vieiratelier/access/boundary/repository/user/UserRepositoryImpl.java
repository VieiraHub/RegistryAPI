package com.vieiratelier.access.boundary.repository.user;

import java.util.List;

import com.vieiratelier.access.boundary.dto.user.UserConverter;
import com.vieiratelier.access.boundary.dto.user.UserDto;
import com.vieiratelier.access.domain.entity.user.UserEntity;

public class UserRepositoryImpl implements UserRepository {

	private final UserDataProvider dataprovider;

	public UserRepositoryImpl(UserDataProvider dataprovider) {
		this.dataprovider = dataprovider;
	}

	@Override
	public UserEntity create(UserEntity userEntity) {
		return UserConverter.fromDto(dataprovider.create(UserConverter.fromEntity(userEntity)));
	}

	@Override
	public Boolean delete(UserEntity userEntity) {
		if (dataprovider.delete(UserConverter.fromEntity(userEntity))) return true;
		return false;
	}

	@Override
	public UserEntity findByEmail(String email) {
		UserDto userDto = dataprovider.findByEmail(email);
		return UserConverter.fromDto(userDto);
	}

	@Override
	public UserEntity findByUserId(String userId) {
		UserDto user = dataprovider.findByUserId(userId);
		System.out.println(user.id + "TESSTEEEEEEEE");
		return UserConverter.fromDto(user);
	}

	@Override
	public List<UserEntity> findUsers(int page, int limit) {
		List<UserDto> returnValue = dataprovider.findUsers(page, limit);
		return UserConverter.fromDtoList(returnValue);
	}

	@Override
	public UserEntity update(UserEntity userEntity) {
		UserDto userDto = UserConverter.fromEntity(userEntity);
		System.out.println(userDto.id + "TESSTEEEEEEEE");
		UserDto user = dataprovider.update(userDto);
		System.out.println(user.id + "TESSTEEEEEEEE");
		return UserConverter.fromDto(user);
	}
}
