package com.vieiratelier.access.boundary.dto.user;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserDto implements Serializable {

	private static final long serialVersionUID = -1840123226597883368L;
	public Long id; // TESTE DOS UDPDATES
	public String userId;
	public String firstName;
	public String lastName;
	public String email;
//	protected String password;
	public String encryptedPassword;
	public String emailVerificationToken;
	public Boolean emailVerificationStatus;
	public LocalDateTime creationDate;
	
	public UserDto() {}
	
	
//	TESTE DOS UPDATES
	public UserDto(Long id, String userId, String firstName, String lastName, String email, String encryptedPassword,
			String emailVerificationToken, Boolean emailVerificationStatus, LocalDateTime creationDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.encryptedPassword = encryptedPassword;
		this.emailVerificationToken = emailVerificationToken;
		this.emailVerificationStatus = emailVerificationStatus;
		this.creationDate = creationDate;
	}



//	public UserDto(String userId, String firstName, String lastName, String email, 
//			String encryptedPassword, String emailVerificationToken, LocalDateTime creationDate) {
//		this.userId = userId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.encryptedPassword = encryptedPassword;
//		this.emailVerificationToken = emailVerificationToken;
//		this.emailVerificationStatus = false;
//		this.creationDate = creationDate;
//	}

}
