package com.bridgelabz.codingclub.main;

import com.bridgelabz.codingclub.utils.AddressBook;
import com.bridgelabz.codingclub.utils.AddressBookUtil;
import com.bridgelabz.codingclub.services.AddressBookService;
import com.bridgelabz.codingclub.services.AddressBookServiceImp;



import java.io.*;
import java.util.*;


public class Main
{

	private static void menu()
	{

		System.out.println("1.Add a new contact to your address book.");
		System.out.println("2. Edit a new contact from your address book.");
		System.out.println("3. Print out all info from  address book.");
		System.out.println("4. Sort the contacts of your address book.");
		System.out.println("5. Delete a contact");
		System.out.println("6. Quit.");
		System.out.println(". Enter your menu Choice.");
	}

	public static void main(String[] args)
	{	

		final AddressBookService addressBookService = new AddressBookServiceImp(new AddressBook());
		while(true)
		{
			menu();
			final int option = AddressBookUtil.getUserNumber();
			switch(option)
			{
				case 1:
					System.out.println("Adding Contact");
					addressBookService.addContact();
					break;
				case 2:
					System.out.println("Edit the Contact");
					addressBookService.editContact();
					break;

				case 3:
					System.out.println("Displaying all the contacts of address Book");
					addressBookService.displayAll();
					break;
				case 4:
					System.out.println("Sorting the content");
					addressBookService.sortAll();
					break;
				case 5:
					System.out.println("Deleting a contact");
					addressBookService.deleteContact();
					break;
				case 6:
					System.out.println("Exiting from teh system");
					System.exit(0);
					break;
			}
			menu();
		}	
	
	}
}




