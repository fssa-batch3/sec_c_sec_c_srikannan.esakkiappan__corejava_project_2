package com.fssa.parkinplace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.logger.Logger;
import com.fssa.parkinplace.errors.UserDaoErrors;
import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.model.User;
import com.fssa.util.ConnectionUtil;
import com.fssa.util.EncryptPassword.Password;

/**
 * This class provides data access methods for interacting with the userdetails
 * table in the database. 
 */
public class UserDao {

	/**     
	 * Adds a new user to the database. 
	 *
	 * @param user The User object representing the user to be added. 
	 * @return True if the insertion was successful, false otherwise.
	 * @throws DAOException if there is an issue with the database operation.
	 */
	public static boolean addUser(User user) throws DAOException {
		final String query = "INSERT INTO userdetails (name, email, address, phonenumber, password, mapurl, placephotourl,lattitude,longitude) VALUES(?,?,?,?,?,?,?,?,?)";

		try (Connection connection = ConnectionUtil.getConnection()) {
 
			try (PreparedStatement data = connection.prepareStatement(query)) {
				data.setString(1, user.getFirstName());
				data.setString(2, user.getEmail());
				data.setString(3, user.getAddress());
				data.setString(4, user.getPhoneNum()); 
				String hashPassword = Password.encryptPassword(user.getPassword());
				data.setString(5, hashPassword);
				data.setString(6, user.getMapurl());
				data.setString(7, user.getPlacephotourl());
				data.setDouble(8, user.getLatitude());
				data.setDouble(9, user.getLongitude());

				int row = data.executeUpdate();
  
				// Print a success message and return true if the insertion was successful
				return (row > 0);
			}
		} catch (SQLException e) {
			Logger.info(e);
			// If an SQLException occurs, throw a DAOException with a custom error message
			throw new DAOException(UserDaoErrors.INVALID_INSERT);
		}
	}
	
	public static boolean addTenant(User user) throws DAOException {
		final String query = "INSERT INTO Tenantdetails (name, email, address, phonenumber, password, bikephotourl) VALUES(?,?,?,?,?,?)";

		try (Connection connection = ConnectionUtil.getConnection()) {

			try (PreparedStatement data = connection.prepareStatement(query)) {
				data.setString(1, user.getFirstName());
				data.setString(2, user.getEmail());
				data.setString(3, user.getAddress());
				data.setString(4, user.getPhoneNum());
				String hashPassword = Password.encryptPassword(user.getPassword());
				data.setString(5, hashPassword); 
				data.setString(6, user.getBikephotourl());

				int row = data.executeUpdate();

				// Print a success message and return true if the insertion was successful
				return (row > 0);
			}
		} catch (SQLException e) {
			Logger.info(e);
			// If an SQLException occurs, throw a DAOException with a custom error message
			throw new DAOException(UserDaoErrors.INVALID_INSERT);
		}
	}

	/**
	 * Updates an existing user in the database.
	 *
	 * @param user The User object representing the updated user.
	 * @return True if the update was successful, false otherwise.
	 * @throws DAOException if there is an issue with the database operation.
	 */
	public static boolean updateUser(User user) throws DAOException {

		int id = getUserIdByEmail(user.getEmail());

		final String query = "UPDATE userdetails SET name=?, email=?, address=?, phonenumber=?, password=?, mapurl=?, placephotourl=? WHERE id=?";

		try (Connection connection = ConnectionUtil.getConnection()) {

			try (PreparedStatement data = connection.prepareStatement(query)) {
 
				// Set the values for the PreparedStatement using the User object
				data.setString(1, user.getFirstName());
				data.setString(2, user.getEmail());
				data.setString(3, user.getAddress());
				data.setString(4, user.getPhoneNum());
				data.setString(5, user.getPassword());
				data.setString(6, user.getMapurl());
				data.setString(7, user.getPlacephotourl());
				data.setInt(8, id);

				// Execute the query to update the data in the database
				int row = data.executeUpdate();
				
				// Return true if the update was successful
				return row > 0;
			}
		} catch (SQLException e) {
			// If an SQLException occurs, throw a DAOException with a custom error message
			throw new DAOException(UserDaoErrors.INVALID_UPDATE);

		}

	}
	
