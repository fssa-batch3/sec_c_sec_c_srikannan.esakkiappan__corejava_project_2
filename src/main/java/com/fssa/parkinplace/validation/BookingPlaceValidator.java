package com.fssa.parkinplace.validation;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.parkinplace.errors.BookingPlaceValidatorError;
import com.fssa.parkinplace.errors.UserValidatorErrors;
import com.fssa.parkinplace.exception.BookingException;
import com.fssa.parkinplace.exception.UserException;
import com.fssa.parkinplace.model.BookingPlace;

public class BookingPlaceValidator {

    public static boolean validate(BookingPlace bookingPlace) {
        if (bookingPlace == null) {
            throw new BookingException(BookingPlaceValidatorError.INVALID_OBJECT_NULL);
        }
        
        validateEmail(bookingPlace.getLeaserEmail());
        validateEmail(bookingPlace.getTenantEmail());
        validateDates(bookingPlace.getStartingPeriod(), bookingPlace.getEndingPeriod());
        validateAmount(bookingPlace.getAmount());
        validateStatus(bookingPlace.getStatus());
		return true;
    }
 
    public static boolean validateEmail(String email) throws BookingException {
        if (email == null) {
            throw new BookingException(BookingPlaceValidatorError.INVALID_EMAIL);
        }
 
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        Boolean isMatch = matcher.matches();
        if (Boolean.TRUE.equals(isMatch)) {
            return true;
        } else {
            throw new UserException(BookingPlaceValidatorError.INVALID_EMAIL);
        }
    }

    public static boolean validateDates(LocalDateTime startDate, LocalDateTime endDate) throws BookingException {
        if (startDate == null || endDate == null || startDate.isAfter(endDate)) {
            throw new BookingException(BookingPlaceValidatorError.INVALID_DATES);
        }
		return true;
    }

    public static boolean validateAmount(double amount) throws BookingException {
        if (amount < 0) {
            throw new BookingException(BookingPlaceValidatorError.INVALID_AMOUNT);
        }
		return true;
    }

    public static boolean validateStatus(String status) throws BookingException {
        if (status == null || status.isEmpty()) {
            throw new BookingException(BookingPlaceValidatorError.INVALID_STATUS);
        }
		return true;
    }
}


