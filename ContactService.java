package com.snhu.mobile.app;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	private Map<String, Contact> contactMap = new HashMap<>();
	
	public boolean addContact(Contact contact) {
		if (contactMap.containsKey(contact.getContactId())) {
			return false;
		} else {
			contactMap.put(contact.getContactId(), contact);
			return true;
		}
	}
	
	public boolean updateContact(Contact contact) {
		if (contactMap.containsKey(contact.getContactId())) {
			contactMap.get(contact.getContactId()).setFirstName(contact.getFirstName());
			contactMap.get(contact.getContactId()).setLastName(contact.getLastName());
			contactMap.get(contact.getContactId()).setPhone(contact.getPhone());
			contactMap.get(contact.getContactId()).setAddress(contact.getAddress());
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteContact(Contact contact) {
		if (contactMap.containsKey(contact.getContactId())) {
			contactMap.remove(contact.getContactId());
			return true;
		} else {
			return false;
		}
	}

	public Map<String, Contact> getContactMap() {
		return contactMap;
	}

	public void setContactMap(Map<String, Contact> contactMap) {
		this.contactMap = contactMap;
	}

	
}
