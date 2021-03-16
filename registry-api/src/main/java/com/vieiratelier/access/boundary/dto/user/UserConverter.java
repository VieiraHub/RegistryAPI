package com.vieiratelier.access.boundary.dto.user;

import java.util.ArrayList;
import java.util.List;

import com.vieiratelier.access.domain.entity.user.UserEntity;

public class UserConverter {
	public static final UserDto fromEntity(UserEntity userEntity) {
		if (userEntity == null)
			return null;
		return new UserDto(userEntity.getId(), userEntity.getUserId(), userEntity.getFirstName(),
				userEntity.getLastName(), userEntity.getEmail(), userEntity.getEncryptedPassword(),
				userEntity.getEmailVerificationToken(), userEntity.getEmailVerificationStatus(),
				userEntity.getCreationDate());
	}

	public static final UserEntity fromDto(UserDto userDto) {
		if (userDto == null)
			return null;
		return new UserEntity(userDto.id, userDto.userId, userDto.firstName, userDto.lastName,
				userDto.email, userDto.encryptedPassword, userDto.emailVerificationToken,
				userDto.emailVerificationStatus, userDto.creationDate);
	}
	
	public static final List<UserDto> fromEntityList(List<UserEntity> usersList) {
		List<UserDto> listDto = new ArrayList<>();
		for (UserEntity userEntity : usersList) {
			listDto.add(fromEntity(userEntity));
		}
		return listDto;
	}
	
	public static final List<UserEntity> fromDtoList(List<UserDto> usersList) {
		List<UserEntity> listEntity = new ArrayList<>();
		for (UserDto userDto : usersList) {
			listEntity.add(fromDto(userDto));
		}
		return listEntity;
	}
}
