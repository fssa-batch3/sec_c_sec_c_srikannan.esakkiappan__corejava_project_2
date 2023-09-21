package com.fssa.parkinplace.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.model.BookingPlace;
import com.fssa.parkinplace.service.BookingPlaceService;

class TestBookingPlaceService {
	
	public BookingPlace bookingPlaceDetails() {
		BookingPlace p = new BookingPlace();
		p.setBookingId(1);
		p.setLeaserEmail("sri@gmail.com");
		p.setTenantEmail("srik@gmail.com");
		p.setStartingPeriod(LocalDateTime.now());
		p.setEndingPeriod(LocalDateTime.now().plusDays(7));
		p.setAmount(100.0);
		p.setStatus("Accepted");
		return p;
	}
	
	public BookingPlace updateBookingPlaceDetails() {
		BookingPlace p = new BookingPlace();
		p.setBookingId(1);
		p.setLeaserEmail("sri@gmail.com");
		p.setTenantEmail("srikannan@gmail.com");
		p.setStartingPeriod(LocalDateTime.now());
		p.setEndingPeriod(LocalDateTime.now().plusDays(3));
		p.setAmount(80.0);
		p.setStatus("WaitingList");
		return p;
	}
	
	@Test
	void testValidAddBooking() throws DAOException {
		TestBookingPlaceService bookingPlaceService = new TestBookingPlaceService();
		Assertions.assertTrue(BookingPlaceService.createBookingPlace(bookingPlaceService.bookingPlaceDetails()));
	}
	
	@Test
	void testValidGetAllBookingPlaces() throws DAOException, SQLException {
		Set<BookingPlace> allPlaces = BookingPlaceService.getAllBookingPlaces();
		Assertions.assertNotNull(allPlaces);
	}
	
	@Test
	void testValidGetAllBookingPlacesByStatus() throws DAOException, SQLException{
		Set<BookingPlace> getByStatus = BookingPlaceService.getAllBookingPlacesByStatus(bookingPlaceDetails().getStatus());
		Assertions.assertNotNull(getByStatus);
	}
	
	@Test
	void testValidAllBookingPlacesByLeaserEmail() throws DAOException, SQLException{
		Set<BookingPlace> getByLeaserEmail = BookingPlaceService.getAllBookingPlacesByLeaserEmail(bookingPlaceDetails().getLeaserEmail());
		Assertions.assertNotNull(getByLeaserEmail);
	}
	
	@Test
	void testValidAllBookingPlacesByTenantEmail() throws DAOException, SQLException{ 
		Set<BookingPlace> getByTenantEmail = BookingPlaceService.getAllBookingPlacesByTenantEmail(bookingPlaceDetails().getTenantEmail());
		Assertions.assertNotNull(getByTenantEmail);
	}
	
	@Test
	void testValidFindByBookingPlaceId() throws DAOException, SQLException{
		TestBookingPlaceService bookingService = new TestBookingPlaceService();
		Assertions.assertNotNull(BookingPlaceService.findByBookingPlaceId(bookingPlaceDetails().getBookingId()));
	}
	
	@Test
	void testValidUpdateBooking() throws DAOException, SQLException {
		TestBookingPlaceService bookingPlaceService = new TestBookingPlaceService();
		Assertions.assertTrue(BookingPlaceService.updateBookingPlace(bookingPlaceService.updateBookingPlaceDetails()));
	}
	
	
}
