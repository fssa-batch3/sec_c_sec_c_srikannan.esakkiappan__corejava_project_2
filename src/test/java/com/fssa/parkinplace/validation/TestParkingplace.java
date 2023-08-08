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
		
	
		ParkingPlace invalidParking = new ParkingPlace(null, null, null, null, null, null, null, null);
		
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
	public void validTestObject() throws ParkinPlaceException, InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.validate(park));
	}

	/**
	 * Test to validate an invalid ParkingPlace object (null).
	 */
	@Test
	public void inValidTestObject() {
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
	public void validTestId() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.ValidateId(park.getId()));
	}

	/**
	 * Test to validate an invalid ParkingPlace ID (less than 1).
	 */
	@Test
	public void inValidTestId() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.ValidateId(invalidPark.getId());
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
	public void validTestOwnerName() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.ValidatePlaceOwnerName(park.getPlaceownername()));
	}

	/**
	 * Test to validate an invalid Place Owner Name (less than 2 characters).
	 */
	@Test
	public void inValidTestOwnerName() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.ValidatePlaceOwnerName(invalidPark.getPlaceownername());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_PLACEOWNERNAME, e.getMessage());
		}

		try {
			ParkingPlaceValidation.ValidatePlaceOwnerName("67sri");
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
	public void validTestAddress() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.ValidateAddress(park.getAddress()));
	}

	/**
	 * Test to validate an invalid Address (less than 5 characters).
	 */
	@Test
	public void inValidTestAddress() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.ValidateAddress(invalidPark.getAddress());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_ADDRESS, e.getMessage());
		}

		try {
			ParkingPlaceValidation.ValidateAddress("@1y");
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
	public void validTestLocality() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.ValidateLocality(park.getLocality()));
		
	}

	/**
	 * Test to validate an invalid Locality (less than 2 characters).
	 */
	@Test
	public void inValidTestLocality() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.ValidateLocality(invalidPark.getLocality());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_LOCALITY, e.getMessage());
		}

		try {
			ParkingPlaceValidation.ValidateLocality("@#$jhry");
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
	public void validTestMapUrl() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.ValidateMapUrl(park.getMapurl()));
	}

	/**
	 * Test to validate an invalid Map URL.
	 */
	@Test
	public void inValidTestMapUrl() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.ValidateMapUrl(invalidPark.getMapurl());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_MAPURL, e.getMessage());
		}

		try {
			ParkingPlaceValidation.ValidateMapUrl("@#$jhry");
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
	public void validTestPhotoUrl() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.ValidatePlacePhotoUrl(park.getPlacephotourl()));
	}

	/**
     * Test to validate an invalid Place Photo URL.
     */
	@Test
	public void inValidTestPhotoUrl() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.ValidatePlacePhotoUrl(invalidPark.getPlacephotourl());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_PLACEPHOTOURL, e.getMessage());
		}

		try {
			ParkingPlaceValidation.ValidatePlacePhotoUrl("@#$jhry");
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
	public void validTestProofDocUrl() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.ValidateProofDocUrl(park.getProofdocurl()));
	}

	/**
     * Test to validate an invalid Proof Document URL.
     */
	@Test
	public void inValidTestProofDocUrl() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.ValidateProofDocUrl(invalidPark.getProofdocurl());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_PROOFDOCUMENTURL, e.getMessage());
		}

		try {
			ParkingPlaceValidation.ValidateProofDocUrl("@#$jhry");
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
	public void validTestLattitude() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.ValidateLattitude(park.getLattitude()));
	}

	/**
	 * Test to validate an invalid Lattitude.
	 */
	@Test
	public void inValidTestLattitude() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.ValidateLattitude(invalidPark.getLattitude());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_LATTITUDE, e.getMessage());
		}

		try {
			ParkingPlaceValidation.ValidateLattitude("@#$jhry");
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
	public void validTestLongitude() throws InvalidParkingPlaceException {
		ParkingPlace park = TestParkingplace.testValidParkingPlace();
		Assertions.assertTrue(ParkingPlaceValidation.ValidateLongitude(park.getLongitude()));
	}

	/**
	 * Test to validate an invalid Longitude.
	 */
	@Test
	public void inValidTestLongitude() {
		ParkingPlace invalidPark = TestParkingplace.testInvalidParkingPlace();
		try {
			ParkingPlaceValidation.ValidateLongitude(invalidPark.getLongitude());
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_LONGITUDE, e.getMessage());
		}

		try {
			ParkingPlaceValidation.ValidateLongitude("@#$jhry");
		} catch (ParkinPlaceException e) {
			Assertions.assertEquals(ParkinPlaceValitationErrors.INVALID_LONGITUDE, e.getMessage());
		}
	}
}
