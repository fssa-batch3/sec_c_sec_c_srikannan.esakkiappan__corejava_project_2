package com.fssa.parkinplace.exception;

public class InvalidUserException extends Exception {

	// Unique identifier for serialization
	private static final long serialVersionUID = 2L;

	// Constructor that takes a custom error message as input
	public InvalidUserException(String msg) {
		// Call the constructor of the base class (Exception) with the custom error message
		super(msg);
	}

	// Constructor that takes a Throwable (exception) as input
	public InvalidUserException(Throwable te) {
		// Call the constructor of the base class (Exception) with the Throwable (exception)
		super(te);
	}

	// Constructor that takes both a custom error message and a Throwable (exception) as input
	public InvalidUserException(String msg, Throwable te) {
		// Call the constructor of the base class (Exception) with both the custom error message and the Throwable (exception)
		super(msg, te);
	}
}
