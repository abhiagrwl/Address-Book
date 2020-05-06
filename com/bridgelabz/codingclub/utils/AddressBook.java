package com.bridgelabz.codingclub.utils;


import com.bridgelabz.codingclub.models.Contact;
import com.bridgelabz.codingclub.services.AddressBookServiceImp;
import java.utils.*;

public class AddressBook
{

	final private List<Contact> addressBook = new ArrayList<>();

		public void addToAddressBook(final Contact contact)
		{
			addressBook.add(contact);
		}

		public void displayContacts()
		{
			for(Contact con : addressBook){
            System.out.println("------------------");
            System.out.println("Name: "+con.getName());
            System.out.println("Address: "+con.getAddress());
            System.out.println("Phone: "+con.getPhone())
		}

		public void sortContacts()
		{	Collections.sort(addressBook);

			for(Contact con : addressBook){
            System.out.println("------------------");
            System.out.println("Name: "+con.getName());
            System.out.println("Address: "+con.getAddress());
            System.out.println("Phone: "+con.getPhone())
		}

		public void delete(final Contact contact)
		{	
			addressBook.remove(index);
			
		}


}



