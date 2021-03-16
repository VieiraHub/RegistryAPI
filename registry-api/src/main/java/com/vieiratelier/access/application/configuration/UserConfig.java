package com.vieiratelier.access.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vieiratelier.access.boundary.port.IdGenerator;
import com.vieiratelier.access.boundary.port.PasswordEncoder;
import com.vieiratelier.access.boundary.repository.user.UserDataProvider;
import com.vieiratelier.access.boundary.repository.user.UserRepository;
import com.vieiratelier.access.boundary.repository.user.UserRepositoryImpl;
import com.vieiratelier.access.boundary.service.user.UserService;
import com.vieiratelier.access.boundary.service.user.UserServiceImpl;
import com.vieiratelier.access.domain.usecase.user.CreateUser;
import com.vieiratelier.access.domain.usecase.user.DeleteUser;
import com.vieiratelier.access.domain.usecase.user.FindByEmail;
import com.vieiratelier.access.domain.usecase.user.FindByUserId;
import com.vieiratelier.access.domain.usecase.user.FindUsers;
import com.vieiratelier.access.domain.usecase.user.UpdateUser;
import com.vieiratelier.access.domain.usecase.user.impl.CreateUserImpl;
import com.vieiratelier.access.domain.usecase.user.impl.DeleteUserImpl;
import com.vieiratelier.access.domain.usecase.user.impl.FindByEmailImpl;
import com.vieiratelier.access.domain.usecase.user.impl.FindByUserIdImpl;
import com.vieiratelier.access.domain.usecase.user.impl.FindUsersImpl;
import com.vieiratelier.access.domain.usecase.user.impl.UpdateUserImpl;

@Configuration
public class UserConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoderConfig() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean  PORQUE METI @COMPONENT NA DATAPROVIDERIMPL
//	public DataProvider dataProviderConfig(JpaDataProvider provider) {
//		return new DataProviderImpl(provider);
//	}
	
	@Bean
	public UserRepository userRepositoryConfig(UserDataProvider dataprovider) {
		return new UserRepositoryImpl(dataprovider);
	}
	
	@Bean
	public UserService userServiceConfig(
			CreateUser create, DeleteUser delete, FindByEmail findByEmail, 
			FindByUserId findByUserId, FindUsers findUsers, UpdateUser update) {
		return new UserServiceImpl(create, delete, findByEmail, findByUserId, findUsers, update);
	}
	
	@Bean 
	public CreateUser createUserConfig(UserRepository repository, IdGenerator idGenerator, PasswordEncoder passwordEncoder) {
		return new CreateUserImpl(repository, idGenerator, passwordEncoder);
	}
	
	@Bean 
	public DeleteUser deleteUserConfig(UserRepository repository) {
		return new DeleteUserImpl(repository);
	}
	
	@Bean 
	public FindByEmail getByEmailConfig(UserRepository repository) {
		return new FindByEmailImpl(repository);
	}
	
	@Bean 
	public FindByUserId getByUserIdConfig(UserRepository repository) {
		return new FindByUserIdImpl(repository);
	}
	
	@Bean 
	public FindUsers getUsersConfig(UserRepository repository) {
		return new FindUsersImpl(repository);
	}
	
	@Bean 
	public UpdateUser updateUserConfig(UserRepository repository) {
		return new UpdateUserImpl(repository);
	}
}
