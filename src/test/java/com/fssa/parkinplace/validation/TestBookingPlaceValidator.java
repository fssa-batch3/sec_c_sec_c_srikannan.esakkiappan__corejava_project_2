package com.fssa.parkinplace.validation;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.parkinplace.model.BookingPlace;
import com.fssa.parkinplace.exception.BookingException;
import com.fssa.parkinplace.exception.UserException;
import com.fssa.parkinplace.errors.BookingPlaceValidatorError;
import com.fssa.parkinplace.errors.UserValidatorErrors;

public class TestBookingPlaceValidator {

    public static BookingPlace createValidBookingPlace() {
        BookingPlace bookingPlace = new BookingPlace( null, null, null, null, 0, null);
        bookingPlace.setLeaserEmail("srik.2003@gmail.com");
        bookingPlace.setTenantEmail("sri@gmail.com");
        bookingPlace.setStartingPeriod(LocalDateTime.now());
        bookingPlace.setEndingPeriod(LocalDateTime.now().plusDays(7));
        bookingPlace.setAmount(100.0);
        bookingPlace.setStatus("Accepted");
        return bookingPlace;
    }

    public static BookingPlace createInvalidBookingPlace() {
        BookingPlace bookingPlace = new BookingPlace(null, null, null, null, 0, null);
        return bookingPlace; 
    }
 
    @Test
    void testValidBookingPlace() throws BookingException {
        BookingPlace validBookingPlace = createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validate(validBookingPlace));
    }
 
    @Test
    void testInvalidBookingPlaceNull() {
    	try {
    		BookingPlaceValidator.validate(null);
        } catch (BookingException e) {
            Assertions.assertEquals(BookingPlaceValidatorError.INVALID_OBJECT_NULL, e.getMessage());
        }
    }
    
    @Test
    void testValidLeaserEmail() throws BookingException {
        BookingPlace validBookingPlace = createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validateEmail(validBookingPlace.getLeaserEmail()));
    }

    @Test
    void testInvalidLeaserEmail() {
        BookingPlace invalidBookingPlace = createInvalidBookingPlace();
        try {
            BookingPlaceValidator.validateEmail(invalidBookingPlace.getLeaserEmail());
        } catch (BookingException e) {
            Assertions.assertEquals(BookingPlaceValidatorError.INVALID_EMAIL, e.getMessage());
        }
    }
    
    @Test
    void testValidTenantEmail() throws BookingException {
        BookingPlace validBookingPlace = createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validateEmail(validBookingPlace.getTenantEmail()));
    }

    @Test
    void testInvalidTenantEmail() {
        BookingPlace invalidBookingPlace = createInvalidBookingPlace();
        try {
            BookingPlaceValidator.validateEmail(invalidBookingPlace.getTenantEmail());
        } catch (BookingException e) {
            Assertions.assertEquals(BookingPlaceValidatorError.INVALID_EMAIL, e.getMessage());
        }
    }
    
    @Test
    void testValidDates() throws BookingException {
        BookingPlace validBookingPlace = createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validateDates(validBookingPlace.getStartingPeriod(),validBookingPlace.getEndingPeriod()));
    }

    @Test
    void testInvalidDates() {
        BookingPlace invalidBookingPlace = createInvalidBookingPlace();
        try {
            BookingPlaceValidator.validateDates(invalidBookingPlace.getStartingPeriod(),invalidBookingPlace.getEndingPeriod());
          
        } catch (BookingException e) {
            Assertions.assertEquals(BookingPlaceValidatorError.INVALID_DATES, e.getMessage());
        }
    }

    @Test
    void testValidAmount() throws BookingException {
        BookingPlace validBookingPlace = createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validateAmount(validBookingPlace.getAmount()));
    }
    
    @Test
    void testInvalidAmount() {
        BookingPlace invalidBookingPlace = createInvalidBookingPlace();
        try {
            BookingPlaceValidator.validateAmount(invalidBookingPlace.getAmount());
            
        } catch (BookingException e) {
            Assertions.assertEquals(BookingPlaceValidatorError.INVALID_AMOUNT, e.getMessage());
        }
    }
    
    @Test
    void testValidStatus() throws BookingException {
        BookingPlace validBookingPlace = createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validateStatus(validBookingPlace.getStatus()));
    }

    @Test
    void testInvalidStatus() {
        BookingPlace invalidBookingPlace = createInvalidBookingPlace();
        try {
            BookingPlaceValidator.validateStatus(invalidBookingPlace.getStatus());
         
        } catch (BookingException e) {
            Assertions.assertEquals(BookingPlaceValidatorError.INVALID_STATUS, e.getMessage());
        }
    }
}
