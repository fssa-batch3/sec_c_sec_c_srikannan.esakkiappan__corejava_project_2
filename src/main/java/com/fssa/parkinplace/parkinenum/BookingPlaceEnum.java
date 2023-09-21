package com.fssa.parkinplace.parkinenum;

import com.fssa.parkinplace.exception.BookingException;

public class BookingPlaceEnum {
	public enum StatusEnum {
	    waiting_list, accepted, rejected;
	    public static String getStatus(String input) throws BookingException {
	        String lowerCaseInput = input.toLowerCase();
	        switch (lowerCaseInput) {
	            case "waiting_list":
	                return "waiting_list";
	            case "accepted":
	                return "accepted";
	            case "rejected":
	                return "rejected";
	            default:
	                return "non";
	        }
	    }
	}
}
 