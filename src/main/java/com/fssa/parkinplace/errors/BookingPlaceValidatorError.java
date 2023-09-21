package com.fssa.parkinplace.errors;

public class BookingPlaceValidatorError {

	private BookingPlaceValidatorError() {
		super();
	}
	
	public static final String INVALID_OBJECT_NULL = "Argument cannot be null";
	
	public static final String INVALID_EMAIL = "Email is: Invalid";
	
	public static final String INVALID_DATES = "Date is: Invalid";
	
	public static final String INVALID_AMOUNT = "Parking Charge is: Invalid";
	
	public static final String INVALID_STATUS = "Status is: Invalid";
}
