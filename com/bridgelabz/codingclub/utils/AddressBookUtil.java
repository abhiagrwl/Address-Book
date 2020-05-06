package com.brigelabz.codingclub.utils;

import java.utils.*;

public final class AddressBookUtil
{
	private final static Scanner scanner = new Scanner (System.in);

	private AddressBookUtil()
	{
		//Creating a empty constructor so that its object can not be created from any where
	}

	public static int getUserNumber()
	{
		return scanner.nextInt();
	}

	public static String getUserString()
	{
		return scanner.nextLine();

	}

}