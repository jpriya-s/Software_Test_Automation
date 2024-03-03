package com.snhu.mobile.app;

import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


public class Contact {
	
	@NotNull(message = "contact id should not be null")
	@Length(max = 10, message = "contact id length should not exceed 10")
	private String contactId;
	
	@NotNull (message = "first name should not be null")
	@Length(max = 10, message = "first name length should not exceed 10")
	private String firstName;
	
	@NotNull (message = "last name should not be null")
	@Length(max = 10, message = "last name length should not exceed 10")
	private String lastName;
	
	@NotNull (message = "phone should not be null")
	@Length(min = 10, max = 10, message = "phone number should be exactly 10 digits")
	private String phone;
	
	@NotNull (message = "address should not be null")
	@Length(max = 30, message = "address length should not exceed 30")
	private String address;
	
	
	public Contact(String contactId, String firstName,String lastName,String phone, String address) {
		super();
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	public String getContactId() {
		return contactId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
