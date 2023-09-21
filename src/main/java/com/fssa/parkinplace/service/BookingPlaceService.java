package com.fssa.parkinplace.service;

import java.sql.SQLException;
import java.util.Set;

import com.fssa.logger.Logger;
import com.fssa.parkinplace.dao.BookingPlaceDAO;
import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.model.BookingPlace;
import com.fssa.parkinplace.validation.BookingPlaceValidator;

public class BookingPlaceService {

    public static boolean createBookingPlace(BookingPlace newBookingPlace) throws DAOException {
    	if (BookingPlaceValidator.validate(newBookingPlace)) { 
		
			BookingPlaceDAO.createBookingPlace(newBookingPlace);
			Logger.info("Booking Added Successfully");
		}
		
		return true;
    }
 
    public static Set<BookingPlace> getAllBookingPlaces() throws DAOException, SQLException {
        return BookingPlaceDAO.findAll();
    }
 
    public static Set<BookingPlace> getAllBookingPlacesByStatus(String status)
            throws DAOException, SQLException{
    	return BookingPlaceDAO.findAllBookingPlacesByStatus(status);
    }
     
    public static Set<BookingPlace> getAllBookingPlacesByLeaserEmail(String leaserEmail)
            throws DAOException, SQLException {
        return BookingPlaceDAO.findAllBookingPlacesByLeaserEmail(leaserEmail);
    }

    public static Set<BookingPlace> getAllBookingPlacesByTenantEmail(String tenantEmail)
            throws DAOException, SQLException {
        return BookingPlaceDAO.findAllBookingPlacesByTenantEmail(tenantEmail);
    }

    public static BookingPlace findByBookingPlaceId(int bookingPlaceId) throws DAOException, SQLException {
        return BookingPlaceDAO.findById(bookingPlaceId);
    }

    public static boolean updateBookingPlace(BookingPlace newBookingPlace)
            throws SQLException {
    	if (BookingPlaceValidator.validate(newBookingPlace)) { 
    		
			BookingPlaceDAO.updateBooking(newBookingPlace);
			Logger.info("Booking Added Successfully");
		}
		
		return true;
    }
}

