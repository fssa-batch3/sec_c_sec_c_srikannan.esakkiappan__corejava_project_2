package com.fssa.parkinplace.errors;

public class UserDaoErrors {

	private UserDaoErrors() {
		super();
		
	}

	public static final String INVALID_INSERT = "Add user to the Database is Failed, check the input values";
	
	public static final String INVALID_UPDATE = "Update user in the Database is Failed";
	
	public static final String INVALID_DELETE = "Delete user from the Database is Failed";
	
	public static final String INVALID_READ = "Reading user from the Database is Failed";
	
	public static final String EMAIL_EXIST = "Email is already exist";

}
