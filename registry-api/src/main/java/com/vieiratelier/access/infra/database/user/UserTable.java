package com.vieiratelier.access.infra.database.user;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.vieiratelier.access.infra.database.address.AddressTable;

@Entity(name = "users")
public class UserTable implements Serializable {

	private static final long serialVersionUID = -1965679100070156022L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 120)
	private String email;

	@Column(nullable = false, length = 70)// maximo de bcrypt é de 60 carcteres
	private String encryptedPassword;

	private String emailVerificationToken;

	@Column(nullable = false)
	private Boolean emailVerificationStatus = false;

//	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
//	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(nullable = false, columnDefinition = "DATETIME(0)")
	private LocalDateTime creationDate;
	
	
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AddressTable> addresses;

//	COMO TENHO ESTE CONSTRUTOR PRIVADO SO ACEDEM PELO METODO MAS A CENA È 
//	SERA QUE ELE DEVOLE DA DB UM USERTABLE COMO SE NAO TENHO CONSTRUTOR E OUTRA CENA 
//	SE ELE USAR ESTE CONSTRUTOR VER SE PASSA O ID PQ O CONSTUTOR NAO TEM

	UserTable() { }
	
//	public UserTable(String userId, String firstName, String lastName, String email, String encryptedPassword,
//			String emailVerificationToken, Boolean emailVerificationStatus, LocalDateTime creationDate) {
//		this.userId = userId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.encryptedPassword = encryptedPassword;
//		this.emailVerificationToken = emailVerificationToken;
//		this.emailVerificationStatus = emailVerificationStatus;
//		this.creationDate = creationDate;
//	}
	

	public UserTable(Long id, String userId, String firstName, String lastName, String email, String encryptedPassword,
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
		this.addresses = new ArrayList<>();;
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

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<AddressTable> getAddresses() {
		return addresses;
	}
}
