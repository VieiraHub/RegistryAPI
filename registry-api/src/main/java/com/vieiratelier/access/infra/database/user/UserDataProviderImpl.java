package com.vieiratelier.access.infra.database.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.vieiratelier.access.boundary.dto.user.UserDto;
import com.vieiratelier.access.boundary.repository.user.UserDataProvider;



@Component
public class UserDataProviderImpl implements UserDataProvider {

	private final UserJpaProvider provider;

	public UserDataProviderImpl(UserJpaProvider provider) {
		this.provider = provider;
	}

	@Override
	public UserDto create(UserDto userDto) {
		return UserDbConverter.fromTable(provider.save(UserDbConverter.fromDto(userDto)));
	}

	@Override
	public Boolean delete(UserDto userDto) {
		UserTable user = UserDbConverter.fromDto(userDto); 
		provider.delete(user);
		return true;
	}

	@Override
	public UserDto findByEmail(String email) {
		UserTable userTable = provider.findByEmail(email);
		// PODE SER NULL POR UM IF SENAO RETORNA NULL
		if (userTable == null)
			return null;
		return UserDbConverter.fromTable(userTable);
	}

	@Override
	public UserDto findByUserId(String userId) {
		UserTable userTable = provider.findByUserId(userId);
		if (userTable == null)
			return null;
		return UserDbConverter.fromTable(userTable);
	}

	@Override
	public List<UserDto> findUsers(int page, int limit) {
		List<UserDto> returnValue = new ArrayList<>();
		Pageable pageableRequest = PageRequest.of(page, limit);
		List<UserTable> usersList = provider.findAll(pageableRequest).getContent();
		for (UserTable userTable : usersList) {
			UserDto userDto = UserDbConverter.fromTable(userTable);
			returnValue.add(userDto);
		}
		return returnValue;
	}
	

	@Override
	public UserDto update(UserDto userDto) {
		UserTable response = provider.save(UserDbConverter.fromDto(userDto));
		return UserDbConverter.fromTable(response);
	}
}