	public static boolean updateTenant(User user) throws DAOException {

		int id = getTenantIdByEmail(user.getEmail());

		final String query = "UPDATE Tenantdetails SET name=?, email=?, address=?, phonenumber=?, password=?, bikephotourl=? WHERE id=?";

		try (Connection connection = ConnectionUtil.getConnection()) {

			try (PreparedStatement data = connection.prepareStatement(query)) {
  
				// Set the values for the PreparedStatement using the User object
				data.setString(1, user.getFirstName());
				data.setString(2, user.getEmail());
				data.setString(3, user.getAddress());
				data.setString(4, user.getPhoneNum());
				data.setString(5, user.getPassword());
				data.setString(6, user.getBikephotourl());
				data.setInt(7, id);

				// Execute the query to update the data in the database
				int row = data.executeUpdate();
				
				// Return true if the update was successful
				return row > 0;
			}
		} catch (SQLException e) {
			// If an SQLException occurs, throw a DAOException with a custom error message
			throw new DAOException(UserDaoErrors.INVALID_UPDATE);

		}

	}

	/**
	 * Deletes a user from the database based on its ID.
	 *
	 * @param id The ID of the user to be deleted.
	 * @return True if the deletion was successful, false otherwise.
	 * @throws DAOException if there is an issue with the database operation.
	 */
	public static boolean deleteUser(int id) throws DAOException {

		final String query = "DELETE FROM userdetails WHERE id=?";

		try (Connection connection = ConnectionUtil.getConnection()) {

			try (PreparedStatement data = connection.prepareStatement(query)) {
				// Set the value for the PreparedStatement using the provided ID
				data.setInt(1, id);

				// Execute the query to delete the data from the database
				data.executeUpdate();

			}
		} catch (SQLException e) {
			// If an SQLException occurs, throw a DAOException with a custom error message
			throw new DAOException(UserDaoErrors.INVALID_DELETE);
		}
		// Return true if the delete was successful
		return true;
	}

	
	public static boolean deleteTenant(int id) throws DAOException {

		final String query = "DELETE FROM Tenantdetails WHERE id=?";

		try (Connection connection = ConnectionUtil.getConnection()) {

			try (PreparedStatement data = connection.prepareStatement(query)) {
				// Set the value for the PreparedStatement using the provided ID
				data.setInt(1, id);

				// Execute the query to delete the data from the database
				data.executeUpdate();

			}
		} catch (SQLException e) {
			// If an SQLException occurs, throw a DAOException with a custom error message
			throw new DAOException(UserDaoErrors.INVALID_DELETE);
		}
		// Return true if the delete was successful
		return true;
	}
	
