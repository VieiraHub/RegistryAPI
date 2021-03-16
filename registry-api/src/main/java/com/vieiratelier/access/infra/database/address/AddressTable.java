package com.vieiratelier.access.infra.database.address;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.vieiratelier.access.infra.database.user.UserTable;

@Entity(name = "addresses")
public class AddressTable implements Serializable {

	private static final long serialVersionUID = -8957047025501246232L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false)
	private String addressId;

	@Column(length = 15, nullable = false)
	private String city;

	@Column(length = 15, nullable = false)
	private String country;

	@Column(length = 100, nullable = false)
	private String streetName;

	@Column(length = 10, nullable = false)
	private String postalCode;

	@Column(length = 10, nullable = false)
	private String type;

	@ManyToOne
	@JoinColumn(name = "users_id")
	private UserTable userDetails;

	AddressTable() { }
	
	public AddressTable(Long id, String addressId, String city, String country, String streetName, String postalCode,
			String type, UserTable userDetails) {
		this.id = id;
		this.addressId = addressId;
		this.city = city;
		this.country = country;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.type = type;
		this.userDetails = userDetails;
	}

	public Long getId() {
		return id;
	}

	public String getAddressId() {
		return addressId;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getType() {
		return type;
	}

	public UserTable getUserDetails() {
		return userDetails;
	}
}
