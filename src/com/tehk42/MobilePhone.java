package com.tehk42;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public void printContacts() {
        System.out.println("You have " + myContacts.size() + " contacts.");
        for(int i = 0; i < myContacts.size(); i++) {
            System.out.println((i+1) +". " + myContacts.get(i).getName() + " -> " +
                                            myContacts.get(i).getPhoneNumber());
        }
    }

    public boolean addPhoneNumber(Contact name) {
        if(findContact(name.getName()) >= 0) {
            System.out.println("Contact has already been added");
            return false;
        } else {
            myContacts.add(name);
            return true;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundContact = findContact(oldContact);
        if(foundContact < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }
        this.myContacts.set(foundContact, newContact);
        System.out.println(oldContact.getName() + " has been replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int noContact = findContact(contact);
        if(noContact < 0) {
            System.out.println(contact.getName() + " was not found.");
            return false;
        }
        System.out.println(contact.getName() + " has been removed.");
        myContacts.remove(contact);
        return true;
    }

    private int findContact(Contact name) {
        return myContacts.indexOf(name);
    }

    private int findContact(String contactName) {
        for(int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact) {
        if(findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String contact) {
        int position = findContact(contact);
        if(position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }
}
