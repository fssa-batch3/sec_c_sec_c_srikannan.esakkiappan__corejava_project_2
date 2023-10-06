package com.fssa.parkinplace.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.parkinplace.errors.UserValidatorErrors;
import com.fssa.parkinplace.exception.InvalidUserException;
import com.fssa.parkinplace.exception.UserException;
import com.fssa.parkinplace.model.User;

/**
 * This class contains unit tests for UserValidator.
 */
public class TestUserValidator {

    /**
     * Creates an invalid user for testing purposes.
     *
     * @return An invalid user instance.
     */
    public static User testInvalidUser() {
        User invalidUser = new User(null, null, null, null, null, null, null, 0, 0);
        return invalidUser; 
    } 
    
    public static User testInvalidTenant() {
        User invalidTenant = new User(null, null, null, null, null, null);
        return invalidTenant; 
         
    }
      
    public static User testValidTenant() { 
        User details = new User(null, null, null, null, null, null);
        details.setFirstName("Ram");
        details.setEmail("ram2003@gmail.com");
        details.setAddress("25,Raniyammalnagar");
        details.setpPhoneNum("9799085013");
        details.setPassword("Sri@2003");
        details.setBikephotourl("https://iili.io/HvUnGHX.jpg");
        
        return details;
    }
 
    /**
     * Creates a valid user for testing purposes.
     *
     * @return A valid user instance.
     */
    public static User testValidUser() { 
        User details = new User(null, null, null, null, null, null, null,0,0);
        details.setFirstName("Srikannan");
        details.setEmail("Srikann.2003@gmail.com");
        details.setAddress("25,Raniyammalnagar");
        details.setpPhoneNum("9799085013");
        details.setPassword("Sri@2003");
        details.setMapurl("https://maps.google.com?q=location");
        details.setPlacephotourl("https://iili.io/HyP0C8b.png");
        details.setLatitude(40.7128);
        details.setLongitude(-74.0060);
        return details;
    }

    /**
     * Tests the validation of a valid user object.
     *
     * @throws UserException         if there is an issue with the user object.
     * @throws InvalidUserException if the user is invalid.
     */
    @Test
    void validTestObject() throws UserException, InvalidUserException {
        User data = TestUserValidator.testValidUser();
        Assertions.assertTrue(UserValidator.validate(data));
    }

