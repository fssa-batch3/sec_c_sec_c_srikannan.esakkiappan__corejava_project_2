//package com.fssa.parkinplace.service;
//
//import java.util.Set;
//
//import com.fssa.parkinplace.model.BookingPlace;
//import com.fssa.parkinplace.validation.BookingPlaceValidator;
//import com.google.protobuf.ServiceException;
//
//public class BookingPlaceService {
//
//    public void createBookingPlace(BookingPlace newBookingPlace) throws ValidationException, ServiceException {
//        try {
//            BookingPlaceValidator.validate(newBookingPlace);
//            BookingPlaceDAO bookingPlaceDAO = new BookingPlaceDAO();
//            bookingPlaceDAO.create(newBookingPlace);
//        } catch (PersistenceException e) {
//            throw new ServiceException("Error occurred while creating booking place", e);
//        }
//    }
//
//    public Set<BookingPlace> getAllBookingPlaces() throws ServiceException, ValidationException {
//        try {
//            BookingPlaceDAO bookingPlaceDAO = new BookingPlaceDAO();
//            Set<BookingPlace> bookingPlaceList = bookingPlaceDAO.findAll();
//            return bookingPlaceList;
//        } catch (PersistenceException e) {
//            throw new ServiceException("Error occurred while retrieving all booking places", e);
//        }
//    }
//
//    public Set<BookingPlace> getAllBookingPlacesByStatus(String status)
//            throws ValidationException, ServiceException {
//        try {
//            BookingPlaceValidator.validateStatus(status);
//            BookingPlaceDAO bookingPlaceDAO = new BookingPlaceDAO();
//            Set<BookingPlace> bookingPlaceList = bookingPlaceDAO.findAllBookingPlacesByStatus(status);
//            return bookingPlaceList;
//        } catch (PersistenceException e) {
//            throw new ServiceException("Error occurred while retrieving booking places by status", e);
//        }
//    }
//
//    public Set<BookingPlace> getAllBookingPlacesByLeaserEmail(String leaserEmail)
//            throws ValidationException, ServiceException {
//        try {
//            BookingPlaceValidator.validateEmail(leaserEmail);
//            BookingPlaceDAO bookingPlaceDAO = new BookingPlaceDAO();
//            Set<BookingPlace> bookingPlaceList = bookingPlaceDAO.findAllBookingPlacesByLeaserEmail(leaserEmail);
//            return bookingPlaceList;
//        } catch (PersistenceException e) {
//            throw a ServiceException("Error occurred while retrieving booking places by leaser email", e);
//        }
//    }
//
//    public Set<BookingPlace> getAllBookingPlacesByTenantEmail(String tenantEmail)
//            throws ValidationException, ServiceException {
//        try {
//            BookingPlaceValidator.validateEmail(tenantEmail);
//            BookingPlaceDAO bookingPlaceDAO = new BookingPlaceDAO();
//            Set<BookingPlace> bookingPlaceList = bookingPlaceDAO.findAllBookingPlacesByTenantEmail(tenantEmail);
//            return bookingPlaceList;
//        } catch (PersistenceException e) {
//            throw new ServiceException("Error occurred while retrieving booking places by tenant email", e);
//        }
//    }
//
//    public BookingPlace findByBookingPlaceId(int bookingPlaceId) throws ValidationException, ServiceException {
//        try {
//            BookingPlaceValidator.validateIdExists(bookingPlaceId);
//            BookingPlaceDAO bookingPlaceDAO = new BookingPlaceDAO();
//            return bookingPlaceDAO.findById(bookingPlaceId);
//        } catch (PersistenceException e) {
//            throw new ServiceException("Error occurred while retrieving booking place by booking place id", e);
//        }
//    }
//
//    public void updateBookingPlaceStatus(int bookingPlaceId, String status)
//            throws ValidationException, ServiceException {
//        try {
//            BookingPlaceValidator.validateIdExists(bookingPlaceId);
//            BookingPlaceValidator.validateUpdateStatus(status);
//            BookingPlaceDAO bookingPlaceDAO = new BookingPlaceDAO();
//            bookingPlaceDAO.updateStatus(bookingPlaceId, status);
//        } catch (PersistenceException e) {
//            throw new ServiceException("Error occurred while updating booking place status", e);
//        }
//    }
//}
//
