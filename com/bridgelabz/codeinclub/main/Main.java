package com.bridgelabz.codeinclub.main;

import com.bridgelabz.codeinclub.utils.LoadData;
import com.bridgelabz.codeinclub.utils.AddressBookUtil;
import com.bridgelabz.codeinclub.services.AddressBookService;
import com.bridgelabz.codeinclub.services.AddressBook;

/**
Handler: This class contains main class and handles everyother package and class in this project.
@author Abhishek Agarwal
*/
public class Main {
    public static void main(String[] dp){
        final AddressBookService addressBookService = new AddressBook();
        System.out.println("Welcome to address book");
        addressBookService.loadData();
        while(true){
            System.out.println("-------------------------------");
            System.out.print("View the options carefully and choose\n1. Add contact \n2. View contact \n3. Edit contact \n4. Sort contacts \n5. Delete contact\n6. Save changes & Quit \n7. Quit without saving \nEnter your option: ");

            final int option = AddressBookUtil.getUserNumber();
            switch(option){
                case 1:
                    addressBookService.addPerson();
                    System.out.println("contact added ->");
                break;
                case 2:
                    System.out.println("Displaying Contacts ->");
                    addressBookService.display();
                break;
                case 3:
                    addressBookService.editPerson();
                break;
                case 4:
                    addressBookService.sort();
                break;
                case 5:
                    addressBookService.deletePerson();
                break;
                case 6:
                    addressBookService.save();
                    System.out.println("Quiting...");
                    System.exit(0);
                case 7:
                    System.out.println("Quiting...");
                    System.exit(0);
                default:
                    System.out.println("Error: Invalid Entry, Try again");
            }
        }

    }
}
