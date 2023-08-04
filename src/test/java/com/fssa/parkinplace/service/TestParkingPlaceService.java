// Test class to perform unit tests for the ParkingPlaceService class
package com.fssa.parkinplace.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.model.ParkingPlace;

public class TestParkingPlaceService {
	
	// Method to create and return a valid ParkingPlace object for testing
	public ParkingPlace parkinPlace() {
		ParkingPlace p1 = new ParkingPlace();
		p1.setId(3);
		p1.setPlaceownername("Srikannan");
		p1.setAddress("25,RaniyammalStreet");
		p1.setLocality("Taramani");
		p1.setMapurl("https://maps.app.goo.gl/xNbnms9FCoKySDEs5");
		p1.setPlacephotourl("https://imgur.com/abc123");
		p1.setProofdocurl("https://iili.io/HUN8VHX.jpg");
		p1.setLattitude("37.7749");
		p1.setLongitude("-122.4194");
		return p1;
	}
	
	// Test to validate the addParkingPlace method of ParkingPlaceService for valid data
	@Test
	public void testValidAddParkingPlace() throws DAOException {
		TestParkingPlaceService placeservice = new TestParkingPlaceService();
		Assertions.assertTrue(ParkingPlaceService.addParkingPlace(placeservice.parkinPlace()));
	}
	
	// Test to validate the updateParkingPlace method of ParkingPlaceService for valid data
	@Test
	public void testValidUpdateParkingPlace() throws DAOException {
		TestParkingPlaceService placeservice = new TestParkingPlaceService();
		Assertions.assertTrue(ParkingPlaceService.updateParkingPlace(placeservice.parkinPlace()));
	}
	
	// Test to validate the deleteParkingPlace method of ParkingPlaceService for valid data
	@Test
	public void testValidDeleteParkingPlace() throws DAOException {
		Assertions.assertTrue(ParkingPlaceService.deleteParkingPlace(3));
	}
	
	// Test to validate the readParkingPlace method of ParkingPlaceService for valid data
	@Test
	public void testValidReadAllParkingPlaces() throws DAOException, SQLException {
		ParkingPlaceService parkingservice = new ParkingPlaceService();
		Assertions.assertTrue(parkingservice.readParkingPlace());
	}
}
