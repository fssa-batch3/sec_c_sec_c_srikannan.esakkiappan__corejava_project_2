package com.fssa.parkinplace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.model.BookingPlace;
import com.fssa.util.ConnectionUtil;

public class BookingPlaceDAO {

    public static boolean createBookingPlace(BookingPlace booking) throws DAOException {
        String query = "INSERT INTO ParkingPlaceBooking (leaserEmail, tenantEmail, startingPeriod, endingPeriod, amount, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionUtil.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, booking.getLeaserEmail());
                ps.setString(2, booking.getTenantEmail());
                ps.setObject(3, booking.getStartingPeriod());
                ps.setObject(4, booking.getEndingPeriod());
                ps.setDouble(5, booking.getAmount());
                ps.setString(6, booking.getStatus());

                int row = ps.executeUpdate();

                if (row > 0) {
                    ResultSet generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        booking.setBookingId(generatedKeys.getInt(1));
                    }
                }

                return (row > 0);
            }

        } catch (SQLException e) {
            throw new DAOException("Error occurred while creating booking place", e);
        }
    }

    public static Set<BookingPlace> findAll() throws DAOException, SQLException {
        String query = "SELECT * FROM ParkingPlaceBooking";
        Set<BookingPlace> bookingPlaceList = new HashSet<>();
        
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (Statement pst = connection.createStatement()) {
                try (ResultSet rs = pst.executeQuery(query)) {
                    while (rs.next()) {
                        BookingPlace bookingPlace = new BookingPlace();
                        bookingPlace.setBookingId(rs.getInt("bookingId"));
                        bookingPlace.setLeaserEmail(rs.getString("leaserEmail"));
                        bookingPlace.setTenantEmail(rs.getString("tenantEmail"));
                        bookingPlace.setStartingPeriod(rs.getTimestamp("startingPeriod").toLocalDateTime());
                        bookingPlace.setEndingPeriod(rs.getTimestamp("endingPeriod").toLocalDateTime());
                        bookingPlace.setAmount(rs.getDouble("amount"));
                        bookingPlace.setStatus(rs.getString("status"));
                        
                        bookingPlaceList.add(bookingPlace);
                    }
                    return bookingPlaceList;
                }
            } catch (SQLException e) {
                throw new DAOException("Error occurred while retrieving all booking places", e);
            }
        }
    }

    public static Set<BookingPlace> findAllBookingPlacesByStatus(String status) throws DAOException, SQLException {
        String query = "SELECT * FROM ParkingPlaceBooking WHERE status = ?";
        Set<BookingPlace> bookingPlaceList = new HashSet<>();
        
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, status);
                
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        BookingPlace bookingPlace = new BookingPlace();
                        bookingPlace.setBookingId(rs.getInt("bookingId"));
                        bookingPlace.setLeaserEmail(rs.getString("leaserEmail"));
                        bookingPlace.setTenantEmail(rs.getString("tenantEmail"));
                        bookingPlace.setStartingPeriod(rs.getTimestamp("startingPeriod").toLocalDateTime());
                        bookingPlace.setEndingPeriod(rs.getTimestamp("endingPeriod").toLocalDateTime());
                        bookingPlace.setAmount(rs.getDouble("amount"));
                        bookingPlace.setStatus(rs.getString("status"));
                        
                        bookingPlaceList.add(bookingPlace);
                    }
                    return bookingPlaceList;
                }
            } catch (SQLException e) {
                throw new DAOException("Error occurred while retrieving booking places by status", e);
            }
        }
    }

    public static Set<BookingPlace> findAllBookingPlacesByLeaserEmail(String leaserEmail) throws DAOException, SQLException {
        String query = "SELECT * FROM ParkingPlaceBooking WHERE leaserEmail = ?";
        Set<BookingPlace> bookingPlaceList = new HashSet<>();
        
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, leaserEmail);
                
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        BookingPlace bookingPlace = new BookingPlace();
                        bookingPlace.setBookingId(rs.getInt("bookingId"));
                        bookingPlace.setLeaserEmail(rs.getString("leaserEmail"));
                        bookingPlace.setTenantEmail(rs.getString("tenantEmail"));
                        bookingPlace.setStartingPeriod(rs.getTimestamp("startingPeriod").toLocalDateTime());
                        bookingPlace.setEndingPeriod(rs.getTimestamp("endingPeriod").toLocalDateTime());
                        bookingPlace.setAmount(rs.getDouble("amount"));
                        bookingPlace.setStatus(rs.getString("status"));
                        
                        bookingPlaceList.add(bookingPlace);
                    }
                    return bookingPlaceList;
                }
            } catch (SQLException e) {
                throw new DAOException("Error occurred while retrieving booking places by leaser email", e);
            }
        }
    }

    public static Set<BookingPlace> findAllBookingPlacesByTenantEmail(String tenantEmail) throws DAOException, SQLException {
        String query = "SELECT * FROM ParkingPlaceBooking WHERE tenantEmail = ?";
        Set<BookingPlace> bookingPlaceList = new HashSet<>();
        
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, tenantEmail);
                
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        BookingPlace bookingPlace = new BookingPlace();
                        bookingPlace.setBookingId(rs.getInt("bookingId"));
                        bookingPlace.setLeaserEmail(rs.getString("leaserEmail"));
                        bookingPlace.setTenantEmail(rs.getString("tenantEmail"));
                        bookingPlace.setStartingPeriod(rs.getTimestamp("startingPeriod").toLocalDateTime());
                        bookingPlace.setEndingPeriod(rs.getTimestamp("endingPeriod").toLocalDateTime());
                        bookingPlace.setAmount(rs.getDouble("amount"));
                        bookingPlace.setStatus(rs.getString("status"));
                        
                        bookingPlaceList.add(bookingPlace);
                    }
                    return bookingPlaceList;
                }
            } catch (SQLException e) {
                throw new DAOException("Error occurred while retrieving booking places by tenant email", e);
            }
        }
    }

    public static BookingPlace findById(int bookingPlaceId) throws DAOException, SQLException {
        String query = "SELECT * FROM ParkingPlaceBooking WHERE bookingId = ?";
        
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement psmt = connection.prepareStatement(query)) {
                psmt.setInt(1, bookingPlaceId);
                
                try (ResultSet rs = psmt.executeQuery()) {
                    if (rs.next()) {
                        BookingPlace bookingPlace = new BookingPlace();
                        bookingPlace.setBookingId(rs.getInt("bookingId"));
                        bookingPlace.setLeaserEmail(rs.getString("leaserEmail"));
                        bookingPlace.setTenantEmail(rs.getString("tenantEmail"));
                        bookingPlace.setStartingPeriod(rs.getTimestamp("startingPeriod").toLocalDateTime());
                        bookingPlace.setEndingPeriod(rs.getTimestamp("endingPeriod").toLocalDateTime());
                        bookingPlace.setAmount(rs.getDouble("amount"));
                        bookingPlace.setStatus(rs.getString("status"));
                        
                        return bookingPlace;
                    }
                } catch (SQLException e) {
                    throw new DAOException("Error occurred while retrieving booking place by booking place id", e);
                }
            }
        }
        
        return null;
    }

    public static boolean updateBooking(BookingPlace booking) throws SQLException {
        String query = "UPDATE ParkingPlaceBooking SET leaserEmail=?, tenantEmail=?, startingPeriod=?, endingPeriod=?, amount=?, status=? WHERE bookingId=?";
        
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, booking.getLeaserEmail());
                ps.setString(2, booking.getTenantEmail());
                ps.setObject(3, booking.getStartingPeriod());
                ps.setObject(4, booking.getEndingPeriod());
                ps.setDouble(5, booking.getAmount());
                ps.setString(6, booking.getStatus());
                ps.setInt(7, booking.getBookingId());
                
                int row = ps.executeUpdate();
                return (row > 0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}

