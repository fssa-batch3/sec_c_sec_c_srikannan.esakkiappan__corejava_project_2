// Custom Exception class to handle exceptions related to invalid ParkingPlace objects
package com.fssa.parkinplace.exception;

public class InvalidParkingPlaceException extends Exception {

	// Unique identifier for serialization
	private static final long serialVersionUID = 2L;

	// Constructor that takes a custom error message as input
	public InvalidParkingPlaceException(String msg) {
		// Call the constructor of the base class (Exception) with the custom error message
		super(msg);
	}

	// Constructor that takes a Throwable (exception) as input
	public InvalidParkingPlaceException(Throwable te) {
		// Call the constructor of the base class (Exception) with the Throwable (exception)
		super(te);
	}

	// Constructor that takes both a custom error message and a Throwable (exception) as input
	public InvalidParkingPlaceException(String msg, Throwable te) {
		// Call the constructor of the base class (Exception) with both the custom error message and the Throwable (exception)
		super(msg, te);
	}
}
