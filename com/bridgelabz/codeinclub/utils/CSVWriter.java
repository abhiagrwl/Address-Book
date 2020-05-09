package com.bridgelabz.codeinclub.utils;

import com.bridgelabz.codeinclub.models.Person;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;

/**
CSVWriter: This class writes address book data into file in csv format
@author Abhishek 
*/
public class CSVWriter {

    public static void writeAll(ArrayList<Person> persons){
        if(persons.isEmpty()){
            System.out.println("Nothing to write into file");
        }else{
            try{
                PrintWriter printwriter = new PrintWriter("com/bridgelabz/codeinclub/utils/data/AddressBook.csv");
                    for(Person person : persons){
                        String csv = person.getFirstName()+","+person.getLastName()+","+person.getAddress()+","+person.getCity()+","+person.getState()+","+person.getZip()+","+person.getPhone()+",;";
                        printwriter.println(csv);
                    }
                    printwriter.close();
                }catch(IOException e){
                    System.out.println("Error: File not found to read from.");
                }
            System.out.println("Written into file");
        }
    }

}
