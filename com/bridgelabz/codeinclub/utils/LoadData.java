package com.bridgelabz.codeinclub.utils;

import com.bridgelabz.codeinclub.models.Person;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
LoadData: This class helps in loading data from file to program.
@author Abhishek 
*/
public class LoadData{
    final private static ArrayList<Person> persons = new ArrayList<Person>();

    private static void split(String data){
        ArrayList<String> person = new ArrayList<>();
        int pos = 0;
        String tmp = "";
        while(data.charAt(pos) != ';'){
            while(data.charAt(pos) != ',' && data.charAt(pos) != ';'){
                tmp = tmp + data.charAt(pos);
                pos++;
            }
            person.add(tmp);
            tmp = "";
            pos++;
        }
        addToList(person);
    }

    private static void addToList(ArrayList<String> data){
        Person person = new Person(data.get(0),data.get(1),data.get(2),data.get(3),data.get(4),data.get(5),data.get(6));
        persons.add(person);
    }


    public static ArrayList<Person> load(){
        try{
            File data = new File("com/bridgelabz/codeinclub/utils/data/AddressBook.csv");
            Scanner fileReader = new Scanner(data);
            while(fileReader.hasNextLine()){
                split(fileReader.nextLine());
            }
        }catch(FileNotFoundException e){
            System.out.println("Error: File not found to read data");
        }
        return persons;
    }
}
