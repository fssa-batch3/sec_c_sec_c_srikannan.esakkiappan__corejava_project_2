package com.fssa.parkinplace.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.model.User;

/**
 * This class contains test cases for the UserService class.
 */
class TestUserService {

    /**
     * Creates and returns a User object with sample details for testing.
     *
     * @return A User object with sample details.
     */
    public User userDetails() {
        User p1 = new User(); 
        p1.setId(4); 
        p1.setFirstName("Raj");
        p1.setpPhoneNum("9618728611");
        p1.setEmail("rajan.2003@gmail.com");
        p1.setAddress("Muthu Kumaran Nagar,Poonamallee,");
        p1.setPassword("Sri@2003");
        p1.setMapurl("https://maps.app.goo.gl/orndAzptj1YPPHwf6");
        p1.setPlacephotourl("https://iili.io/HUN8VHX.jpg");

        return p1;
    }

    /**
     * Creates and returns a User object with updated sample details for testing.
     *
     * @return A User object with updated sample details.
     */
    public User updateUserDetails() {
        User p1 = new User();
        p1.setId(2);
        p1.setFirstName("Srikannan");
        p1.setpPhoneNum("9655221849");
        p1.setEmail("srikannan.2004@gmail.com");
        p1.setAddress("25,RaniyammalNagar,Taramani");
        p1.setPassword("Sri@2003");
        p1.setMapurl("https://maps.app.goog.gl/xNnms9FCoKySDE2");
        p1.setPlacephotourl("https://iili.io/HUN8VHX.jpg");

        return p1;
    }

    /**
     * Tests the addUser method of UserService for valid user addition.
     *
     * @throws DAOException If a DAOException occurs during testing.
     */
    @Test
    void testValidAddUser() throws DAOException {
        TestUserService userservice = new TestUserService();
        Assertions.assertTrue(UserService.addUser(userservice.userDetails()));
    }

    /**
     * Tests the updateUser method of UserService for valid user update.
     *
     * @throws DAOException If a DAOException occurs during testing.
     */
    @Test
    void testValidUpdateUser() throws DAOException {
        TestUserService userservice = new TestUserService();
        Assertions.assertTrue(UserService.updateUser(userservice.updateUserDetails()));
    }

    /**
     * Tests the deleteUser method of UserService for valid user deletion.
     *
     * @throws DAOException If a DAOException occurs during testing.
     */
    @Test
    void testValidDeleteUser() throws DAOException {
        Assertions.assertTrue(UserService.deleteUser(userDetails().getUserId()));
    }

    /**
     * Tests the readUser method of UserService for valid user retrieval.
     *
     * @throws DAOException If a DAOException occurs during testing.
     * @throws SQLException If a SQLException occurs during testing.
     */
    @Test
    void testValidReadUser() throws DAOException, SQLException {
        List<User> list = UserService.readUser();
        Assertions.assertNotNull(list);
    }
}
