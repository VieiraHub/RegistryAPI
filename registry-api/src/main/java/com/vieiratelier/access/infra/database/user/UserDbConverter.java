package com.vieiratelier.access.infra.database.user;

import com.vieiratelier.access.boundary.dto.user.UserDto;

public class UserDbConverter {

	public static final UserTable fromDto(UserDto userDto) {
		return userDto != null
				? new UserTable(userDto.id, userDto.userId, userDto.firstName, userDto.lastName, userDto.email,
				userDto.encryptedPassword, userDto.emailVerificationToken, userDto.emailVerificationStatus,
				userDto.creationDate) : null;
	}

	public static final UserDto fromTable(UserTable userTable) {
		return userTable != null
				? new UserDto(userTable.getId(), userTable.getUserId(), userTable.getFirstName(),
						userTable.getLastName(), userTable.getEmail(), userTable.getEncryptedPassword(),
						userTable.getEmailVerificationToken(), userTable.getEmailVerificationStatus(),
						userTable.getCreationDate()) : null;
	}
}
