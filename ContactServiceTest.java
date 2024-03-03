package com.snhu.mobile.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class ContactServiceTest {
	
	private static ContactService contactService;
	
	@BeforeAll
    static void setup() {
		contactService = new ContactService();
		contactService.setContactMap(populateContactMap());
	}
	
	@AfterAll
	static void tearDown() {
		contactService = null;
	}
	
	@Test
	void testAddContact_Valid() {
		Contact contact = new Contact("4", "ross", "david", "1892939309", "100 goodwick st, IL. 19793");
		assertTrue(contactService.addContact(contact));
	}
	
	@Test
	void testAddContact_InValid() {
		Contact contact = new Contact("1", "ross", "david", "1892939309", "100 goodwick st, IL. 19793");
		assertFalse(contactService.addContact(contact));
	}
	
	@Test
	void testUpdateContact_Valid() {
		Contact contact = new Contact("1", "priya", "saravana", "9239739110", "22 wall st, NY. 18492");
		contact.setFirstName("Thridev");
		contact.setLastName("Thea");
		contact.setPhone("3894329859");
		contact.setAddress("200 patrik st, MD. 19803");
		assertTrue(contactService.updateContact(contact));
		assertEquals("Thridev", contactService.getContactMap().get(contact.getContactId()).getFirstName());
		assertEquals("Thea", contactService.getContactMap().get(contact.getContactId()).getLastName());
		assertEquals("3894329859", contactService.getContactMap().get(contact.getContactId()).getPhone());
		assertEquals("200 patrik st, MD. 19803", contactService.getContactMap().get(contact.getContactId()).getAddress());
	}
	
	@Test
	void testUpdateContact_InValid() {
		Contact contact = new Contact("5", "ross", "david", "1892939309", "100 goodwick st, IL. 19793");
		contact.setFirstName("Robin");
		assertFalse(contactService.updateContact(contact));
	}
	
	@Test
	void testDeleteContact_Valid() {
		Contact contact = new Contact("3", "arun", "selva", "8929293443", "24 queen st, DE. 19702");
		assertTrue(contactService.deleteContact(contact));
	}
	
	@Test
	void testDeleteContact_InValid() {
		Contact contact = new Contact("5", "ross", "david", "1892939309", "100 goodwick st, IL. 19793");
		assertFalse(contactService.deleteContact(contact));
	}
	
	public static Map<String, Contact> populateContactMap() {
		Map<String, Contact> contactMap = new HashMap<String, Contact>();
		Contact contact = new Contact("1", "priya", "saravana", "9239739110", "22 wall st, NY. 18492");
		contactMap.put(contact.getContactId(), contact);
		contact = new Contact("2", "rahul", "kumar", "2893289329", "23 king st, NJ. 08043");		
		contactMap.put(contact.getContactId(), contact);
		contact = new Contact("3", "arun", "selva", "8929293443", "24 queen st, DE. 19702");
		contactMap.put(contact.getContactId(), contact);
		return contactMap;
	}

}
