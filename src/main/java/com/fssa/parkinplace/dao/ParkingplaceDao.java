// Class to perform database operations related to ParkingPlace objects
package com.fssa.parkinplace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.parkinplace.errors.ParkinPlaceDaoErrors;
import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.model.ParkingPlace;

/**
 * This class performs database operations related to ParkingPlace objects.
 */

public class ParkingplaceDao {

	/**
     * Adds a ParkingPlace object to the database.
     *
     * @param parkin The ParkingPlace object to be added.
     * @return True if the insertion was successful, false otherwise.
     * @throws DAOException if there is an issue with the database operation.
     */
	
	public static boolean addParkingPlace(ParkingPlace parkin) throws DAOException {

		// SQL query to insert a new row into the "parkingplace" table
		final String query = "INSERT INTO parkingplace (placeownername, address , locality , mapurl , placephotourl , proofdocurl , lattitude , longitude) VALUES(?,?,?,?,?,?,?,?);";

		try (Connection connection = ConnectionUtil.getConnection()) {
			// Using try-with-resources to automatically close the resources (Connection and PreparedStatement)

			try (PreparedStatement place = connection.prepareStatement(query)) {
				// Set the values for the PreparedStatement using the ParkingPlace object
				place.setString(1, parkin.getPlaceownername());
				place.setString(2, parkin.getAddress());
				place.setString(3, parkin.getLocality());
				place.setString(4, parkin.getMapurl());
				place.setString(5, parkin.getPlacephotourl());
				place.setString(6, parkin.getProofdocurl());
				place.setString(7, parkin.getLattitude());
				place.setString(8, parkin.getLongitude());
				
				// Execute the query to insert the data into the database
				int row = place.executeUpdate();

				// Print a success message and return true if the insertion was successful
				System.out.println("Parking place Added Successfully");
				return (row > 0) ? true : false;
			}

		} catch (SQLException e) {
			// If an SQLException occurs, throw a DAOException with a custom error message
			throw new DAOException(ParkinPlaceDaoErrors.INVALID_INSERT);
		}
	}

	/**
     * Update a ParkingPlace object in the database.
     *
     * @param parkin The ParkingPlace object to be updated.
     * @return True if the update was successful, false otherwise.
     * @throws DAOException if there is an issue with the database operation.
     */
	
	public static boolean updateParkingPlace(ParkingPlace parkin) throws DAOException {

		// SQL query to update an existing row in the "parkingplace" table based on the ID
		final String query = "UPDATE parkingplace SET placeownername=?, address=?, locality=?, mapurl=?, placephotourl=?, proofdocurl=?, lattitude=?, longitude=? WHERE id=?";

		try (Connection connection = ConnectionUtil.getConnection()) {
			// Using try-with-resources to automatically close the resources (Connection and PreparedStatement)

			try (PreparedStatement place = connection.prepareStatement(query)) {
				// Set the values for the PreparedStatement using the ParkingPlace object
				place.setString(1, parkin.getPlaceownername());
				place.setString(2, parkin.getAddress());
				place.setString(3, parkin.getLocality());
				place.setString(4, parkin.getMapurl());
				place.setString(5, parkin.getPlacephotourl());
				place.setString(6, parkin.getProofdocurl());
				place.setString(7, parkin.getLattitude());
				place.setString(8, parkin.getLongitude());
				place.setInt(9, parkin.getId());

				// Execute the query to update the data in the database
				int row = place.executeUpdate();

				// Return true if the update was successful
				return row > 0;
			}
		} catch (SQLException e) {
			// If an SQLException occurs, throw a DAOException with a custom error message
			throw new DAOException(ParkinPlaceDaoErrors.INVALID_UPDATE);
		}
	}

	// Method to delete a ParkingPlace object from the database based on its ID
	public static boolean deleteParkingPlace(int id) throws DAOException {

		/**
	     * Deletes a ParkingPlace object from the database based on its ID.
	     *
	     * @param id The ID of the ParkingPlace object to be deleted.
	     * @return True if the deletion was successful, false otherwise.
	     * @throws DAOException if there is an issue with the database operation.
	     */
		
		final String query = "DELETE FROM parkingplace WHERE id=?";

		try (Connection connection = ConnectionUtil.getConnection()) {
			// Using try-with-resources to automatically close the resources (Connection and PreparedStatement)

			try (PreparedStatement place = connection.prepareStatement(query)) {
				// Set the value for the PreparedStatement using the provided ID
				place.setInt(1, id);

				// Execute the query to delete the data from the database
				int rowsDeleted = place.executeUpdate();

				// Return true if the delete was successful
				return rowsDeleted > 0;
			}
		} catch (SQLException e) {
			// If an SQLException occurs, throw a DAOException with a custom error message
			throw new DAOException(ParkinPlaceDaoErrors.INVALID_DELETE);
		}
	}

	/**
     * Reads and displays all ParkingPlace objects from the database.
     *
     * @return True if the reading was successful, false otherwise.
     * @throws DAOException if there is an issue with the database operation.
     * @throws SQLException if there is an issue with SQL execution.
     */
	
	public static boolean readParkingPlace() throws DAOException, SQLException {

		// SQL query to select all rows from the "parkingplace" table
		final String query = "SELECT * FROM parkingplace ";

		try (Connection connection = ConnectionUtil.getConnection()) {
			// Using try-with-resources to automatically close the resources (Connection and Statement)

			try (Statement pst = connection.createStatement()) {
				// Using try-with-resources to automatically close the resources (ResultSet)

				try (ResultSet rs = pst.executeQuery(query)) {
					// Loop through the result set and print the ID of each ParkingPlace object
					while (rs.next()) {
						System.out.print(rs.getInt("id"));
					}
					// Return true to indicate that the reading was successful
					return true;
				}
			} catch (SQLException e) {
				// If an SQLException occurs, throw a DAOException with a custom error message
				throw new DAOException(ParkinPlaceDaoErrors.INVALID_READ);
			}
		}
	}

}
