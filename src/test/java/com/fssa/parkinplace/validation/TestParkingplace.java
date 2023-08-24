// Test class to perform unit tests for the ParkingPlaceValidation class
package com.fssa.parkinplace.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.parkinplace.errors.ParkinPlaceValitationErrors;
import com.fssa.parkinplace.exception.InvalidParkingPlaceException;
import com.fssa.parkinplace.exception.ParkinPlaceException;
import com.fssa.parkinplace.model.ParkingPlace;

/**
 * Test class to perform unit tests for the ParkingPlaceValidation class.
 */
public class TestParkingplace {

	/**
	 * Method to create and return an invalid ParkingPlace object for testing.
	 *
	 * @return An invalid ParkingPlace object.
	 */
	public static ParkingPlace testInvalidParkingPlace() {
		
	
		ParkingPlace invalidParking = new ParkingPlace(0, null, null, null, null, null, null, null, null);
		
		return invalidParking;
	}

	
	/**
	 * Method to create and return a valid ParkingPlace object for testing.
	 *
	 * @return A valid ParkingPlace object.
	 * @throws InvalidParkingPlaceException if there is an issue with the ParkingPlace object creation.
	 */
	public static ParkingPlace testValidParkingPlace() throws InvalidParkingPlaceException {
		ParkingPlace p = new ParkingPlace();
		p.setId(3);
		p.setPlaceownername("Srikannan");
		p.setAddress("25,Raniyammalnagar");
		p.setLocality("Taramani");
		p.setMapurl("https://maps.google.com?q=location");
		p.setPlacephotourl("https://imgur.com/abc123");
		p.setProofdocurl("https://www.example.com/documents/sample_document.pdf");
		p.setLattitude("37.7749");
		p.setLongitude("-122.4194");
		return p;
	}
	

