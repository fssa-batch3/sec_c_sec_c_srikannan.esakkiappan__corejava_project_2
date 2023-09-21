package com.fssa.parkinplace.model;

import javax.validation.constraints.NotNull;

/**
 * Represents a User in the system.
 */
public class User {
    private int userid;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String address;
    @NotNull
    private String phonenum;
    @NotNull
    private String password;
    @NotNull
    private String mapurl;
    @NotNull
    private String placephotourl; 
    private double latitude;
    private double longitude;
    @NotNull
    private String bikephotourl;

    /** 
     * Constructs a User object with the specified attributes.
     *
     * @param name          The user's name.
     * @param address       The user's address.
     * @param email         The user's email.
     * @param phonenum      The user's phone number.
     * @param password      The user's password.
     * @param mapurl        The URL to the user's map.
     * @param placephotourl The URL to the user's place photo.
     */
    public User(String name, String address, String email, String phonenum, String password, String mapurl, String placephotourl, double latitude, double longitude) {
        super();

        this.name = name;
        this.email = email;
        this.address = address; 
        this.phonenum = phonenum;
        this.password = password;
        this.mapurl = mapurl;
        this.placephotourl = placephotourl;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public User(String name, String address, String email, String phonenum, String password,String bikephotourl) {
        super();

        this.name = name;
        this.email = email;
        this.address = address;
        this.phonenum = phonenum;
        this.password = password;
        this.mapurl = mapurl;
        this.bikephotourl = bikephotourl;
    }
    

    public User() {
		// TODO Auto-generated constructor stub
	}

	/**
     * Gets the user's ID.
     *
     * @return The user's ID.
     */
    public int getUserId() {
        return userid;
    }

    /**
     * Sets the user's ID.
     *
     * @param userid The user's ID.
     */
    public void setId(int userid) {
        this.userid = userid;
    }

    /**
     * Gets the user's first name.
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return name;
    } 

    /**
     * Sets the user's first name.
     *
     * @param name The user's first name.
     */
    public void setFirstName(String name) {
        this.name = name;
    }

    /**
     * Gets the user's email.
     *
     * @return The user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     *
     * @param email The user's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's address.
     *
     * @return The user's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the user's address.
     *
     * @param address The user's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the user's phone number.
     *
     * @return The user's phone number.
     */
    public String getPhoneNum() {
        return phonenum;
    }

    /**
     * Sets the user's phone number.
     *
     * @param phonenum The user's phone number.
     */
    public void setpPhoneNum(String phonenum) {
        this.phonenum = phonenum;
    }

    /**
     * Gets the user's password.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password The user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the URL to the user's map.
     *
     * @return The URL to the user's map.
     */
    public String getMapurl() {
        return mapurl;
    }

    /**
     * Sets the URL to the user's map.
     *
     * @param mapurl The URL to the user's map.
     */
    public void setMapurl(String mapurl) {
        this.mapurl = mapurl;
    }

    /**
     * Gets the URL to the user's place photo.
     *
     * @return The URL to the user's place photo.
     */
    public String getPlacephotourl() {
        return placephotourl;
    }

    /**
     * Sets the URL to the user's place photo.
     *
     * @param placephotourl The URL to the user's place photo.
     */
    public void setPlacephotourl(String placephotourl) {
        this.placephotourl = placephotourl;
    }
    
    // Getter method for latitude
    public double getLatitude() {
        return latitude;
    }

    // Setter method for latitude
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    // Getter method for longitude
    public double getLongitude() {
        return longitude;
    }

    // Setter method for longitude
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    
    
    public String getBikephotourl() {
    	return bikephotourl;
    }
    
    public void setBikephotourl(String bikephotourl) {
    	this.bikephotourl = bikephotourl;
    }
}
