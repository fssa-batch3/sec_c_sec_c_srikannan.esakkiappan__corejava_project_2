package com.fssa.parkinplace.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.exception.UserException;
import com.fssa.parkinplace.model.User;
import com.google.protobuf.ServiceException;

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
        User p1 = new User(null, null, null, null, null, null,null, 0,0); 
        p1.setId(12);  
        p1.setFirstName("Sri");
        p1.setpPhoneNum("8617728611"); 
        p1.setEmail("ram002@gmail.com");
        p1.setAddress("15,MahathmaGandhiNagar,Tharamani");
        p1.setPassword("Srik@2003");
        p1.setMapurl("https://maps.app.goo.gl/Mr8fd3QVjYEJHqGE91");
        p1.setPlacephotourl("https://iili.io/HUN8VHX.jpg");
        p1.setLatitude(40.7128);
        p1.setLongitude(-74.0060);

        return p1;   
    } 
 
    /** 
     * Creates and returns a User object with updated sample details for testing.
     * 
     * @return A User object with updated sample details.
     */
    public User updateUserDetails() {
        User p1 = new User(null, null, null, null, null, null,null,0,0);
        p1.setId(2);
        p1.setFirstName("Sakthi");
        p1.setpPhoneNum("9655221849");
        p1.setEmail("sakthi2002@gmail.com"); 
        p1.setAddress("89,2nd Main Rd,KothariNagar,Ramapuram,Chennai");
        p1.setPassword("Sakti@2003");
        p1.setMapurl("https://maps.app.goo.gl/xNbnms9FCoKySDEs5");
        p1.setPlacephotourl("https://iili.io/Hv6nOJV.jpg");
        p1.setLatitude(40.7128);
        p1.setLongitude(-74.0060);

        return p1;
    }
    
    public User TenantDetails() {
        User p1 = new User(null, null, null, null, null, null); 
        p1.setId(1);  
        p1.setFirstName("Dharunraj");
        p1.setpPhoneNum("9817728611");
        p1.setEmail("dharun2002@gmail.com");
        p1.setAddress("15,MahathmaGandhiNagar,Guduvancheri");
        p1.setPassword("Dhar@2003");
        p1.setBikephotourl("https://iili.io/HUN8VHX.jpg");

        return p1; 
    }
    
    public User updateTenantDetails() {
        User p1 = new User(null, null, null, null, null, null);
        p1.setId(1);  
        p1.setFirstName("Dharun");
        p1.setpPhoneNum("9817728611");
        p1.setEmail("dharun2002@gmail.com");
        p1.setAddress("15,MahathmaGandhiNagar,Guduvancheri");
        p1.setPassword("Dhar@2003");
        p1.setBikephotourl("https://iili.io/HUN8VHX.jpg");

        return p1;
    }

    /**
     * Tests the addUser method of UserService for valid user addition.
     *
     * @throws DAOException If a DAOException occurs during testing.
     * @throws ServiceException 
     */
    @Test
    void testValidAddUser() throws DAOException, ServiceException {
        TestUserService userservice = new TestUserService();
        try {
			Assertions.assertTrue(UserService.addUser(userservice.userDetails()));
		} catch (UserException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
    
    @Test
    void testValidAddTenant() throws DAOException, UserException, ServiceException {
        TestUserService userservice = new TestUserService();
        Assertions.assertTrue(UserService.addTenant(userservice.TenantDetails()));
    }
    
    @Test
    void testValidUpdateTenant() throws DAOException, UserException {
        TestUserService userservice = new TestUserService();
        Assertions.assertTrue(UserService.updateTenant(userservice.updateTenantDetails()));
    }
     
    @Test
    void testValidDeleteTenant() throws DAOException {
        Assertions.assertTrue(UserService.deleteTenant(TenantDetails().getUserId()));
    }
    
    @Test
    void testValidReadTenant() throws DAOException, SQLException {
        List<User> list = UserService.readTenant();
        Assertions.assertNotNull(list);
    }
    
    @Test
    void testValidGetUserById() throws DAOException {
    	TestUserService userservice = new TestUserService();
        Assertions.assertNotNull(UserService.getUserById(userDetails().getUserId()));
    }
    
    @Test
    void testValidIsUserExist() throws DAOException, ServiceException {
    	TestUserService userservice = new TestUserService();
    	Assertions.assertTrue(UserService.isUserExist(updateUserDetails().getEmail()));
    }
    
}
