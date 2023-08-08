// Test class to perform unit tests for the ParkingplaceDao class
package com.fssa.parkinplace.dao;

import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.parkinplace.errors.ParkinPlaceDaoErrors;
import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.model.ParkingPlace;

/**
 * Test class to perform unit tests for the ParkingplaceDao class.
 */
public class TestParkingPlaceDao {

	/**
	 * Method to create and return a valid ParkingPlace object for testing.
	 *
	 * @return A valid ParkingPlace object.
	 */
	public static ParkingPlace testValidParkingPlace() {
		ParkingPlace place = new ParkingPlace();
		place.setId(2);
		place.setPlaceownername("Srik");
		place.setAddress("25,kambarstreet");
		place.setLocality("Taramani");
		place.setMapurl("https://maps.app.goo.gl/xNbnms9FCoKySDEs5");
		place.setPlacephotourl("https://iili.io/HUN8VHX.jpg");
		place.setProofdocurl("https://iili.io/HUN8VHX.jpg");
		place.setLattitude("37.7749");
		place.setLongitude("-122.4194");
		return place;
	}

	/**
	 * Method to create and return an invalid ParkingPlace object for testing.
	 *
	 * @return An invalid ParkingPlace object.
	 */
	public static ParkingPlace testInvalidParkingPlace() {
		ParkingPlace place = new ParkingPlace();
		place.setId(-2);
		return place;
	}

	/**
	 * Test to validate the addParkingPlace method of ParkingplaceDao for valid
	 * data.
	 *
	 * @throws DAOException if there is an issue with the DAO operation.
	 */
	@Test
	public void testValidAddParkingPlace() throws DAOException {
		Assertions.assertTrue(ParkingplaceDao.addParkingPlace(testValidParkingPlace()));
	}

	/**
	 * Test to validate the updateParkingPlace method of ParkingplaceDao for valid
	 * data.
	 *
	 * @throws DAOException if there is an issue with the DAO operation.
	 */
	@Test
	public void testValidUpdateParkingPlace() throws DAOException {
		Assertions.assertTrue(ParkingplaceDao.updateParkingPlace(testInvalidParkingPlace()));
	}

	/**
	 * Test to validate the deleteParkingPlace method of ParkingplaceDao for valid
	 * data.
	 *
	 * @throws DAOException if there is an issue with the DAO operation.
	 */
	@Test
	public void testValidDeleteParkingPlace() throws DAOException {
		Assertions.assertTrue(ParkingplaceDao.deleteParkingPlace(testValidParkingPlace().getId()));
	}

	/**
	 * Test to validate the readParkingPlace method of ParkingplaceDao for valid
	 * data.
	 *
	 * @throws DAOException if there is an issue with the DAO operation.
	 * @throws SQLException if there is an issue with SQL operations.
	 */
	@Test
	public void testValidReadAllParkingPlace() throws DAOException, SQLException {
		Assertions.assertTrue(ParkingplaceDao.readParkingPlace());
	}

	/**
	 * Test to validate the addParkingPlace method of ParkingplaceDao for invalid
	 * data.
	 */
	@Test
	public void testInvalidAddParkingPlace() {
		try {
			ParkingplaceDao.addParkingPlace(testInvalidParkingPlace());
		} catch (DAOException ex) {
			Assertions.assertEquals(ParkinPlaceDaoErrors.INVALID_INSERT, ex.getMessage());
		}
	}

	/**
	 * Test to validate the updateParkingPlace method of ParkingplaceDao for invalid
	 * data.
	 */
	@Test
	public void testInvalidUpdateParkingPlace() {
		try {
			ParkingPlace p = new ParkingPlace();
			p.setId(0);
			ParkingplaceDao.updateParkingPlace(p);
		} catch (DAOException ex) {
			Assertions.assertEquals(ParkinPlaceDaoErrors.INVALID_UPDATE, ex.getMessage());
		}
	}

	/**
	 * Test to validate the updateParkingPlace method of ParkingplaceDao for invalid
	 * ID.
	 */
	@Test
	public void testInvalidUpdateParkingPlaceId() {
		try {
			ParkingplaceDao.updateParkingPlace(testInvalidParkingPlace());
		} catch (DAOException ex) {
			Assertions.assertEquals(ParkinPlaceDaoErrors.INVALID_UPDATE, ex.getMessage());
		}
	}

	/**
	 * Test to validate the deleteParkingPlace method of ParkingplaceDao for invalid
	 * ID.
	 */
	@Test
	public void testInvalidDeleteParkingPlaceId() {
		try {
			ParkingplaceDao.deleteParkingPlace(testInvalidParkingPlace().getId());
		} catch (DAOException ex) {
			Assertions.assertEquals(ParkinPlaceDaoErrors.INVALID_DELETE, ex.getMessage());
		}
	}
}
