package com.vieiratelier.access.domain.entity.user;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserEntity implements Serializable {

	private static final long serialVersionUID = 8176393965961610194L;
	
	private Long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String encryptedPassword;
	private String emailVerificationToken;
	private Boolean emailVerificationStatus;
	private LocalDateTime creationDate;

	UserEntity() {
	}

	public UserEntity(String userId, String firstName, String lastName, String email, String encryptedPassword,
			String emailVerificationToken) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.encryptedPassword = encryptedPassword;
		this.emailVerificationToken = emailVerificationToken;
		this.emailVerificationStatus = false;
		this.creationDate = LocalDateTime.now();
	}

	public UserEntity(Long id, String userId, String firstName, String lastName, String email, String encryptedPassword,
			String emailVerificationToken, Boolean emailVerificationStatus, LocalDateTime creationDate) {
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

	public Long getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	protected void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}
}
