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

/**
 * This class provides data access methods for interacting with the userdetails table in the database.
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
        final String query = "INSERT INTO userdetails (name, email, address, phonenumber, password, mapurl, placephotourl) VALUES(?,?,?,?,?,?,?)";

        try (Connection connection = ConnectionUtil.getConnection()) {

            try (PreparedStatement data = connection.prepareStatement(query)) {
                data.setString(1, user.getFirstName());
                data.setString(2, user.getEmail());
                data.setString(3, user.getAddress());
                data.setString(4, user.getPhoneNum());
                data.setString(5, user.getPassword());
                data.setString(6, user.getMapurl());
                data.setString(7, user.getPlacephotourl());

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

                pst.setInt(1, id);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    id = rs.getInt("id");

                }

                return id;
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }

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
}
