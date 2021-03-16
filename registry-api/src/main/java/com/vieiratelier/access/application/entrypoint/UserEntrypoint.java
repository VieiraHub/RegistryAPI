package com.vieiratelier.access.application.entrypoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vieiratelier.access.infra.controller.user.UserController;
import com.vieiratelier.access.infra.presenter.global.OperationResult;
import com.vieiratelier.access.infra.presenter.user.request.UserRequest;
import com.vieiratelier.access.infra.presenter.user.response.UserResponse;

@RestController
@RequestMapping("users")
public class UserEntrypoint {

	@Autowired
	private final UserController controller;

	public UserEntrypoint(UserController controller) {
		this.controller = controller;
	}

	@PostMapping
	UserResponse createUser(@RequestBody UserRequest userRequest) {
		return controller.create(userRequest);
	}
	
	@DeleteMapping(path = "/{userId}")
	public OperationResult deleteUser(@PathVariable String userId) {
		return controller.delete(userId);
	}
	
	@GetMapping(path = "/{userId}")
	public UserResponse findUserById(@PathVariable String userId) {
		return controller.findUserById(userId);
	}
	
	@GetMapping
	public List<UserResponse> findUsers(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "5") int limit) {
		return controller.findUsers(page, limit);
	}
	
	@PutMapping(path = "/{userId}")
	public UserResponse updateUser(@PathVariable String userId, @RequestBody UserRequest userRequest) {
		return controller.update(userId, userRequest);
	}
	
}
