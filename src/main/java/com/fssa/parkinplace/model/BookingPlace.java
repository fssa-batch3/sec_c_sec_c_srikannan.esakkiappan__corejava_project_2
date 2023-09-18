package com.fssa.parkinplace.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingPlace {
    private int id;
    private String leaserEmail;
    private String tenantEmail;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private double amount;
    private String status;
    private String bookingDuration;

    // Getter and Setter methods for 'id' attribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter methods for 'leaserEmail' attribute
    public String getLeaserEmail() {
        return leaserEmail;
    }

    public void setLeaserEmail(String leaserEmail) {
        this.leaserEmail = leaserEmail;
    }

    // Getter and Setter methods for 'tenantEmail' attribute
    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    // Getter and Setter methods for 'startDate' attribute
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    // Getter and Setter methods for 'endDate' attribute
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Getter and Setter methods for 'startTime' attribute
    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    // Getter and Setter methods for 'endTime' attribute
    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    // Getter and Setter methods for 'amount' attribute
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter and Setter methods for 'status' attribute
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and Setter methods for 'bookingDuration' attribute
    public String getBookingDuration() {
        return bookingDuration;
    }

    public void setBookingDuration(String bookingDuration) {
        this.bookingDuration = bookingDuration;
    }
}
