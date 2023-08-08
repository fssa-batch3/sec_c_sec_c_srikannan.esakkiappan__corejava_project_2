// Import necessary classes
package com.fssa.parkinplace.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.parkinplace.errors.ParkinPlaceValitationErrors;
import com.fssa.parkinplace.exception.ParkinPlaceException;
import com.fssa.parkinplace.model.*;

/**
 * This class provides methods for validating the properties of a ParkingPlace
 * object.
 */
public class ParkingPlaceValidation {

	/**
	 * Validates all the properties of a ParkingPlace object.
	 *
	 * @param parkin The ParkingPlace object to be validated.
	 * @return True if all validations pass.
	 * @throws ParkinPlaceException if there is an issue with the validation.
	 */
	public static boolean validate(ParkingPlace parkin) {
		// Check if the input ParkingPlace object is null
		if (parkin == null) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_OBJECT_NULL);
		}

		ValidateId(parkin.getId());
		ValidatePlaceOwnerName(parkin.getPlaceownername());
		ValidateAddress(parkin.getAddress());
		ValidateLocality(parkin.getLocality());
		ValidateMapUrl(parkin.getMapurl());
		ValidatePlacePhotoUrl(parkin.getPlacephotourl());
		ValidateProofDocUrl(parkin.getProofdocurl());
		ValidateLattitude(parkin.getLattitude());
		ValidateLongitude(parkin.getLongitude());

		return true;
	}

	/**
	 * Validates the ID property of a ParkingPlace object.
	 *
	 * @param id The ID to be validated.
	 * @return True if the validation passes.
	 * @throws ParkinPlaceException if there is an issue with the validation.
	 */
	public static boolean ValidateId(int id) throws ParkinPlaceException {
		// Check if the ID is 0, which indicates an invalid ID
		if (id == 0) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_ID);
		} else {
			return true;
		}
	}

	/**
	 * Validates the PlaceOwnerName property of a ParkingPlace object.
	 *
	 * @param placeownername The PlaceOwnerName to be validated.
	 * @return True if the validation passes.
	 * @throws ParkinPlaceException if there is an issue with the validation.
	 */

	public static boolean ValidatePlaceOwnerName(String placeownername) throws ParkinPlaceException {
		// Check if the PlaceOwnerName is null, empty, or too short (less than 2
		// characters)
		if (placeownername == null || "".equals(placeownername.trim()) || placeownername.length() < 2) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_PLACEOWNERNAME);
		}

		// Regular expression to validate the PlaceOwnerName format (only alphabets, 2
		// to 30 characters)
		String nameregex = "^[A-Za-z]{2,30}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(placeownername);
		Boolean isMatch = matcher.matches();

		// Check if the PlaceOwnerName matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_PLACEOWNERNAME);
		}
		return true;
	}

	/**
	 * Validates the Address property of a ParkingPlace object.
	 *
	 * @param address The Address to be validated.
	 * @return True if the validation passes.
	 * @throws ParkinPlaceException if there is an issue with the validation.
	 */
	public static boolean ValidateAddress(String address) throws ParkinPlaceException {
		// Check if the Address is null or empty
		if (address == null || "".equals(address.trim())) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_ADDRESS);
		}

		// Regular expression to validate the Address format (at least one non-space
		// character)
		String nameregex = "^(?=.*\\S).+$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(address);
		Boolean isMatch = matcher.matches();

		// Check if the Address matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_ADDRESS_LENGTH);
		}
		return true;
	}

	/**
	 * Validates the Locality property of a ParkingPlace object.
	 *
	 * @param locality The Locality to be validated.
	 * @return True if the validation passes.
	 * @throws ParkinPlaceException if there is an issue with the validation.
	 */
	public static boolean ValidateLocality(String locality) throws ParkinPlaceException {
		// Check if the Locality is null, empty, or too short (less than 2 characters)
		if (locality == null || "".equals(locality.trim()) || locality.length() < 2) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_LOCALITY);
		}

		// Regular expression to validate the Locality format (only alphabets, 2 to 30
		// characters)
		String nameregex = "^[A-Za-z]{2,30}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(locality);
		Boolean isMatch = matcher.matches();

		// Check if the Locality matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_LOCALITY);
		}
		return true;
	}

	/**
	 * Validates the MapUrl property of a ParkingPlace object.
	 *
	 * @param mapurl The MapUrl to be validated.
	 * @return True if the validation passes.
	 * @throws ParkinPlaceException if there is an issue with the validation.
	 */
	public static boolean ValidateMapUrl(String mapurl) throws ParkinPlaceException {
		// Check if the MapUrl is null, empty, or too short (less than 2 characters)
		if (mapurl == null || "".equals(mapurl.trim()) || mapurl.length() < 2) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_MAPURL);
		}

		// Regular expression to validate the MapUrl format (should be a valid URL)
		String urlregex = "^(https?|ftp):\\/\\/[^\\s/$.?#].[^\\s]*$";
		Pattern pattern = Pattern.compile(urlregex);
		Matcher matcher = pattern.matcher(mapurl);
		Boolean isMatch = matcher.matches();

		// Check if the MapUrl matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_MAPURL);
		}
		return true;
	}

	/**
	 * Validates the PlacePhotoUrl property of a ParkingPlace object.
	 *
	 * @param placephotourl The PlacePhotoUrl to be validated.
	 * @return True if the validation passes.
	 * @throws ParkinPlaceException if there is an issue with the validation.
	 */
	public static boolean ValidatePlacePhotoUrl(String placephotourl) throws ParkinPlaceException {
		// Check if the PlacePhotoUrl is null, empty, or too short (less than 2
		// characters)
		if (placephotourl == null || "".equals(placephotourl.trim()) || placephotourl.length() < 2) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_PLACEPHOTOURL);
		}

		// Regular expression to validate the PlacePhotoUrl format (should be a valid
		// imgur URL)
		String urlregex = "(http|https)://(?:www\\.)?imgur\\.com/[a-zA-Z0-9]+";
		Pattern pattern = Pattern.compile(urlregex);
		Matcher matcher = pattern.matcher(placephotourl);
		Boolean isMatch = matcher.matches();

		// Check if the PlacePhotoUrl matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_PLACEPHOTOURL);
		}
		return true;
	}

	/**
	 * Validates the ProofDocUrl property of a ParkingPlace object.
	 *
	 * @param proofdocurl The ProofDocUrl to be validated.
	 * @return True if the validation passes.
	 * @throws ParkinPlaceException if there is an issue with the validation.
	 */
	public static boolean ValidateProofDocUrl(String proofdocurl) throws ParkinPlaceException {
		// Check if the ProofDocUrl is null, empty, or too short (less than 2
		// characters)
		if (proofdocurl == null || "".equals(proofdocurl.trim()) || proofdocurl.length() < 2) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_PROOFDOCUMENTURL);
		}

		// Regular expression to validate the ProofDocUrl format (should be a valid URL)
		String urlregex = "(http|https)://(?:www\\.)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}/[a-zA-Z0-9./_-]+";
		Pattern pattern = Pattern.compile(urlregex);
		Matcher matcher = pattern.matcher(proofdocurl);
		Boolean isMatch = matcher.matches();

		// Check if the ProofDocUrl matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_PROOFDOCUMENTURL);
		}
		return true;
	}

	/**
	 * Validates the Lattitude property of a ParkingPlace object.
	 *
	 * @param lattitude The Lattitude to be validated.
	 * @return True if the validation passes.
	 * @throws ParkinPlaceException if there is an issue with the validation.
	 */
	public static boolean ValidateLattitude(String lattitude) throws ParkinPlaceException {
		// Check if the Lattitude is null, empty, or too short (less than 2 characters)
		if (lattitude == null || "".equals(lattitude.trim()) || lattitude.length() < 2) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_LATTITUDE);
		}

		// Regular expression to validate the Lattitude format (should be a valid
		// latitude value)
		String lattitudeRegex = "^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)$";
		Pattern pattern = Pattern.compile(lattitudeRegex);
		Matcher matcher = pattern.matcher(lattitude);
		Boolean isMatch = matcher.matches();

		// Check if the Lattitude matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_LATTITUDE);
		}
		return true;
	}

	/**
	 * Validates the Longitude property of a ParkingPlace object.
	 *
	 * @param longitude The Longitude to be validated.
	 * @return True if the validation passes.
	 * @throws ParkinPlaceException if there is an issue with the validation.
	 */
	public static boolean ValidateLongitude(String longitude) throws ParkinPlaceException {
		// Check if the Longitude is null, empty, or too short (less than 2 characters)
		if (longitude == null || "".equals(longitude.trim()) || longitude.length() < 2) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_LONGITUDE);
		}

		// Regular expression to validate the Longitude format (should be a valid
		// longitude value)
		String longitudeRegex = "^[-+]?((1[0-7]|[1-9])?\\d(\\.\\d+)?|180(\\.0+)?)$";
		Pattern pattern = Pattern.compile(longitudeRegex);
		Matcher matcher = pattern.matcher(longitude);
		Boolean isMatch = matcher.matches();

		// Check if the Longitude matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException(ParkinPlaceValitationErrors.INVALID_LONGITUDE);
		}
		return true;
	}
}