    /**
     * Tests the validation of an invalid user object.
     */
    @Test
    void inValidTestObject() {
        try {
            UserValidator.validate(null);
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_OBJECT_NULL, e.getMessage());
        }
    }

    /**
     * Tests the validation of a valid first name.
     *
     * @throws InvalidUserException if the first name is invalid.
     * @throws UserException 
     */
    @Test
    void validTestFirstName() throws InvalidUserException, UserException {
        User datas = TestUserValidator.testValidUser();
        Assertions.assertTrue(UserValidator.validateName(datas.getFirstName()));
    }

    /**
     * Tests the validation of an invalid first name.
     */
    @Test
    void inValidTestFirstName() {
        User invaliddatas = TestUserValidator.testInvalidUser();
        try {
            UserValidator.validateName(invaliddatas.getFirstName());
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_NAME, e.getMessage());
        }

        try {
            UserValidator.validateName(" ");
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_NAME, e.getMessage());
        }
    }

    /**
     * Tests the validation of a valid email address.
     *
     * @throws InvalidUserException if the email address is invalid.
     * @throws UserException 
     */
    @Test
    void validTestEmail() throws InvalidUserException, UserException {
        User datas = TestUserValidator.testValidUser();
        Assertions.assertTrue(UserValidator.validateEmail(datas.getEmail()));
    }

    /**
     * Tests the validation of an invalid email address.
     */
    @Test
    void invalidTestEmail() {
        User invaliddatas = TestUserValidator.testInvalidUser();
        try {
            UserValidator.validateEmail(invaliddatas.getEmail());
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_EMAIL, e.getMessage());
        }
    }

    /**
     * Tests the validation of a valid address.
     * @throws UserException 
     *
     * @throws InvalidParkingPlaceException if there is an issue with the address.
     */
    @Test
    void validTestAddress() throws InvalidUserException, UserException {
        User datas = TestUserValidator.testValidUser();
        Assertions.assertTrue(UserValidator.validateAddress(datas.getAddress()));
    } 

    /** 
     * Tests the validation of an invalid address (less than 5 characters).
     */
    @Test
    void inValidTestAddress() {
        User invaliddatas = TestUserValidator.testInvalidUser();
        try {
            UserValidator.validateAddress(invaliddatas.getEmail());
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_ADDRESS, e.getMessage());
        }

        try {
            UserValidator.validateAddress("@1y");
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_ADDRESS_LENGTH, e.getMessage());
        }
    }

    /**
     * Tests the validation of a valid phone number.
     *
     * @throws InvalidUserException if the phone number is invalid.
     * @throws UserException 
     */
    @Test
    void validTestPhoneNumber() throws InvalidUserException, UserException {
        User datas = TestUserValidator.testValidUser();
        Assertions.assertTrue(UserValidator.validatePhoneNumber(datas.getPhoneNum()));
    }

    /**
     * Tests the validation of an invalid phone number.
     */
    @Test
    void invalidTestPhoneNumber() {
        User invaliddatas = TestUserValidator.testInvalidUser();

        try {
            UserValidator.validatePhoneNumber("12");
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_PHONENUMBER, e.getMessage());
        }
    }

    /**
     * Tests the validation of a valid password.
     *
     * @throws InvalidUserException if the password is invalid.
     * @throws UserException 
     */
    @Test
    void validTestPassword() throws InvalidUserException, UserException {
        User datas = TestUserValidator.testValidUser();
        Assertions.assertTrue(UserValidator.validatePassword(datas.getPassword()));
    }
  
    /**
     * Tests the validation of an invalid password.
     */
    @Test
    void invalidTestPassword() {
        User invaliddatas = TestUserValidator.testInvalidUser();
        try {
            UserValidator.validatePassword(invaliddatas.getPassword());
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_PASSWORD, e.getMessage());
        }

        try {
            UserValidator.validatePassword("d3e");
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_PASSWORD, e.getMessage());
        }
    }

    /**
     * Tests the validation of a valid map URL.
     * @throws UserException 
     *
     * @throws InvalidParkingPlaceException if there is an issue with the map URL.
     */
    @Test
    void validTestMapUrl() throws InvalidUserException, UserException {
        User datas = TestUserValidator.testValidUser();
        Assertions.assertTrue(UserValidator.validateMapUrl(datas.getMapurl()));
    }

    /**
     * Tests the validation of an invalid map URL.
     */
    @Test
    void inValidTestMapUrl() {
        User invaliddatas = TestUserValidator.testInvalidUser();
        try {
            UserValidator.validateMapUrl(invaliddatas.getMapurl());
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_MAPURL, e.getMessage());
        }

        try {
            UserValidator.validateMapUrl("@#$jhry");
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_MAPURL, e.getMessage());
        }
    }

    /**
     * Tests the validation of a valid place photo URL.
     * @throws UserException 
     *
     * @throws InvalidParkingPlaceException if there is an issue with the place photo URL.
     */
    @Test
    void validTestPhotoUrl() throws InvalidUserException, UserException {
        User datas = TestUserValidator.testValidUser();
        Assertions.assertTrue(UserValidator.validatePlacePhotoUrl(datas.getPlacephotourl()));
    }

    /**
     * Tests the validation of an invalid place photo URL.
     */
    @Test
    void inValidTestPhotoUrl() {
        User invaliddatas = TestUserValidator.testInvalidUser();
        try { 
            UserValidator.validatePlacePhotoUrl(invaliddatas.getPlacephotourl());
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_PLACEPHOTOURL, e.getMessage());
        }

        try {
            UserValidator.validatePlacePhotoUrl("@#$jhry");
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_PLACEPHOTOURL, e.getMessage());
        }
    }
    
    @Test
    void validLatitude() throws UserException {
    	User datas = TestUserValidator.testValidUser();
        Assertions.assertTrue(UserValidator.validateLatitude(datas.getLatitude()));
    }
    
    @Test
    void inValidLatitude() throws UserException {
    	User invaliddatas = TestUserValidator.testInvalidUser();
        Assertions.assertTrue(UserValidator.validateLatitude(invaliddatas.getLatitude()));
    }
    
    @Test
    void validLongitude() throws UserException {
    	User datas = TestUserValidator.testValidUser();
        Assertions.assertTrue(UserValidator.validateLongitude(datas.getLongitude()));
    }
    
    @Test
    void inValidLongitude() throws UserException {
    	User invaliddatas = TestUserValidator.testInvalidUser();
        Assertions.assertTrue(UserValidator.validateLongitude(invaliddatas.getLongitude()));
    }
    
    
//    ---------------------------------------------------------------------------
    
    
    
    @Test
    void validTestBikePhotoUrl() throws InvalidUserException, UserException {
        User datas = TestUserValidator.testValidTenant();
        Assertions.assertTrue(UserValidator.validateBikePhotoUrl(datas.getBikephotourl()));
    }
    
    @Test 
    void inValidTestBikePhotoUrl() {
        User invaliddatas = TestUserValidator.testInvalidTenant();
        try { 
            UserValidator.validateBikePhotoUrl(invaliddatas.getBikephotourl());
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_PLACEPHOTOURL, e.getMessage());
        }

        try {
            UserValidator.validateBikePhotoUrl("@#$jhry");
        } catch (UserException e) {
            Assertions.assertEquals(UserValidatorErrors.INVALID_PLACEPHOTOURL, e.getMessage());
        }
    } 
}