	/**
	 * Retrieves the user ID based on the email.
	 *
	 * @param email The email of the user.
	 * @return The user ID associated with the email.
	 * @throws DAOException if there is an issue with the database operation.
	 */
	public static int getUserIdByEmail(String email) throws DAOException {
		int id = 0;
		String queryDeleteEvents = "SELECT id FROM userdetails WHERE email = ? ";
		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement(queryDeleteEvents)) {

				pst.setString(1, email);
				try (ResultSet rs = pst.executeQuery()) {

					if (rs.next()) {
						id = rs.getInt("id");

					}

				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return id;
	}
	
	public static int getTenantIdByEmail(String email) throws DAOException {
		int id = 0;
		String queryDeleteEvents = "SELECT id FROM Tenantdetails WHERE email = ? ";
		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement(queryDeleteEvents)) {

				pst.setString(1, email);
				try (ResultSet rs = pst.executeQuery()) {

					if (rs.next()) {
						id = rs.getInt("id");

					}

				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return id;
	}

	/**
	 * Retrieves a list of all users from the database.
	 *
	 * @return A list of User objects representing all users in the database.
	 * @throws DAOException if there is an issue with the database operation.
	 * @throws SQLException if there is an issue with the SQL query.
	 */
	public static List<User> readUser() throws DAOException, SQLException {

		List<User> user = new ArrayList<>();
		// SQL query to select all rows from the "userdetails" table
		final String query = "SELECT * FROM userdetails";

		try (Connection connection = ConnectionUtil.getConnection()) {

			try (Statement pst = connection.createStatement()) {

				try (ResultSet rs = pst.executeQuery(query)) {
					// Loop through the result set and populate the User objects
					while (rs.next()) {

						User userData = new User();
						userData.setId(rs.getInt("id"));
						userData.setFirstName(rs.getString("name"));
						userData.setEmail(rs.getString("email"));
						userData.setAddress(rs.getString("address"));
						userData.setpPhoneNum(rs.getString("phonenumber"));
						userData.setPassword(rs.getString("password"));
						userData.setMapurl(rs.getString("mapurl"));
						userData.setPlacephotourl(rs.getString("placephotourl"));
						userData.setLatitude(rs.getDouble("lattitude"));
						userData.setLongitude(rs.getDouble("longitude"));  

						user.add(userData);

					}
					// Return the list of users
					return user;
				}
			} catch (SQLException e) {
				// If an SQLException occurs, throw a DAOException with a custom error message
				throw new DAOException(e.getMessage());
			}
		}

	}
	
	public static List<User> readTenant() throws DAOException, SQLException {

		List<User> user = new ArrayList<>();
		// SQL query to select all rows from the "userdetails" table
		final String query = "SELECT * FROM Tenantdetails";

		try (Connection connection = ConnectionUtil.getConnection()) {

			try (Statement pst = connection.createStatement()) {

				try (ResultSet rs = pst.executeQuery(query)) {
					// Loop through the result set and populate the User objects
					while (rs.next()) {

						User userData = new User();
						userData.setId(rs.getInt("id"));
						userData.setFirstName(rs.getString("name"));
						userData.setEmail(rs.getString("email"));
						userData.setAddress(rs.getString("address"));
						userData.setpPhoneNum(rs.getString("phonenumber"));
						userData.setPassword(rs.getString("password"));
						userData.setBikephotourl(rs.getString("bikephotourl"));

						user.add(userData);

					}
					// Return the list of users
					return user;
				}
			} catch (SQLException e) {
				// If an SQLException occurs, throw a DAOException with a custom error message
				throw new DAOException(e.getMessage());
			}
		}

	}
	
	
	public static User login(String email) throws DAOException {

		try (Connection con = ConnectionUtil.getConnection()) {

			// SQL query to delete the user from the 'user' table.
			String query = "SELECT * FROM userdetails WHERE email = ?";

			// Prepares the SQL query with the user_id.
			try (PreparedStatement psmt = con.prepareStatement(query)) {

				// Sets the user_id in the PreparedStatement.
				psmt.setString(1, email);
				

				// Executes the delete query.
				try (ResultSet rs = psmt.executeQuery()) {

					if (rs.next()) {
						User userData = new User();

						userData.setId(rs.getInt("id"));
						userData.setFirstName(rs.getString("name"));
						userData.setEmail(rs.getString("email"));
						userData.setAddress(rs.getString("address"));
						userData.setpPhoneNum(rs.getString("phonenumber"));
						userData.setPassword(rs.getString("password"));
						userData.setMapurl(rs.getString("mapurl"));
						userData.setPlacephotourl(rs.getString("placephotourl"));
						userData.setLatitude(rs.getDouble("lattitude"));
						userData.setLongitude(rs.getDouble("longitude"));
						return userData;
					}
				}

			}
			return null;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	public static User tenantlogin(String email) throws DAOException {

		try (Connection con = ConnectionUtil.getConnection()) {

			// SQL query to delete the user from the 'user' table.
			String query = "SELECT * FROM Tenantdetails WHERE email = ?";

			// Prepares the SQL query with the user_id.
			try (PreparedStatement psmt = con.prepareStatement(query)) {

				// Sets the user_id in the PreparedStatement.
				psmt.setString(1, email);
				

				// Executes the delete query.
				try (ResultSet rs = psmt.executeQuery()) {

					if (rs.next()) {
						User userData = new User();

						userData.setId(rs.getInt("id"));
						userData.setFirstName(rs.getString("name"));
						userData.setEmail(rs.getString("email"));
						userData.setAddress(rs.getString("address"));
						userData.setpPhoneNum(rs.getString("phonenumber"));
						userData.setPassword(rs.getString("password"));
						userData.setBikephotourl(rs.getString("bikephotourl"));
						return userData;
					}
				}

			}
			return null;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	public List<String> getAllUserEmails() throws DAOException {

		// ArrayList to store the user email addresses.
		List<String> userNames = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnection()) {
			// SQL query to retrieve all email addresses from the 'user' table.
			String query = "SELECT email FROM userdetails";

			// Creates a Statement object to execute the query.
			try (Statement smt = con.createStatement()) {

				// Executes the query and retrieves the results in a ResultSet.
				try (ResultSet resultSet = smt.executeQuery(query)) {

					// Iterates through the ResultSet and adds each email to the ArrayList.
					while (resultSet.next()) {
						userNames.add(resultSet.getString(1));
					}
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

		return userNames;
	}
	
	public List<String> getAllTenantEmails() throws DAOException {

		// ArrayList to store the user email addresses.
		List<String> userNames = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnection()) {
			// SQL query to retrieve all email addresses from the 'user' table.
			String query = "SELECT email FROM Tenantdetails";

			// Creates a Statement object to execute the query.
			try (Statement smt = con.createStatement()) {

				// Executes the query and retrieves the results in a ResultSet.
				try (ResultSet resultSet = smt.executeQuery(query)) {

					// Iterates through the ResultSet and adds each email to the ArrayList.
					while (resultSet.next()) {
						userNames.add(resultSet.getString(1));
					}
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

		return userNames;
	}
	
//	public boolean isUserExist(User user) throws DAOException {
//		// Retrieves all user email addresses from the 'user' table.
//		List<String> userEmails = getAllUserEmails();
//		
//		// Checks if the provided user's email is in the list of user emails.
//		return userEmails.contains(user.getEmail());
//	}
	
	public static boolean isUserExist(String email) throws DAOException {
		final String query = "SELECT email FROM userdetails WHERE email = ?";
		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, email);
				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						return true;
					} 
				}
			}
		} catch (SQLException e) {
			throw new DAOException(UserDaoErrors.EMAIL_EXIST);
		}
		return false;
	}
	
	public static boolean isTenantExist(String email) throws DAOException {
		final String query = "SELECT email FROM Tenantdetails WHERE email = ?";
		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, email);
				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						return true;
					} 
				}
			}
		} catch (SQLException e) {
			throw new DAOException(UserDaoErrors.EMAIL_EXIST);
		}
		return false;
	}
	
