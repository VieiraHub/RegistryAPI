package com.vieiratelier.access.infra.database.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaProvider extends PagingAndSortingRepository<UserTable, Long>  {
	UserTable findByEmail(String email);
	UserTable findByUserId(String userId);
}
