// Import necessary classes
package com.fssa.parkinplace.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.parkinplace.exception.ParkinPlaceException;
import com.fssa.parkinplace.model.*;

// Class for validating the properties of a ParkingPlace object
public class ParkingPlaceValidation {
	
	// Method to validate all the properties of a ParkingPlace object
	public static boolean validate(ParkingPlace parkin) {
		// Check if the input ParkingPlace object is null
		if (parkin == null) {
			throw new ParkinPlaceException("Argument cannot be null");
		}

		// Validate each property of the ParkingPlace object using separate validation methods
		ValidateId(parkin.getId());
		ValidatePlaceOwnerName(parkin.getPlaceownername());
		ValidateAddress(parkin.getAddress());
		ValidateLocality(parkin.getLocality());
		ValidateMapUrl(parkin.getMapurl());
		ValidatePlacePhotoUrl(parkin.getPlacephotourl());
		ValidateProofDocUrl(parkin.getProofdocurl());
		ValidateLattitude(parkin.getLattitude());
		ValidateLongitude(parkin.getLongitude());

		// Return true if all validations pass
		return true;
	}

	// Method to validate the ID property of a ParkingPlace object
	public static boolean ValidateId(int id) throws ParkinPlaceException {
		// Check if the ID is 0, which indicates an invalid ID
		if (id == 0) {
			throw new ParkinPlaceException("Id is: Invalid");
		} else {
			return true;
		}
	}

