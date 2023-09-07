package com.fssa.parkinplace.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.logger.Logger;
import com.fssa.parkinplace.dao.UserDao;
import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.model.User;
import com.fssa.parkinplace.validation.UserValidator;

/**
 * This class provides services related to the User entity.
 */
public class UserService {
	
	/** 
	 * Adds a new User to the database.
	 *
	 * @param user The User object to be added.
	 * @return true if the operation was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public static boolean addUser(User user) throws DAOException {
		// Validate the User object using the UserValidator class
		if (UserValidator.validate(user)) { 
			// If the object is valid, call the addUser method from the DAO (data
			// access object) to insert the data into the database
			UserDao.addUser(user);
			Logger.info("User Added Successfully");
		}
		// Return true if the operation was successful 
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
		if (UserValidator.validate(user)) {
			// If the object is valid, call the updateUser method from the DAO to
			// update the data in the database
			UserDao.updateUser(user);
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
}
