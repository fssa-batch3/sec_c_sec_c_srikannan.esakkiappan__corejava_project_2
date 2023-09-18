package com.fssa.parkinplace.validation;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.parkinplace.exception.BookingException;
import com.fssa.parkinplace.model.BookingPlace;

public class TestBookingPlaceValidator {
	
	private BookingPlace createValidBookingPlace() {
        BookingPlace bookingPlace = new BookingPlace();
        bookingPlace.setLeaserEmail("leaser@example.com");
        bookingPlace.setTenantEmail("tenant@example.com");
        bookingPlace.setStartDate(LocalDate.now());
        bookingPlace.setEndDate(LocalDate.now().plusDays(7));
        bookingPlace.setStartTime(LocalTime.of(10, 0));
        bookingPlace.setEndTime(LocalTime.of(12, 0));
        bookingPlace.setAmount(100.0);
        bookingPlace.setStatus("Active");
        bookingPlace.setBookingDuration("1 week");
        return bookingPlace;
    }

    @Test
    void testValidBookingPlace() throws BookingException {
        BookingPlace validBookingPlace = createValidBookingPlace();
        boolean result = false;
        try {
            result = BookingPlaceValidator.validate(validBookingPlace);
        } catch (BookingException e) {
            result = false; 
        }
        Assertions.assertTrue(result);
    }

    @Test
    void testInvalidBookingPlaceNull() {
        try {
            BookingPlaceValidator.validate(null);
            Assertions.fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("BookingPlace cannot be null.", e.getMessage());
        } catch (BookingException e) {
            Assertions.fail("Unexpected BookingException was thrown.");
        }
    }

    @Test
    void testInvalidLeaserEmail() {
        BookingPlace invalidBookingPlace = createValidBookingPlace();
        invalidBookingPlace.setLeaserEmail(null);
        try {
            BookingPlaceValidator.validate(invalidBookingPlace);
            Assertions.fail("Expected BookingException was not thrown.");
        } catch (BookingException e) {
            Assertions.assertEquals("Email cannot be null or empty.", e.getMessage());
        }
    }

    @Test
    void testInvalidTenantEmail() {
        BookingPlace invalidBookingPlace = createValidBookingPlace();
        invalidBookingPlace.setTenantEmail(null);
        try {
            BookingPlaceValidator.validate(invalidBookingPlace);
            Assertions.fail("Expected BookingException was not thrown.");
        } catch (BookingException e) {
            Assertions.assertEquals("Email cannot be null or empty.", e.getMessage());
        }
    }

    @Test
    void testInvalidDates() {
        BookingPlace invalidBookingPlace = createValidBookingPlace();
        invalidBookingPlace.setStartDate(LocalDate.now().plusDays(1));
        invalidBookingPlace.setEndDate(LocalDate.now());
        try {
            BookingPlaceValidator.validate(invalidBookingPlace);
            Assertions.fail("Expected BookingException was not thrown.");
        } catch (BookingException e) {
            Assertions.assertEquals("Invalid date range.", e.getMessage());
        }
    }

    @Test
    void testInvalidTimes() {
        BookingPlace invalidBookingPlace = createValidBookingPlace();
        invalidBookingPlace.setStartTime(LocalTime.of(14, 0));
        invalidBookingPlace.setEndTime(LocalTime.of(12, 0));
        try {
            BookingPlaceValidator.validate(invalidBookingPlace);
            Assertions.fail("Expected BookingException was not thrown.");
        } catch (BookingException e) {
            Assertions.assertEquals("Invalid time range.", e.getMessage());
        }
    }

    @Test
    void testInvalidAmount() {
        BookingPlace invalidBookingPlace = createValidBookingPlace();
        invalidBookingPlace.setAmount(-50.0);
        try {
            BookingPlaceValidator.validate(invalidBookingPlace);
            Assertions.fail("Expected BookingException was not thrown.");
        } catch (BookingException e) {
            Assertions.assertEquals("Amount cannot be negative.", e.getMessage());
        }
    }

    @Test
    void testInvalidStatus() {
        BookingPlace invalidBookingPlace = createValidBookingPlace();
        invalidBookingPlace.setStatus(null);
        try {
            BookingPlaceValidator.validate(invalidBookingPlace);
            Assertions.fail("Expected BookingException was not thrown.");
        } catch (BookingException e) {
            Assertions.assertEquals("Status cannot be null or empty.", e.getMessage());
        }
    }

    @Test
    void testInvalidBookingDuration() {
        BookingPlace invalidBookingPlace = createValidBookingPlace();
        invalidBookingPlace.setBookingDuration(null);
        try {
            BookingPlaceValidator.validate(invalidBookingPlace);
            Assertions.fail("Expected BookingException was not thrown.");
        } catch (BookingException e) {
            Assertions.assertEquals("Booking duration cannot be null or empty.", e.getMessage());
        }
    }

}

