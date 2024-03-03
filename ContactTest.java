package com.snhu.mobile.app;

import org.junit.jupiter.api.Test;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;


public class ContactTest {
	
	private static Validator validator;
	
	@BeforeAll
    static void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	void testContact_AllValid() {
		Contact contact = getContact();
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
        assertTrue(violations.size() == 0);
		assertNotNull(contact.getContactId());
		assertNotNull(contact.getFirstName());
		assertNotNull(contact.getLastName());
		assertNotNull(contact.getPhone());
		assertNotNull(contact.getAddress());
	}
	
	@Test
	void testContact_ContactId_Null() {
		Contact contact = new Contact(null, "priya", "saravana", "9239739110", "22 wall st, NY. 18492" );
		boolean isPassed = false;
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
		for (ConstraintViolation<Contact> error : violations) {
			if(error.getMessage().equalsIgnoreCase("contact id should not be null")) {
				isPassed = true;
			}
		}
		assertTrue(isPassed);
	}
	
	@Test
	void testContact_FirstName_Null() {
		Contact contact = getContact();
		contact.setFirstName(null);
		boolean isPassed = false;
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
		for (ConstraintViolation<Contact> error : violations) {
			if(error.getMessage().equalsIgnoreCase("first name should not be null"))
				isPassed = true;
		}
		assertTrue(isPassed);
	}
	
	@Test
	void testContact_LastName_Null() {
		Contact contact = getContact();
		contact.setLastName(null);
		boolean isPassed = false;
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
		for (ConstraintViolation<Contact> error : violations) {
			if(error.getMessage().equalsIgnoreCase("last name should not be null"))
				isPassed = true;
		}
		assertTrue(isPassed);
	}
	
	@Test
	void testContact_Phone_Null() {
		Contact contact = getContact();
		contact.setPhone(null);
		boolean isPassed = false;
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
		for (ConstraintViolation<Contact> error : violations) {
			if(error.getMessage().equalsIgnoreCase("phone should not be null"))
				isPassed = true;
		}
		assertTrue(isPassed);
	}
	
	@Test
	void testContact_Address_Null() {
		Contact contact = getContact();
		contact.setAddress(null);
		boolean isPassed = false;
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
		for (ConstraintViolation<Contact> error : violations) {
			if(error.getMessage().equalsIgnoreCase("address should not be null"))
				isPassed = true;
		}
		assertTrue(isPassed);
	}
	
	
	@Test
	void testContact_ContactId_MaxLength_Fail() {
		Contact contact = new Contact("46372980169", "priya", "saravana", "9239739110", "22 wall st, NY. 18492" );
		boolean isPassed = false;
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
		for (ConstraintViolation<Contact> error : violations) {
			if(error.getMessage().equalsIgnoreCase("contact id length should not exceed 10"))
				isPassed = true;
		}
		assertTrue(isPassed);
	}
	
	@Test
	void testContact_FirstName_MaxLength_Fail() {
		Contact contact = getContact();
		contact.setFirstName("robert maxwell");
		boolean isPassed = false;
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
		for (ConstraintViolation<Contact> error : violations) {
			if(error.getMessage().equalsIgnoreCase("first name length should not exceed 10"))
				isPassed = true;
		}
		assertTrue(isPassed);
	}
	
	@Test
	void testContact_LastName_MaxLength_Fail() {
		Contact contact = getContact();
		contact.setLastName("saravanakumar");
		boolean isPassed = false;
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
		for (ConstraintViolation<Contact> error : violations) {
			if(error.getMessage().equalsIgnoreCase("last name length should not exceed 10"))
				isPassed = true;
		}
		assertTrue(isPassed);
	}
	
	@Test
	void testContact_Phone_MaxLength_Fail() {
		Contact contact = getContact();
		contact.setPhone("32489340347");
		boolean isPassed = false;
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
		for (ConstraintViolation<Contact> error : violations) {
			if(error.getMessage().equalsIgnoreCase("phone number should be exactly 10 digits"))
				isPassed = true;
		}
		assertTrue(isPassed);
	}
	
	@Test
	void testContact_Phone_MinLength_Fail() {
		Contact contact = getContact();
		contact.setPhone("3248934");
		boolean isPassed = false;
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
		for (ConstraintViolation<Contact> error : violations) {
			if(error.getMessage().equalsIgnoreCase("phone number should be exactly 10 digits"))
				isPassed = true;
		}
		assertTrue(isPassed);
	}
	
	@Test
	void testContact_Address_MaxLength_Fail() {
		Contact contact = getContact();
		contact.setAddress("108324 wall street, Newyork. Zipcode 18492");
		boolean isPassed = false;
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
		for (ConstraintViolation<Contact> error : violations) {
			if(error.getMessage().equalsIgnoreCase("address length should not exceed 30"))
				isPassed = true;
		}
		assertTrue(isPassed);
	}
	
	public Contact getContact() {
		Contact contact = new Contact("1", "priya", "saravana", "9239739110", "22 wall st, NY. 18492" );
		return contact;
	}

}
