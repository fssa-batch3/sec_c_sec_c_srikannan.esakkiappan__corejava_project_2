package com.fssa.parkinplace.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.parkinplace.errors.UserValidatorErrors;
import com.fssa.parkinplace.exception.UserException;
import com.fssa.parkinplace.model.User;

/**
 * The UserValidator class provides methods to validate user information.
 */
public class UserValidator {

    /**
     * Validates a User object.
     *
     * @param user The User object to be validated.
     * @return True if the validation passes.
     * @throws UserException if there is an issue with the validation.
     */
    public static boolean validate(User user) {
        if (user == null) {
            throw new UserException(UserValidatorErrors.INVALID_OBJECT_NULL);
        }
        validateName(user.getFirstName());
        validateEmail(user.getEmail());
        validateAddress(user.getAddress());
        validatePhoneNumber(user.getPhoneNum());
        validatePassword(user.getPassword());
        validateMapUrl(user.getMapurl());
        validatePlacePhotoUrl(user.getPlacephotourl());

        return true;
    }

    /**
     * Validates a user's name.
     *
     * @param name The name to be validated.
     * @return True if the validation passes.
     * @throws UserException if there is an issue with the validation.
     */
    public static boolean validateName(String name) throws UserException {
        if (name == null || "".equals(name.trim()) || name.length() < 2) {
            throw new UserException(UserValidatorErrors.INVALID_NAME);
        }

        String nameregex = "^[A-Za-z]{2,30}$";
        Pattern pattern = Pattern.compile(nameregex);
        Matcher matcher = pattern.matcher(name);
        Boolean isMatch = matcher.matches();

        if (Boolean.FALSE.equals(isMatch)) {
            throw new UserException(UserValidatorErrors.INVALID_NAME);
        }
        return true;
    }

    /**
     * Validates a user's email address.
     *
     * @param email The email address to be validated.
     * @return True if the validation passes.
     * @throws UserException if there is an issue with the validation.
     */
    public static boolean validateEmail(String email) throws UserException {

        if (email == null) {
            throw new UserException(UserValidatorErrors.INVALID_EMAIL);
        }

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        Boolean isMatch = matcher.matches();
        if (Boolean.TRUE.equals(isMatch)) {
            return true;
        } else {
            throw new UserException(UserValidatorErrors.INVALID_EMAIL);
        }
    }

    /** 
     * Validates a user's address.
     *
     * @param address The address to be validated.
     * @return True if the validation passes.
     * @throws UserException if there is an issue with the validation.
     */
    public static boolean validateAddress(String address) throws UserException {
        // Check if the Address is null or empty
        if (address == null || "".equals(address.trim())) {
            throw new UserException(UserValidatorErrors.INVALID_ADDRESS);
        }

        // Regular expression to validate the Address format (at least one non-space
        // character)
        String nameregex = "^(?=.*\\S).+$";
        Pattern pattern = Pattern.compile(nameregex);
        Matcher matcher = pattern.matcher(address);
        Boolean isMatch = matcher.matches();

        // Check if the Address matches the regular expression pattern
        if (Boolean.FALSE.equals(isMatch)) {
            throw new UserException(UserValidatorErrors.INVALID_ADDRESS_LENGTH);
        }
        return true;
    }

    /**
     * Validates a user's phone number.
     *
     * @param phonenum The phone number to be validated.
     * @return True if the validation passes.
     * @throws UserException if there is an issue with the validation.
     */
    public static boolean validatePhoneNumber(String phonenum) throws UserException {

        if (phonenum == null || "".equals(phonenum.trim()) || phonenum.length() < 2) {
            throw new UserException(UserValidatorErrors.INVALID_PHONENUMBER);
        }

        String regex = "[6789][0-9]{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phonenum);
        Boolean isMatch = matcher.matches();
        if (Boolean.TRUE.equals(isMatch)) {
            return true;
        } else {
            throw new UserException(UserValidatorErrors.INVALID_PHONENUMBER);
        }
    }

    /**
     * Validates a user's password.
     *
     * @param password The password to be validated.
     * @return True if the validation passes.
     * @throws UserException if there is an issue with the validation.
     */
    public static boolean validatePassword(String password) throws UserException {
        if (password == null || "".equals(password.trim())) {
            throw new UserException(UserValidatorErrors.INVALID_PASSWORD);
        }
        String passwordregex = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
        Pattern pattern = Pattern.compile(passwordregex);
        Matcher matcher = pattern.matcher(password);
        Boolean isMatch = matcher.matches();

        if (Boolean.FALSE.equals(isMatch)) {
            throw new UserException(UserValidatorErrors.INVALID_PASSWORD);
        }
        return true;
    }

    /**
     * Validates the MapUrl property of a ParkingPlace object.
     * 
     * @param mapurl The MapUrl to be validated.
     * @return True if the validation passes.
     * @throws UserException if there is an issue with the validation.
     */
    public static boolean validateMapUrl(String mapurl) throws UserException {
        // Check if the MapUrl is null, empty, or too short (less than 2 characters)
        if (mapurl == null || "".equals(mapurl.trim()) || mapurl.length() < 2) {
            throw new UserException(UserValidatorErrors.INVALID_MAPURL);
        }

        // Regular expression to validate the MapUrl format (should be a valid URL)
        String urlregex = "^(https?|ftp):\\/\\/[^\\s/$.?#].[^\\s]*$";
        Pattern pattern = Pattern.compile(urlregex);
        Matcher matcher = pattern.matcher(mapurl);
        Boolean isMatch = matcher.matches();

        // Check if the MapUrl matches the regular expression pattern
        if (Boolean.FALSE.equals(isMatch)) {
            throw new UserException(UserValidatorErrors.INVALID_MAPURL);
        }
        return true;
    }

    /**
     * Validates the PlacePhotoUrl property of a ParkingPlace object.
     *
     * @param placephotourl The PlacePhotoUrl to be validated.
     * @return True if the validation passes.
     * @throws UserException if there is an issue with the validation.
     */
    public static boolean validatePlacePhotoUrl(String placephotourl) throws UserException {
        // Check if the PlacePhotoUrl is null, empty, or too short (less than 2
        // characters)
        if (placephotourl == null || "".equals(placephotourl.trim()) || placephotourl.length() < 2) {
            throw new UserException(UserValidatorErrors.INVALID_PLACEPHOTOURL);
        }

        // Regular expression to validate the PlacePhotoUrl format (should be a valid
        // imgur URL)
        String urlregex = "^(https?://)?[^\\s/$.?#].[^\\s]*\\.(?:png|jpg|jpeg|gif|svg)$";
        Pattern pattern = Pattern.compile(urlregex);
        Matcher matcher = pattern.matcher(placephotourl);
        Boolean isMatch = matcher.matches();

        // Check if the PlacePhotoUrl matches the regular expression pattern
        if (Boolean.FALSE.equals(isMatch)) {
            throw new UserException(UserValidatorErrors.INVALID_PLACEPHOTOURL);
        }
        return true;
    }
}
