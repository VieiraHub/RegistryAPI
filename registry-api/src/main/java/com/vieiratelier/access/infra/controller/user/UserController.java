package com.vieiratelier.access.infra.controller.user;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vieiratelier.access.infra.presenter.global.OperationResult;
import com.vieiratelier.access.infra.presenter.user.request.UserRequest;
import com.vieiratelier.access.infra.presenter.user.response.UserResponse;


public interface UserController extends UserDetailsService {
	UserResponse create(UserRequest userRequest);
	OperationResult delete(String userId);
	UserResponse findUserByEmail(String email);
	UserResponse findUserById(String userId);
	List<UserResponse> findUsers(int page, int limit);
	UserResponse update(String userId, UserRequest userRequest);
}
