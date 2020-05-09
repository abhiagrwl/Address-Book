package com.bridgelabz.codeinclub.utils;

import java.util.Scanner;

public final class AddressBookUtil {
    private final static Scanner scanner = new Scanner(System.in);

    private AddressBookUtil(){
        // default constructor created as private so that object cant be created outside the class;
    }

    public static int getUserNumber(){
        return scanner.nextInt();
    }

    public static String getUserString(){
        String tmp = scanner.nextLine();
        return tmp;
    }
}
