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

    public static boolean validate(BookingPlace bookingPlace) throws BookingException {
        if (bookingPlace == null) {
            throw new BookingException(BookingPlaceValidatorError.INVALID_OBJECT_NULL);
        }
        
        validateId(bookingPlace.getLeaserId());
        validateEmail(bookingPlace.getTenantEmail());
        validateName(bookingPlace.getTenantName());
        validatePhoneNumber(bookingPlace.getTenantPhone());
        validateBikePhotoUrl(bookingPlace.getTenantBikeImg());
        validateDates(bookingPlace.getStartingPeriod(), bookingPlace.getEndingPeriod());
        validateAmount(bookingPlace.getAmount());
        validateStatus(bookingPlace.getStatus()); 
		return true;
    }  
    
    public static boolean validateId(int leaserId) throws BookingException {
        if (leaserId <= 0) {
            throw new BookingException(BookingPlaceValidatorError.INVALID_LEASERID);
        }
		return true;
    }
    
    public static boolean validateName(String name) throws BookingException {
        if (name == null || "".equals(name.trim()) || name.length() < 2) {
            throw new BookingException(UserValidatorErrors.INVALID_NAME);
        } 

        String nameregex = "^[A-Za-z]{3,20}$";
        Pattern pattern = Pattern.compile(nameregex);
        Matcher matcher = pattern.matcher(name);
        Boolean isMatch = matcher.matches();

        if (Boolean.FALSE.equals(isMatch)) {
            throw new BookingException(UserValidatorErrors.INVALID_NAME);
        }
        return true;
    }
    
    public static boolean validatePhoneNumber(String phonenum) throws BookingException {

        if (phonenum == null || "".equals(phonenum.trim()) || phonenum.length() < 10) {
            throw new BookingException(UserValidatorErrors.INVALID_PHONENUMBER);
        }

        String regex = "[6789][0-9]{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phonenum);
        Boolean isMatch = matcher.matches();
        if (Boolean.TRUE.equals(isMatch)) {
            return true;
        } else {
            throw new BookingException(UserValidatorErrors.INVALID_PHONENUMBER);
        }
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
            throw new BookingException(BookingPlaceValidatorError.INVALID_EMAIL);
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
    
    public static boolean validateBikePhotoUrl(String bikephotourl) throws BookingException {
        // Check if the PlacePhotoUrl is null, empty, or too short (less than 2
        // characters)
        if (bikephotourl == null || "".equals(bikephotourl.trim()) || bikephotourl.length() < 7) {
            throw new BookingException(UserValidatorErrors.INVALID_PLACEPHOTOURL);
        }

        // Regular expression to validate the PlacePhotoUrl format (should be a valid
        // imgur URL)
        String urlregex = "^(https?://)?[^\\s/$.?#].[^\\s]*\\.(?:png|jpg|jpeg|gif|svg)$";
        Pattern pattern = Pattern.compile(urlregex);
        Matcher matcher = pattern.matcher(bikephotourl);
        Boolean isMatch = matcher.matches();

        // Check if the PlacePhotoUrl matches the regular expression pattern
        if (Boolean.FALSE.equals(isMatch)) {
            throw new BookingException(UserValidatorErrors.INVALID_PLACEPHOTOURL);
        }
        return true;
    }
}


