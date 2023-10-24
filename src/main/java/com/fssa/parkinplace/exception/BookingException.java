package com.fssa.parkinplace.exception;

public class BookingException extends Exception {
	
	// Unique identifier for serialization
	private static final long serialVersionUID = 1L;
	
	// Constructor that takes a custom error message as input
	public BookingException(String message) {
		// Call the constructor of the base class (Exception) with the custom error message
		super(message);
	}
}
