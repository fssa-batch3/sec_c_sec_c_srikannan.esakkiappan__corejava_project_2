package com.fssa.parkinplace.validation;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.parkinplace.model.BookingPlace;
import com.fssa.parkinplace.model.User;
import com.fssa.parkinplace.exception.BookingException;
import com.fssa.parkinplace.exception.InvalidBookingException;
import com.fssa.parkinplace.exception.InvalidUserException;
import com.fssa.parkinplace.exception.UserException;
import com.fssa.parkinplace.errors.BookingPlaceValidatorError;
import com.fssa.parkinplace.errors.UserValidatorErrors;

public class TestBookingPlaceValidator {

    public static BookingPlace createValidBookingPlace() {
        BookingPlace bookingPlace = new BookingPlace( null,null,1,null, null, null, null, 0, null);
        bookingPlace.setTenantName("Sri");
        bookingPlace.setTenantPhone("9884616021");
        bookingPlace.setLeaserId(1);
        bookingPlace.setTenantEmail("sri@gmail.com");
        bookingPlace.setStartingPeriod(LocalDateTime.now());
        System.out.println(LocalDateTime.now()); 
        bookingPlace.setEndingPeriod(LocalDateTime.now().plusDays(7));
        bookingPlace.setAmount(100.0);
        bookingPlace.setStatus("WaitingList");
        bookingPlace.setTenantBikeImg("https://iili.io/HvUnGHX.jpg");
        return bookingPlace;
    }

    public static BookingPlace createInvalidBookingPlace() {
        BookingPlace bookingPlace = new BookingPlace(null,null,0,null, null, null, null, 0, null);
        return bookingPlace; 
    } 
 
    @Test
    void testValidBookingPlace() throws BookingException, InvalidBookingException {
        BookingPlace validBookingPlace = createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validate(validBookingPlace));
    }
   
    @Test
    void testInvalidBookingPlaceNull() throws BookingException {
    	try {
    		BookingPlaceValidator.validate(null);
        } catch (BookingException e) {
            Assertions.assertEquals(BookingPlaceValidatorError.INVALID_OBJECT_NULL, e.getMessage());
        }
    }
     
    @Test
    void validTestFirstName() throws InvalidBookingException, BookingException {
        BookingPlace datas = TestBookingPlaceValidator.createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validateName(datas.getTenantName()));
    }

    /**
     * Tests the validation of an invalid first name.
     */
    @Test
    void inValidTestFirstName() {
        BookingPlace invaliddatas = TestBookingPlaceValidator.createInvalidBookingPlace();
        try {
        	BookingPlaceValidator.validateName(invaliddatas.getTenantName());
        } catch (BookingException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_NAME, e.getMessage());
        }

        try {
        	BookingPlaceValidator.validateName(" ");
        } catch (BookingException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_NAME, e.getMessage());
        }
    }
    
    @Test
    void validTestPhoneNumber() throws InvalidBookingException, BookingException {
        BookingPlace datas = TestBookingPlaceValidator.createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validatePhoneNumber(datas.getTenantPhone()));
    }

    /**
     * Tests the validation of an invalid phone number.
     */
    @Test
    void invalidTestPhoneNumber() {
        BookingPlace invaliddatas = TestBookingPlaceValidator.createInvalidBookingPlace();

        try {
        	BookingPlaceValidator.validatePhoneNumber("12");
        } catch (BookingException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_PHONENUMBER, e.getMessage());
        }
    }
    
    @Test
    void testValidLeaserId() throws BookingException, UserException {
        BookingPlace validBookingPlace = TestBookingPlaceValidator.createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validateId(validBookingPlace.getLeaserId()));
    }

    @Test
    void testInvalidLeaserId() throws UserException {
        BookingPlace invalidBookingPlace = TestBookingPlaceValidator.createInvalidBookingPlace();
        try {
            BookingPlaceValidator.validateId(invalidBookingPlace.getLeaserId());
        } catch (BookingException e) {
            Assertions.assertEquals(BookingPlaceValidatorError.INVALID_LEASERID, e.getMessage());
        }
    }
    
    @Test
    void testValidTenantEmail() throws BookingException, UserException {
        BookingPlace validBookingPlace = TestBookingPlaceValidator.createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validateEmail(validBookingPlace.getTenantEmail()));
    }

    @Test
    void testInvalidTenantEmail() throws BookingException, UserException {
        BookingPlace invalidBookingPlace = TestBookingPlaceValidator.createInvalidBookingPlace();
        try {
            BookingPlaceValidator.validateEmail(invalidBookingPlace.getTenantEmail());
        } catch (BookingException e) {
            Assertions.assertEquals(BookingPlaceValidatorError.INVALID_EMAIL, e.getMessage());
        }
    }
    
    @Test
    void testValidDates() throws BookingException {
        BookingPlace validBookingPlace = TestBookingPlaceValidator.createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validateDates(validBookingPlace.getStartingPeriod(),validBookingPlace.getEndingPeriod()));
    }

    @Test
    void testInvalidDates() {
        BookingPlace invalidBookingPlace = TestBookingPlaceValidator.createInvalidBookingPlace();
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
    
    @Test
    void validTestBikePhotoUrl() throws InvalidBookingException, BookingException {
        BookingPlace datas = TestBookingPlaceValidator.createValidBookingPlace();
        Assertions.assertTrue(BookingPlaceValidator.validateBikePhotoUrl(datas.getTenantBikeImg()));
    }
    
    @Test 
    void inValidTestBikePhotoUrl() {
        BookingPlace invaliddatas = TestBookingPlaceValidator.createInvalidBookingPlace();
        try { 
        	BookingPlaceValidator.validateBikePhotoUrl(invaliddatas.getTenantBikeImg());
        } catch (BookingException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_PLACEPHOTOURL, e.getMessage());
        }

        try {
        	BookingPlaceValidator.validateBikePhotoUrl("@#$jhry");
        } catch (BookingException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_PLACEPHOTOURL, e.getMessage());
        }
    } 
}
