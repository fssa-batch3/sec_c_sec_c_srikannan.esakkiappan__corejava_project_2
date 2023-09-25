package com.fssa.parkinplace.model;

import java.time.LocalDateTime;

public class BookingPlace {
	
    private int bookingId;
    private int leaserId;
	private String tenantEmail;
    private String tenantName;
    private String tenantBikeImg;
    private String tenantPhone;
    private LocalDateTime startingPeriod;
    private LocalDateTime endingPeriod;
    private double amount;
    private String status;
    
    
    public BookingPlace(int bookingId, int leaserId, String tenantEmail, String tenantName, String tenantBikeImg,
			String tenantPhone, LocalDateTime startingPeriod, LocalDateTime endingPeriod, double amount,
			String status) {
		super();
		this.bookingId = bookingId;
		this.leaserId = leaserId; 
		this.tenantEmail = tenantEmail; 
		this.tenantName = tenantName;
		this.tenantBikeImg = tenantBikeImg;
		this.tenantPhone = tenantPhone;
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


    public BookingPlace(String tenantName, String tenantPhone, int leaserId, String tenantBikeImg, String tenantEmail,
			 LocalDateTime startingPeriod, LocalDateTime endingPeriod, double amount,
			String status) {
		super();
		this.tenantName = tenantName;
		this.tenantPhone = tenantPhone;
		this.tenantBikeImg = tenantBikeImg;
		this.leaserId = leaserId;
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

    public int getLeaserId() {
        return leaserId;
    }

    public void setLeaserId(int leaserId) {
        this.leaserId = leaserId;
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
    
    public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getTenantBikeImg() {
		return tenantBikeImg;
	}

	public void setTenantBikeImg(String tenantBikeImg) {
		this.tenantBikeImg = tenantBikeImg;
	}

	public String getTenantPhone() {
		return tenantPhone;
	}

	public void setTenantPhone(String tenantPhone) {
		this.tenantPhone = tenantPhone;
	}

}
