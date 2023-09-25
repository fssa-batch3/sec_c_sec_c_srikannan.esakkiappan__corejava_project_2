package com.fssa.parkinplace.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.parkinplace.exception.BookingException;
import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.exception.UserException;
import com.fssa.parkinplace.model.BookingPlace;
import com.fssa.parkinplace.service.BookingPlaceService;

class TestBookingPlaceService {
	
	public BookingPlace bookingPlaceDetails() {
		BookingPlace p = new BookingPlace();
		p.setBookingId(1);
		p.setTenantName("sri");
		p.setTenantPhone("9884616021");
		p.setTenantBikeImg("https://iili.io/HUN8VHX.jpg");
		p.setLeaserId(1);
		p.setTenantEmail("srik@gmail.com");
		p.setStartingPeriod(LocalDateTime.now());
		p.setEndingPeriod(LocalDateTime.now().plusDays(7));
		p.setAmount(100.0);
		p.setStatus("Waiting List");
		return p;
	} 
	  
	public BookingPlace updateBookingPlaceDetails() {
		BookingPlace p = new BookingPlace();
		p.setBookingId(1);
		p.setTenantName("sri");
		p.setTenantPhone("9884616021");
		p.setTenantBikeImg("https://iili.io/HUN8VHX.jpg");
		p.setLeaserId(1);
		p.setTenantEmail("sri@gmail.com");
		p.setStartingPeriod(LocalDateTime.now());
		p.setEndingPeriod(LocalDateTime.now().plusDays(7));
		p.setAmount(100.0);
		p.setStatus("Waiting List"); 
		return p; 
	} 
	
	@Test
	void testValidAddBooking() throws DAOException, BookingException, UserException {
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
	void testValidFindByLeaserIdAndStatus() throws DAOException, SQLException {
		List<BookingPlace> getLeaserMailStatus = BookingPlaceService.findByLeaserIdAndStatus(bookingPlaceDetails().getLeaserId(), bookingPlaceDetails().getStatus());
		Assertions.assertNotNull(getLeaserMailStatus);
	}
	 
	@Test
	void testValidUpdateBooking() throws DAOException, SQLException, BookingException, UserException {
		TestBookingPlaceService bookingPlaceService = new TestBookingPlaceService();
		Assertions.assertTrue(BookingPlaceService.updateBookingPlace(bookingPlaceService.updateBookingPlaceDetails()));
	}
	
	
}