	// Method to validate the PlaceOwnerName property of a ParkingPlace object
	public static boolean ValidatePlaceOwnerName(String placeownername) throws ParkinPlaceException {
		// Check if the PlaceOwnerName is null, empty, or too short (less than 2 characters)
		if (placeownername == null || "".equals(placeownername.trim()) || placeownername.length() < 2) {
			throw new ParkinPlaceException("Placeownername is: Invalid");
		}

		// Regular expression to validate the PlaceOwnerName format (only alphabets, 2 to 30 characters)
		String nameregex = "^[A-Za-z]{2,30}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(placeownername);
		Boolean isMatch = matcher.matches();

		// Check if the PlaceOwnerName matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException("Placeownername is: Invalid");
		}
		return true;
	}

	// Method to validate the Address property of a ParkingPlace object
	public static boolean ValidateAddress(String address) throws ParkinPlaceException {
		// Check if the Address is null or empty
		if (address == null || "".equals(address.trim())) {
			throw new ParkinPlaceException("Address is: Invalid");
		}

		// Regular expression to validate the Address format (at least one non-space character)
		String nameregex = "^(?=.*\\S).+$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(address);
		Boolean isMatch = matcher.matches();

		// Check if the Address matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException("Address should be in minimum 5 letters and maximum 30 letters");
		}
		return true;
	}

	// Method to validate the Locality property of a ParkingPlace object
	public static boolean ValidateLocality(String locality) throws ParkinPlaceException {
		// Check if the Locality is null, empty, or too short (less than 2 characters)
		if (locality == null || "".equals(locality.trim()) || locality.length() < 2) {
			throw new ParkinPlaceException("locality is: Invalid");
		}

		// Regular expression to validate the Locality format (only alphabets, 2 to 30 characters)
		String nameregex = "^[A-Za-z]{2,30}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(locality);
		Boolean isMatch = matcher.matches();

		// Check if the Locality matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException("locality is: Invalid");
		}
		return true;
	}

	// Method to validate the MapUrl property of a ParkingPlace object
	public static boolean ValidateMapUrl(String mapurl) throws ParkinPlaceException {
		// Check if the MapUrl is null, empty, or too short (less than 2 characters)
		if (mapurl == null || "".equals(mapurl.trim()) || mapurl.length() < 2) {
			throw new ParkinPlaceException("mapurl is: Invalid");
		}

		// Regular expression to validate the MapUrl format (should be a valid URL)
		String urlregex = "^(https?|ftp):\\/\\/[^\\s/$.?#].[^\\s]*$";
		Pattern pattern = Pattern.compile(urlregex);
		Matcher matcher = pattern.matcher(mapurl);
		Boolean isMatch = matcher.matches();

		// Check if the MapUrl matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException("mapurl is: Invalid");
		}
		return true;
	}

	// Method to validate the PlacePhotoUrl property of a ParkingPlace object
	public static boolean ValidatePlacePhotoUrl(String placephotourl) throws ParkinPlaceException {
		// Check if the PlacePhotoUrl is null, empty, or too short (less than 2 characters)
		if (placephotourl == null || "".equals(placephotourl.trim()) || placephotourl.length() < 2) {
			throw new ParkinPlaceException("placephotourl is: Invalid");
		}

		// Regular expression to validate the PlacePhotoUrl format (should be a valid imgur URL)
		String urlregex = "(http|https)://(?:www\\.)?imgur\\.com/[a-zA-Z0-9]+";
		Pattern pattern = Pattern.compile(urlregex);
		Matcher matcher = pattern.matcher(placephotourl);
		Boolean isMatch = matcher.matches();

		// Check if the PlacePhotoUrl matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException("placephotourl is: Invalid");
		}
		return true;
	}

	// Method to validate the ProofDocUrl property of a ParkingPlace object
	public static boolean ValidateProofDocUrl(String proofdocurl) throws ParkinPlaceException {
		// Check if the ProofDocUrl is null, empty, or too short (less than 2 characters)
		if (proofdocurl == null || "".equals(proofdocurl.trim()) || proofdocurl.length() < 2) {
			throw new ParkinPlaceException("proofdocurl is: Invalid");
		}

		// Regular expression to validate the ProofDocUrl format (should be a valid URL)
		String urlregex = "(http|https)://(?:www\\.)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}/[a-zA-Z0-9./_-]+";
		Pattern pattern = Pattern.compile(urlregex);
		Matcher matcher = pattern.matcher(proofdocurl);
		Boolean isMatch = matcher.matches();

		// Check if the ProofDocUrl matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException("proofdocurl is: Invalid");
		}
		return true;
	}

	// Method to validate the Lattitude property of a ParkingPlace object
	public static boolean ValidateLattitude(String lattitude) throws ParkinPlaceException {
		// Check if the Lattitude is null, empty, or too short (less than 2 characters)
		if (lattitude == null || "".equals(lattitude.trim()) || lattitude.length() < 2) {
			throw new ParkinPlaceException("lattitude is: Invalid");
		}

		// Regular expression to validate the Lattitude format (should be a valid latitude value)
		String lattitudeRegex = "^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)$";
		Pattern pattern = Pattern.compile(lattitudeRegex);
		Matcher matcher = pattern.matcher(lattitude);
		Boolean isMatch = matcher.matches();

		// Check if the Lattitude matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException("lattitude is: Invalid");
		}
		return true;
	}

	// Method to validate the Longitude property of a ParkingPlace object
	public static boolean ValidateLongitude(String longitude) throws ParkinPlaceException {
		// Check if the Longitude is null, empty, or too short (less than 2 characters)
		if (longitude == null || "".equals(longitude.trim()) || longitude.length() < 2) {
			throw new ParkinPlaceException("longitude is: Invalid");
		}

		// Regular expression to validate the Longitude format (should be a valid longitude value)
		String longitudeRegex = "^[-+]?((1[0-7]|[1-9])?\\d(\\.\\d+)?|180(\\.0+)?)$";
		Pattern pattern = Pattern.compile(longitudeRegex);
		Matcher matcher = pattern.matcher(longitude);
		Boolean isMatch = matcher.matches();

		// Check if the Longitude matches the regular expression pattern
		if (Boolean.FALSE.equals(isMatch)) {
			throw new ParkinPlaceException("longitude is: Invalid");
		}
		return true;
	}
}
