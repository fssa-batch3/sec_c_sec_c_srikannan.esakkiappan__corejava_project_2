package com.fssa.parkinplace.model;

/**
 * Represents a parking place with various details.
 */
public class ParkingPlace {

    private int id;
    private String placeownername;
    private String address;
    private String locality;
    private String mapurl;
    private String placephotourl;
    private String proofdocurl;
    private String lattitude;
    private String longitude;


    /**
     * Constructs a ParkingPlace object with provided details.
     *
     * @param id for the parking place.
     * @param placeownername Owner's name for the parking place.
     * @param address Address of the parking place.
     * @param locality Locality of the parking place.
     * @param mapurl URL to the map location.
     * @param placephotourl URL to a photo of the parking place.
     * @param proofdocurl URL to proof documents for the parking place.
     * @param lattitude Latitude coordinate of the parking place.
     * @param longitude Longitude coordinate of the parking place.
     */
    public ParkingPlace(int id, String placeownername, String address, String locality, String mapurl,
                        String placephotourl, String proofdocurl, String lattitude, String longitude) {
        super(); // Call the constructor of the superclass (Object class in this case)

        // Initialize the instance variables with the provided values
        this.id = id;
        this.placeownername = placeownername;
        this.address = address;
        this.locality = locality;
        this.mapurl = mapurl;
        this.placephotourl = placephotourl;
        this.proofdocurl = proofdocurl;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    /**
     * Constructs a default ParkingPlace object.
     */
    public ParkingPlace() {

    }
    
    
	// Getter method for the id instance variable
	public int getId() {
		return id;
	}

	// Setter method for the id instance variable
	public void setId(int id) {
		this.id = id;
	}

	// Getter method for the placeownername instance variable
	public String getPlaceownername() {
		return placeownername;
	}

	// Setter method for the placeownername instance variable
	public void setPlaceownername(String placeownername) {
		this.placeownername = placeownername;
	}

	// Getter method for the address instance variable
	public String getAddress() {
		return address;
	}

	// Setter method for the address instance variable
	public void setAddress(String address) {
		this.address = address;
	}

	// Getter method for the locality instance variable
	public String getLocality() {
		return locality;
	}

	// Setter method for the locality instance variable
	public void setLocality(String locality) {
		this.locality = locality;
	}

	// Getter method for the mapurl instance variable
	public String getMapurl() {
		return mapurl;
	}

	// Setter method for the mapurl instance variable
	public void setMapurl(String mapurl) {
		this.mapurl = mapurl;
	}

	// Getter method for the placephotourl instance variable
	public String getPlacephotourl() {
		return placephotourl;
	}

	// Setter method for the placephotourl instance variable
	public void setPlacephotourl(String placephotourl) {
		this.placephotourl = placephotourl;
	}

	// Getter method for the proofdocurl instance variable
	public String getProofdocurl() {
		return proofdocurl;
	}

	// Setter method for the proofdocurl instance variable
	public void setProofdocurl(String proofdocurl) {
		this.proofdocurl = proofdocurl;
	}

	// Getter method for the lattitude instance variable
	public String getLattitude() {
		return lattitude;
	}

	// Setter method for the lattitude instance variable
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	// Getter method for the longitude instance variable
	public String getLongitude() {
		return longitude;
	}

	// Setter method for the longitude instance variable
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
