package com.bridgelabz.codeinclub.services;

import com.bridgelabz.codeinclub.models.Person;
import com.bridgelabz.codeinclub.utils.CSVWriter;
import com.bridgelabz.codeinclub.utils.AddressBookUtil;
import com.bridgelabz.codeinclub.utils.LoadData;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

/**
InputOutput: This class helps in getting input data and displaying data.
@author Abhishek 
*/
public class AddressBook implements AddressBookService{
    final private ArrayList<Person> addressBook = new ArrayList<>();

    @Override
    public void addPerson() {
        // had some problem so added this line to patch it up;
        AddressBookUtil.getUserString();
        System.out.println("Don't use , or ;");
        System.out.print("Enter contact's First name: ");
        final String firstName = AddressBookUtil.getUserString();

        System.out.print("Enter contact's Last name: ");
        final String lastName = AddressBookUtil.getUserString();

        System.out.print("Enter contact's Address: ");
        final String address = AddressBookUtil.getUserString();

        System.out.print("Enter contact's City: ");
        final String city =  AddressBookUtil.getUserString();

        System.out.print("Enter contact's State: ");
        final String state = AddressBookUtil.getUserString();

        System.out.print("Enter contact's Zip code: ");
        final String zip = AddressBookUtil.getUserString();

        System.out.print("Enter contact's Phone number: ");
        final String phone = AddressBookUtil.getUserString();

        final Person person = new Person(firstName, lastName, address, city, state, zip, phone);
        addressBook.add(person);
    }

    @Override
    public void editPerson() {
        Person obj = getName();
        if(obj != null ){
            System.out.println("Don't use , or ;");
            System.out.print("Enter contact's Address: ");
            final String address = AddressBookUtil.getUserString();
            obj.setAddress(address);

            System.out.print("Enter contact's City: ");
            final String city =  AddressBookUtil.getUserString();
            obj.setCity(city);

            System.out.print("Enter contact's State: ");
            final String state = AddressBookUtil.getUserString();
            obj.setState(state);

            System.out.print("Enter contact's Zip code: ");
            final String zip = AddressBookUtil.getUserString();
            obj.setZip(zip);

            System.out.print("Enter contact's Phone number: ");
            final String phone = AddressBookUtil.getUserString();
            obj.setPhone(phone);
            save();

        }else{
            System.out.println("contact not found.");
        }
    }

    @Override
    public void deletePerson() {
        Person obj = getName();
        if(obj != null ){
            addressBook.remove(obj);
            System.out.println("contact deleted");
            save();
        }else{
            System.out.println("contact not found.");
        }
    }

    private Person getName(){
        AddressBookUtil.getUserString();
        display();
        System.out.print("Enter first name of contact you want delete/edit: ");
        String firstName = AddressBookUtil.getUserString();
        Person obj = serach(firstName);
        return obj;
    }
    @Override
    public void display(){
        for(Person obj : addressBook){
            System.out.println("------------------");
            System.out.println("Name: "+obj.getName());
            System.out.println("Address: "+obj.getAddress());
            System.out.println("Phone: "+obj.getPhone());
            System.out.println("Zip: "+obj.getZip());
        }
    }

    @Override
    public void save(){
        CSVWriter.writeAll(addressBook);
    }

    @Override
    public void loadData(){
        ArrayList<Person> tmp = LoadData.load();
        if(tmp.isEmpty()){
            System.out.println("Nothing to load from file.");
        }else{
            if(!addressBook.isEmpty()){
                addressBook.clear();
            }
            for(Person obj : tmp){
                addressBook.add(obj);
            }
            System.out.println("Data loaded from file");
        }
    }


    @Override
    public void sort(){
        System.out.println("1. Sort by name\n2. Sort by zip");
        System.out.print("Enter your choice: ");
        int choice = AddressBookUtil.getUserNumber();
        switch(choice){
            case 1:
                Collections.sort(addressBook, Person.nameSort);
                display();
            break;
            case 2:
                Collections.sort(addressBook, Person.zipSort);
                display();
            break;
            default:
                System.out.println("Wrong input.");
        }
    }

    private Person serach(String firstName){
        Person returnObj = null;
        for(Person obj : addressBook){
            if(firstName.equalsIgnoreCase(obj.getFirstName())){
                returnObj = obj;
                break;
            }
        }
        return returnObj;
    }
}
