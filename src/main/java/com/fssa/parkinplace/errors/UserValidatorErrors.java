package com.fssa.parkinplace.errors;

public class UserValidatorErrors {
	
	private UserValidatorErrors() {
		super();
	}

	public static final String INVALID_OBJECT_NULL = "Argument cannot be null";
	
	public static final String INVALID_ID = "Id is: Invalid";
	
	public static final String INVALID_NAME = "name is: Invalid";
	
	public static final String INVALID_ADDRESS = "Address is: Invalid";
	
	public static final String INVALID_ADDRESS_LENGTH = "Address should be in minimum 5 letters and maximum 30 letters";
	
	public static final String INVALID_PHONENUMBER = "PhoneNumber is: Invalid";
	
	public static final String INVALID_EMAIL = "email is: Invalid";
	
	public static final String INVALID_PASSWORD = "password is: Invalid";
	
	public static final String INVALID_MAPURL = "mapurl is: Invalid";
	
	public static final String INVALID_PLACEPHOTOURL = "placephotourl is: Invalid";
	
}
