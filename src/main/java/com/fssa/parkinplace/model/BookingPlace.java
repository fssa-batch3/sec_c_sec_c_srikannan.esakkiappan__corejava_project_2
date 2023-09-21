package com.fssa.parkinplace.model;

import java.time.LocalDateTime;

public class BookingPlace {
	
    private int bookingId;
    private String leaserEmail;
    private String tenantEmail;
    private LocalDateTime startingPeriod;
    private LocalDateTime endingPeriod;
    private double amount;
    private String status;
    
    
    public BookingPlace(int bookingId, String leaserEmail, String tenantEmail, LocalDateTime startingPeriod,
			LocalDateTime endingPeriod, double amount, String status) {
		super();
		this.bookingId = bookingId;
		this.leaserEmail = leaserEmail;
		this.tenantEmail = tenantEmail;
		this.startingPeriod = startingPeriod;
		this.endingPeriod = endingPeriod; 
		this.amount = amount;
		this.status = status;
	}

    // Constructors (default and parameterized, if needed)

    // Getter and Setter methods for each field

    public BookingPlace() {
		// TODO Auto-generated constructor stub
	}


	public BookingPlace(String leaserEmail, String tenantEmail, LocalDateTime startingPeriod,
			LocalDateTime endingPeriod, double amount, String status) {
		this.leaserEmail= leaserEmail;
		this.tenantEmail = tenantEmail;
		this.startingPeriod = startingPeriod;
		this.endingPeriod = endingPeriod;
		this.amount = amount;
		this.status = status;
	}



	public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getLeaserEmail() {
        return leaserEmail;
    }

    public void setLeaserEmail(String leaserEmail) {
        this.leaserEmail = leaserEmail;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public LocalDateTime getStartingPeriod() {
        return startingPeriod;
    }

    public void setStartingPeriod(LocalDateTime startingPeriod) {
        this.startingPeriod = startingPeriod;
    }

    public LocalDateTime getEndingPeriod() {
        return endingPeriod;
    }

    public void setEndingPeriod(LocalDateTime endingPeriod) {
        this.endingPeriod = endingPeriod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