	public static User getUserById(int leaserId) throws DAOException {

		try (Connection con = ConnectionUtil.getConnection()) {

			// SQL query to delete the user from the 'user' table.
			String query = "SELECT * FROM userdetails WHERE id = ?";

			User userData;
			// Prepares the SQL query with the user_id.
			try (PreparedStatement psmt = con.prepareStatement(query)) {

				
				psmt.setInt(1, leaserId);
				

				// Executes the delete query.
				try (ResultSet rs = psmt.executeQuery()) {

					if (rs.next()) {
						userData = new User();
						userData.setFirstName(rs.getString("name"));
						userData.setEmail(rs.getString("email"));
						userData.setAddress(rs.getString("address"));
						userData.setpPhoneNum(rs.getString("phonenumber"));
						userData.setPassword(rs.getString("password"));
						userData.setMapurl(rs.getString("mapurl"));
						userData.setPlacephotourl(rs.getString("placephotourl"));
						userData.setLatitude(rs.getDouble("lattitude"));
						userData.setLongitude(rs.getDouble("longitude"));
						userData.setId(rs.getInt("id"));

						return userData; 
			 		}
				}

			}
			return null;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	
	public static User getTenantByEmail(String email) throws DAOException {

		try (Connection con = ConnectionUtil.getConnection()) {

			// SQL query to delete the user from the 'user' table.
			String query = "SELECT * FROM Tenantdetails WHERE email = ?";

			User userData;
			// Prepares the SQL query with the user_id.
			try (PreparedStatement psmt = con.prepareStatement(query)) {

				
				psmt.setString(1, email);
				

				// Executes the delete query.
				try (ResultSet rs = psmt.executeQuery()) {

					if (rs.next()) {
						userData = new User();
						userData.setFirstName(rs.getString("name"));
						userData.setEmail(rs.getString("email"));
						userData.setAddress(rs.getString("address"));
						userData.setpPhoneNum(rs.getString("phonenumber"));
						userData.setPassword(rs.getString("password"));
						userData.setPlacephotourl(rs.getString("bikephotourl"));

						return userData; 
					} 
				}

			}
			return null;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
}