	/**
	 * Test to validate a valid ParkingPlace object.
	 *
	 * @throws ParkinPlaceException if there is an issue with the ParkingPlace validation.
	 * @throws InvalidParkingPlaceException if there is an issue with the ParkingPlace object creation.
	 */
	@Test
	 void validTestObject() throws ParkinPlaceException, InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.validate(park));
	}

	/**
	 * Test to validate an invalid ParkingPlace object (null).
	 */
	@Test
	 void inValidTestObject() {
		try {
			ParkingPlaceValidation.validate(null);
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_OBJECT_NULL, e.getMessage());
		}
	}

	/**
	 * Test to validate a valid ParkingPlace ID.
	 *
	 * @throws InvalidParkingPlaceException if there is an issue with the ParkingPlace object creation.
	 */
	@Test
	 void validTestId() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.validateId(park.getId()));
	}

	/**
	 * Test to validate an invalid ParkingPlace ID (less than 1).
	 */
	@Test
	 void inValidTestId() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.validateId(invalidPark.getId());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_ID, e.getMessage());
		}
	}

	/**
	 * Test to validate a valid Place Owner Name.
	 *
	 * @throws InvalidParkingPlaceException if there is an issue with the ParkingPlace object.
	 */
	@Test
	 void validTestOwnerName() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.validatePlaceOwnerName(park.getPlaceownername()));
	}

	/**
	 * Test to validate an invalid Place Owner Name (less than 2 characters).
	 */
	@Test
	 void inValidTestOwnerName() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.validatePlaceOwnerName(invalidPark.getPlaceownername());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_PLACEOWNERNAME, e.getMessage());
		}

		try {
			ParkingPlaceValidation.validatePlaceOwnerName("67sri");
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_PLACEOWNERNAME, e.getMessage());
		}
	}

	/**
	 * Test to validate a valid Address.
	 *
	 * @throws InvalidParkingPlaceException if there is an issue with the ParkingPlace object.
	 */
	@Test
	 void validTestAddress() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.validateAddress(park.getAddress()));
	}

	/**
	 * Test to validate an invalid Address (less than 5 characters).
	 */
	@Test
	 void inValidTestAddress() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.validateAddress(invalidPark.getAddress());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_ADDRESS, e.getMessage());
		}

		try {
			ParkingPlaceValidation.validateAddress("@1y");
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_ADDRESS_LENGTH, e.getMessage());
		}
	}

	/**
	 * Test to validate a valid Locality.
	 *
	 * @throws InvalidParkingPlaceException if there is an issue with the ParkingPlace object.
	 */
	@Test
	 void validTestLocality() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.validateLocality(park.getLocality()));
		
	}

	/**
	 * Test to validate an invalid Locality (less than 2 characters).
	 */
	@Test
	 void inValidTestLocality() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.validateLocality(invalidPark.getLocality());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_LOCALITY, e.getMessage());
		}

		try {
			ParkingPlaceValidation.validateLocality("@#$jhry");
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_LOCALITY, e.getMessage());
		}
	}

	/**
	 * Test to validate a valid Map URL.
	 *
	 * @throws InvalidParkingPlaceException if there is an issue with the ParkingPlace object.
	 */
	@Test
	 void validTestMapUrl() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.validateMapUrl(park.getMapurl()));
	}

	/**
	 * Test to validate an invalid Map URL.
	 */
	@Test
	 void inValidTestMapUrl() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.validateMapUrl(invalidPark.getMapurl());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_MAPURL, e.getMessage());
		}

		try {
			ParkingPlaceValidation.validateMapUrl("@#$jhry");
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_MAPURL, e.getMessage());
		}
	}

	 /**
     * Test to validate a valid Place Photo URL.
     *
     * @throws InvalidParkingPlaceException if there's an issue with the ParkingPlace object.
     */
	@Test
	 void validTestPhotoUrl() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.validatePlacePhotoUrl(park.getPlacephotourl()));
	}

	/**
     * Test to validate an invalid Place Photo URL.
     */
	@Test
	 void inValidTestPhotoUrl() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.validatePlacePhotoUrl(invalidPark.getPlacephotourl());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_PLACEPHOTOURL, e.getMessage());
		}

		try {
			ParkingPlaceValidation.validatePlacePhotoUrl("@#$jhry");
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_PLACEPHOTOURL, e.getMessage());
		}
	}

	/**
     * Test to validate a valid Proof Document URL.
     *
     * @throws InvalidParkingPlaceException if there's an issue with the ParkingPlace object.
     */
	@Test
	 void validTestProofDocUrl() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.validateProofDocUrl(park.getProofdocurl()));
	}

	/**
     * Test to validate an invalid Proof Document URL.
     */
	@Test
	 void inValidTestProofDocUrl() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.validateProofDocUrl(invalidPark.getProofdocurl());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_PROOFDOCUMENTURL, e.getMessage());
		}

		try {
			ParkingPlaceValidation.validateProofDocUrl("@#$jhry");
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_PROOFDOCUMENTURL, e.getMessage());
		}
	}

	/**
	 * Test to validate a valid Lattitude.
	 *
	 * @throws InvalidParkingPlaceException if there is an issue with the ParkingPlace object.
	 */
	@Test
	 void validTestLattitude() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.validateLattitude(park.getLattitude()));
	}

	/**
	 * Test to validate an invalid Lattitude.
	 */
	@Test
	 void inValidTestLattitude() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.validateLattitude(invalidPark.getLattitude());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_LATTITUDE, e.getMessage());
		}

		try {
			ParkingPlaceValidation.validateLattitude("@#$jhry");
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_LATTITUDE, e.getMessage());
		}
	}

	/**
	 * Test to validate a valid Longitude.
	 *
	 * @throws InvalidParkingPlaceException if there is an issue with the ParkingPlace object.
	 */
	@Test
	 void validTestLongitude() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.validateLongitude(park.getLongitude()));
	}

	/**
	 * Test to validate an invalid Longitude.
	 */
	@Test
	 void inValidTestLongitude() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.validateLongitude(invalidPark.getLongitude());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_LONGITUDE, e.getMessage());
		}

		try {
			ParkingPlaceValidation.validateLongitude("@#$jhry");
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_LONGITUDE, e.getMessage());
		}
	}
}
