// Service class to handle ParkingPlace-related operations
package com.fssa.parkinplace.service;

import java.sql.SQLException;

import com.fssa.parkinplace.dao.ParkingplaceDao;
import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.model.ParkingPlace;
import com.fssa.parkinplace.validation.ParkingPlaceValidation;

public class ParkingPlaceService {
	
	// Method to add a new ParkingPlace to the database
	public static boolean addParkingPlace(ParkingPlace parkin) throws DAOException {
		// Validate the ParkingPlace object using the ParkingPlaceValidation class
		if(ParkingPlaceValidation.validate(parkin)) {
			// If the object is valid, call the addParkingPlace method from the DAO (data access object) to insert the data into the database
			ParkingplaceDao.addParkingPlace(parkin);
		}
		// Return true if the operation was successful
		return true;
	}
	
	// Method to update an existing ParkingPlace in the database
	public static boolean updateParkingPlace(ParkingPlace parkin) throws DAOException {
		// Validate the ParkingPlace object using the ParkingPlaceValidation class
		if(ParkingPlaceValidation.validate(parkin)) {
			// If the object is valid, call the updateParkingPlace method from the DAO to update the data in the database
			ParkingplaceDao.updateParkingPlace(parkin);
		}
		// Return true if the operation was successful
		return true;
	}
	
	// Method to delete a ParkingPlace from the database based on its ID
	public static boolean deleteParkingPlace(int id) throws DAOException {
		// Validate the ID using the ParkingPlaceValidation class
		if(ParkingPlaceValidation.ValidateId(id)) {
			// If the ID is valid, call the deleteParkingPlace method from the DAO to delete the data from the database
			ParkingplaceDao.deleteParkingPlace(id);
		}
		// Return true if the operation was successful
		return true;
	}
	
	// Method to read and display all ParkingPlace objects from the database
	public static boolean readParkingPlace() throws DAOException, SQLException{
		// Call the readParkingPlace method from the DAO to retrieve and display all ParkingPlace objects from the database
		ParkingplaceDao.readParkingPlace();
		// Return true if the operation was successful
		return true;
	}
}
