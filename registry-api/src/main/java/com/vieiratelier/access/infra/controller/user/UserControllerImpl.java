package com.vieiratelier.access.infra.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vieiratelier.access.boundary.dto.user.UserDto;
import com.vieiratelier.access.boundary.service.user.UserService;
import com.vieiratelier.access.infra.presenter.global.OperationNameEnum;
import com.vieiratelier.access.infra.presenter.global.OperationResultEnum;
import com.vieiratelier.access.infra.presenter.global.OperationResult;
import com.vieiratelier.access.infra.presenter.user.request.UserRequest;
import com.vieiratelier.access.infra.presenter.user.response.UserResponse;


@Service
public class UserControllerImpl implements UserController {

	private final UserService service;

	public UserControllerImpl(UserService service) {
		this.service = service;
	}

	private final UserResponse fromDto(UserDto userDto) {
		return new UserResponse(userDto.userId, userDto.firstName, userDto.lastName, userDto.email);
	}

	@Override
	public UserResponse create(UserRequest userRequest) {
		UserResponse response = fromDto(service.create(userRequest.firstName, userRequest.lastName,
				userRequest.email, userRequest.password));
		return response;
	}

	@Override
	public OperationResult delete(String userId) {
		OperationResult response = new OperationResult(OperationNameEnum.DELETE);
		Boolean result = service.delete(userId);
		if (result)  response.setOperationResult(OperationResultEnum.SUCCESS);
		else response.setOperationResult(OperationResultEnum.ERROR);
		return response;
	}

	@Override
	public UserResponse findUserByEmail(String email) {
		return fromDto(service.getByEmail(email));
	}

	@Override
	public UserResponse findUserById(String userId) {
		return fromDto(service.getByUserId(userId));
	}

	@Override
	public List<UserResponse> findUsers(int page, int limit) {
		List<UserDto> listDto = service.findUsers(page, limit);
		List<UserResponse> response = new ArrayList<>();
		for(UserDto user : listDto) {
			response.add(fromDto(user));
		}
		return response;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDto userDto = service.getByEmail(email);
		if (userDto == null) throw new UsernameNotFoundException(email);
		return new User(email, userDto.encryptedPassword, new ArrayList<>());
	}

	@Override
	public UserResponse update(String userId, UserRequest userRequest) {
		return fromDto(service.update(userId, userRequest.firstName, userRequest.lastName));
	}
}
