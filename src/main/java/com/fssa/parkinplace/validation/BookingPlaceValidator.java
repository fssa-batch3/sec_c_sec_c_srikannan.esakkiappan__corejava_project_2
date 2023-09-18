package com.fssa.parkinplace.validation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.parkinplace.exception.BookingException;
import com.fssa.parkinplace.model.BookingPlace;

public class BookingPlaceValidator {

    public static boolean validate(BookingPlace bookingPlace) {
        if (bookingPlace == null) {
            throw new IllegalArgumentException("BookingPlace cannot be null.");
        }
        validateEmail(bookingPlace.getLeaserEmail());
        validateEmail(bookingPlace.getTenantEmail());
        validateDates(bookingPlace.getStartDate(), bookingPlace.getEndDate());
        validateTimes(bookingPlace.getStartTime(), bookingPlace.getEndTime());
        validateAmount(bookingPlace.getAmount());
        validateStatus(bookingPlace.getStatus());
        validateBookingDuration(bookingPlace.getBookingDuration());
        
        return true;
    }

    public static boolean validateEmail(String email) throws BookingException {
        if (email == null || email.isEmpty()) {
            throw new BookingException("Email cannot be null or empty.");
        }

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new BookingException("Invalid email format.");
        }
        
        return true;
    }

    public static boolean validateDates(LocalDate startDate, LocalDate endDate) throws BookingException {
        if (startDate == null || endDate == null || startDate.isAfter(endDate)) {
            throw new BookingException("Invalid date range.");
        }
        
        return true;
    }

    public static boolean validateTimes(LocalTime startTime, LocalTime endTime) throws BookingException {
        if (startTime == null || endTime == null || startTime.isAfter(endTime)) {
            throw new BookingException("Invalid time range.");
        }
        
        return true;
    }

    public static boolean validateAmount(double amount) throws BookingException {
        if (amount < 0) {
            throw new BookingException("Amount cannot be negative.");
        }
        
        return true;
    }

    public static boolean validateStatus(String status) throws BookingException {
        if (status == null || status.isEmpty()) {
            throw new BookingException("Status cannot be null or empty.");
        }
        
        return true;
    }

    public static boolean validateBookingDuration(String bookingDuration) throws BookingException {
        if (bookingDuration == null || bookingDuration.isEmpty()) {
            throw new BookingException("Booking duration cannot be null or empty.");
        }
        
        return true;
    }
}

