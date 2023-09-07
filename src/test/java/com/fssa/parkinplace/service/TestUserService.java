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
        p1.setId(1);  
        p1.setFirstName("Sri");
        p1.setpPhoneNum("8617728611");
        p1.setEmail("srik.2003@gmail.com");
        p1.setAddress("MahathmaGandhiNagar,Tharamani");
        p1.setPassword("Srik@2003");
        p1.setMapurl("https://maps.app.goo.gl/Mr8fd3QVjYEJHqGE1");
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
        p1.setId(3);
        p1.setFirstName("Sakthi");
        p1.setpPhoneNum("9655221849");
        p1.setEmail("sakthi2002@gmail.com");
        p1.setAddress("89,2nd Main Rd,KothariNagar,Ramapuram,Chennai");
        p1.setPassword("Sakti@2003");
        p1.setMapurl("https://maps.app.goo.gl/xNbnms9FCoKySDEs5");
        p1.setPlacephotourl("https://iili.io/Hv6nOJV.jpg");

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
