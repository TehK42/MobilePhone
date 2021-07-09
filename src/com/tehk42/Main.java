package com.tehk42;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("708 65 37");
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryForContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }
    private static void printInstructions() {
        System.out.println("\n Press ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print list of contacts.");
        System.out.println("\t 2 - To add a new contact.");
        System.out.println("\t 3 - To update a contact.");
        System.out.println("\t 4 - To remove an contact.");
        System.out.println("\t 5 - To query for an existing contact.");
        System.out.println("\t 6 - To quit the mobile phone.");
    }

    private static void addContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter contact number: ");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name,number);
        mobilePhone.addPhoneNumber(newContact);
        System.out.println("Added " + newContact.getName() + ", " + newContact.getPhoneNumber());
    }

    private static void updateContact() {
        System.out.println("Enter contact to replace: ");
        String oldContact = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(oldContact);
        if(existingContact == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println("Enter contact name: ");
            String name = scanner.nextLine();
            System.out.println("Enter contact number: ");
            String number = scanner.nextLine();
            Contact newContact = Contact.createContact(name,number);
            if(mobilePhone.updateContact(existingContact, newContact)) {
                System.out.println("Successfully updated record.");
            } else {
                System.out.println("Error updating record.");
            }
        }
    }

    private static void removeContact() {
        System.out.println("Enter contact to remove: ");
        String removedContact = scanner.nextLine();
        Contact removeContact = mobilePhone.queryContact(removedContact);
        if(mobilePhone.removeContact(removeContact)) {
            System.out.println("Successfully removed contact.");
        } else {
            System.out.println("Error removing contact.");
        }
    }

    private static void queryForContact() {
        System.out.println("Enter contact to query for: ");
        String queryContact = scanner.nextLine();
        Contact query = mobilePhone.queryContact(queryContact);
        if(query == null) {
            System.out.println("Contact has not been found.");
        } else {
            System.out.println("Found " + mobilePhone.queryContact(query) + " in contacts list.");
        }
    }
}

