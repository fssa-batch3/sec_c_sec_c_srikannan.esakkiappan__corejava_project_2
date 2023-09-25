package com.fssa.parkinplace.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.logger.Logger;
import com.fssa.parkinplace.dao.UserDao;
import com.fssa.parkinplace.errors.UserDaoErrors;
import com.fssa.parkinplace.errors.UserValidatorErrors;
import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.exception.UserException;
import com.fssa.parkinplace.model.User;
import com.fssa.parkinplace.validation.UserValidator;
import com.google.protobuf.ServiceException;

/**
 * This class provides services related to the User entity.
 */
public class UserService { 
	
	private static UserDao userDao;
	private UserValidator userValidator;
	
	public UserService(UserDao userDao, UserValidator userValidator) {
		this.userDao = userDao;
		this.userValidator = userValidator;
	}
	 
	public UserService() {
		// TODO Auto-generated constructor stub
	} 

	/**     
	 * Adds a new User to the database.
	 *
	 * @param user The User object to be added.
	 * @return true if the operation was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 * @throws ServiceException 
	 */
	public static boolean addUser(User user) throws UserException, DAOException, ServiceException {
		// Validate the User object using the UserValidator class
	
		if (UserValidator.validate(user)) { 
			// If the object is valid, call the addUser method from the DAO (data
			// access object) to insert the data into the database
			if(!isUserExist(user.getEmail())) {
				UserDao.addUser(user);
				Logger.info("User Added Successfully");
			}
			else {
				throw new UserException(UserDaoErrors.EMAIL_EXIST);
			}
			
		}
		
		// Return true if the operation was successful 
		return true;
	}  
	
	public static boolean addTenant(User user) throws DAOException, UserException, ServiceException {
		if(UserValidator.validateTenant(user)) {
			
			if(!isTenantExist(user.getEmail())) {
				UserDao.addTenant(user);
				Logger.info("Tenant Added Successfully");
			}
			else {
				throw new UserException(UserDaoErrors.EMAIL_EXIST);
			}
			
		}
		return true;
	}
	  
	/**  
	 * Updates an existing User in the database.
	 *
	 * @param user The User object to be updated.
	 * @return true if the operation was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public static boolean updateUser(User user) throws DAOException {  
		// Validate the User object using the UserValidator class
		try {
			if (UserValidator.validate(user)) {
				// If the object is valid, call the updateUser method from the DAO to
				// update the data in the database
				UserDao.updateUser(user);
			}
		} catch (UserException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Return true if the operation was successful
		return true; 
	}
	
	public static boolean updateTenant(User user) throws DAOException, UserException {  
		// Validate the User object using the UserValidator class
		if (UserValidator.validateTenant(user)) {
			// If the object is valid, call the updateUser method from the DAO to
			// update the data in the database
			UserDao.updateTenant(user);
		}
		// Return true if the operation was successful
		return true; 
	} 
	
	/**
	 * Deletes a User from the database by its ID.
	 *
	 * @param id The ID of the User to be deleted.
	 * @return true if the operation was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public static boolean deleteUser(int id) throws DAOException {
		UserDao.deleteUser(id);
		// Return true if the operation was successful
		return true;
	}
	
	public static boolean deleteTenant(int id) throws DAOException {
		UserDao.deleteTenant(id);
		// Return true if the operation was successful
		return true;
	}
	
	/**
	 * Retrieves a list of all Users from the database.
	 *
	 * @return A List of User objects.
	 * @throws DAOException If a database access error occurs.
	 * @throws SQLException If an SQL exception occurs.
	 */
	public static List<User> readUser() throws DAOException, SQLException {
		return UserDao.readUser();
	}
	 
	public static List<User> readTenant() throws DAOException, SQLException {
		return UserDao.readTenant();
	}
	
	public User login(String email) throws DAOException, UserException {

		User user = null;
		if (UserValidator.validateEmail(email)) {
			user = UserDao.login(email);
		}
		 
		return user;
	} 
	
	
	public User Tenantlogin(String email) throws DAOException, UserException {

		User user = null;
		if (UserValidator.validateEmail(email)) {
			user = UserDao.tenantlogin(email);
		}
		
		return user; 
	} 
	
	public static boolean isUserExist(String email) throws DAOException, ServiceException {	
		try {
			if (UserValidator.validateEmail(email)) {
				return userDao.isUserExist(email);
			} else {
				throw new ServiceException("Your Email is invalid");
			}
		} catch (UserException e) {	
			throw new ServiceException(UserValidatorErrors.INVALID_EMAIL + e.getMessage());
		} catch (DAOException e) {
			throw new ServiceException(UserDaoErrors.EMAIL_EXIST + e.getMessage());
		} 
		
	}
	
	public static boolean isTenantExist(String email) throws DAOException, ServiceException {	
		try {
			if (UserValidator.validateEmail(email)) {
				return userDao.isTenantExist(email);
			} else {
				throw new ServiceException("Your Email is invalid");
			}
		} catch (UserException e) {	
			throw new ServiceException(UserValidatorErrors.INVALID_EMAIL + e.getMessage());
		} catch (DAOException e) {
			throw new ServiceException(UserDaoErrors.EMAIL_EXIST + e.getMessage());
		} 
		
	}
	
	// Method to get all user email addresses from the DAO
		public static User getUserById(int leaserId) throws DAOException {

			return UserDao.getUserById(leaserId);
		}
		
		public User getTenantByEmail(String email) throws DAOException {

			return UserDao.getTenantByEmail(email);
		}
}
