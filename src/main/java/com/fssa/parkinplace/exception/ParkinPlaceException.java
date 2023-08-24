// Custom Exception class to represent general exceptions related to ParkinPlace application
package com.fssa.parkinplace.exception;

public class ParkinPlaceException extends RuntimeException {
	
	// Unique identifier for serialization
	private static final long serialVersionUID = 1L;
	
	// Constructor that takes a custom error message as input
	public ParkinPlaceException(String message) {
		// Call the constructor of the base class (RuntimeException) with the custom error message
		super(message);
	}
}

