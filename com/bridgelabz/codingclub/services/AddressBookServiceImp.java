package com.bridgelabz.codingclub.services;

import com.bridgelabz.codingclub.utils.AddressBookUtil;
import com.bridgelabz.codingclub.models.Contact;
import com.bridgelabz.codingclub.utils.AddressBook;

public class AddressBookServiceImp implements AddressBookService
{
	
	final AddressBook addressBook;
	
    public AddressBookServiceImp(final AddressBook addressBook)
	{
		this.addressBook = addressBook;
	}



    @Override
    public void addContact()
    {

    	    System.out.println("Enter First name: ");
            final String firstName = AddressBookUtil.getUserString();

            System.out.println("Enter Last name: ");
            final String lastName = AddressBookUtil.getUserString();

            System.out.println("Enter Address: ");
            final String address = AddressBookUtil.getUserString();

            System.out.println("Enter City: ");
            final String city =  AddressBookUtil.getUserString();

            System.out.println("Enter State: ");
            final String state = AddressBookUtil.getUserString();

            System.out.println("Enter Phone number: ");
            final String phone = AddressBookUtil.getUserString();

            System.out.println("Enter Zip code: ");
            final String zip = AddressBookUtil.getUserString();

            final Contact contact = new Contact(firstName,lastName, address, city, state, phone, zip);
            addressBook.addToAddressBook(contact);

    }

    @Override
    public void editContact() 
    {
    	System.out.println("Editing the contact");

    }

    @Override
    public void deleteContact() 
    {
    	System.out.println("Enter which contact you want to delete via name");
        final String firstName = AddressBookUtil.getUserString();
        int index=-1;
            for (int i=0; i<=addressBook.size(); i++)
            {
                if (addressBook[i].getName().equals(firstName))
                    index = i;
            }
        addressBook.delete(addressBook[index]);
        System.out.println("Deleting the contact");
    }
    

    @Override
    public void display()
    {
        addressBook.displayContacts();
    }

    @Override
    public void sortAll()
    {   
        addressBook.sortContacts();
        System.out.println("Sorting the contacts");
    }
}