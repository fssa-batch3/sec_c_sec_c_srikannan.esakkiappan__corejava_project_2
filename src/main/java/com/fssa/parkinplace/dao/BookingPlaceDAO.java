//package com.fssa.parkinplace.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashSet;
//import java.util.Set;
//
//import com.fssa.parkinplace.exception.DAOException;
//import com.fssa.parkinplace.model.BookingPlace;
//import com.fssa.util.ConnectionUtil;
//import com.google.protobuf.ServiceException;
//
//public class BookingPlaceDAO {
//
//    public void create(BookingPlace newBookingPlace) throws DAOException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        try {
//            String query = "INSERT INTO ParkingPlaceBooking (leaser_email, starting_date, starting_time, ending_date, ending_time, amount, tenant_email, booking_status, duration_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            conn = ConnectionUtil.getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, newBookingPlace.getLeaserEmail());
//            ps.setDate(2, java.sql.Date.valueOf(newBookingPlace.getStartingDate()));
//            ps.setTime(3, java.sql.Time.valueOf(newBookingPlace.getStartingTime()));
//            ps.setDate(4, java.sql.Date.valueOf(newBookingPlace.getEndingDate()));
//            ps.setTime(5, java.sql.Time.valueOf(newBookingPlace.getEndingTime()));
//            ps.setDouble(6, newBookingPlace.getAmount());
//            ps.setString(7, newBookingPlace.getTenantEmail());
//            ps.setString(8, newBookingPlace.getBookingStatus());
//            ps.setString(9, newBookingPlace.getDurationTime());
//
//            ps.executeUpdate();
//            // Log success here
//
//        } catch (SQLException e) {
//            throw new DAOException("Error occurred while creating booking place", e);
//        } finally {
//            ConnectionUtil.close(conn, ps);
//        }
//    }
//
//    public Set<BookingPlace> findAll() throws DAOException, ServiceException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Set<BookingPlace> bookingPlaceList = new HashSet<>();
//        try {
//            String query = "SELECT * FROM ParkingPlaceBooking";
//            conn = ConnectionUtil.getConnection();
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                BookingPlace bookingPlace = new BookingPlace();
//                bookingPlace.setId(rs.getInt(0));
//                bookingPlace.setLeaserEmail(rs.getString("leaser_email"));
//                bookingPlace.setStartingDate(rs.getDate("starting_date").toLocalDate());
//                bookingPlace.setStartingTime(rs.getTime("starting_time").toLocalTime());
//                bookingPlace.setEndingDate(rs.getDate("ending_date").toLocalDate());
//                bookingPlace.setEndingTime(rs.getTime("ending_time").toLocalTime());
//                bookingPlace.setAmount(rs.getDouble("amount"));
//                bookingPlace.setTenantEmail(rs.getString("tenant_email"));
//                bookingPlace.setBookingStatus(rs.getString("booking_status"));
//                bookingPlace.setDurationTime(rs.getString("duration_time"));
//
//                bookingPlaceList.add(bookingPlace);
//            }
//        } catch (SQLException e) {
//            throw new DAOException("Error occurred while retrieving all booking places", e);
//        } finally {
//            ConnectionUtil.close(conn, ps, rs);
//        }
//        return bookingPlaceList;
//    }
//
//    public Set<BookingPlace> findAllBookingPlacesByStatus(String status) throws DAOException, ServiceException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Set<BookingPlace> bookingPlaceList = new HashSet<>();
//        try {
//            String query = "SELECT * FROM ParkingPlaceBooking WHERE booking_status = ?";
//            conn = ConnectionUtil.getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, status);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                BookingPlace bookingPlace = new BookingPlace();
//                bookingPlace.setBookingId(rs.getInt("booking_id"));
//                bookingPlace.setLeaserEmail(rs.getString("leaser_email"));
//                bookingPlace.setStartingDate(rs.getDate("starting_date").toLocalDate());
//                bookingPlace.setStartingTime(rs.getTime("starting_time").toLocalTime());
//                bookingPlace.setEndingDate(rs.getDate("ending_date").toLocalDate());
//                bookingPlace.setEndingTime(rs.getTime("ending_time").toLocalTime());
//                bookingPlace.setAmount(rs.getDouble("amount"));
//                bookingPlace.setTenantEmail(rs.getString("tenant_email"));
//                bookingPlace.setBookingStatus(rs.getString("booking_status"));
//                bookingPlace.setDurationTime(rs.getString("duration_time"));
//
//                bookingPlaceList.add(bookingPlace);
//            }
//        } catch (SQLException e) {
//            throw new DAOException("Error occurred while retrieving booking places by status", e);
//        } finally {
//            ConnectionUtil.close(conn, ps, rs);
//        }
//        return bookingPlaceList;
//    }
//
//    public Set<BookingPlace> findAllBookingPlacesByLeaserEmail(String leaserEmail) throws DAOException, ServiceException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Set<BookingPlace> bookingPlaceList = new HashSet<>();
//        try {
//            String query = "SELECT * FROM ParkingPlaceBooking WHERE leaser_email = ?";
//            conn = ConnectionUtil.getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, leaserEmail);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                BookingPlace bookingPlace = new BookingPlace();
//                bookingPlace.setBookingId(rs.getInt("booking_id"));
//                bookingPlace.setLeaserEmail(rs.getString("leaser_email"));
//                bookingPlace.setStartingDate(rs.getDate("starting_date").toLocalDate());
//                bookingPlace.setStartingTime(rs.getTime("starting_time").toLocalTime());
//                bookingPlace.setEndingDate(rs.getDate("ending_date").toLocalDate());
//                bookingPlace.setEndingTime(rs.getTime("ending_time").toLocalTime());
//                bookingPlace.setAmount(rs.getDouble("amount"));
//                bookingPlace.setTenantEmail(rs.getString("tenant_email"));
//                bookingPlace.setBookingStatus(rs.getString("booking_status"));
//                bookingPlace.setDurationTime(rs.getString("duration_time"));
//
//                bookingPlaceList.add(bookingPlace);
//            }
//        } catch (SQLException e) {
//            throw new DAOException("Error occurred while retrieving booking places by leaser email", e);
//        } finally {
//            ConnectionUtil.close(conn, ps, rs);
//        }
//        return bookingPlaceList;
//    }
//
//    public Set<BookingPlace> findAllBookingPlacesByTenantEmail(String tenantEmail) throws DAOException, ServiceException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Set<BookingPlace> bookingPlaceList = new HashSet<>();
//        try {
//            String query = "SELECT * FROM ParkingPlaceBooking WHERE tenant_email = ?";
//            conn = ConnectionUtil.getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, tenantEmail);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                BookingPlace bookingPlace = new BookingPlace();
//                bookingPlace.setBookingId(rs.getInt("booking_id"));
//                bookingPlace.setLeaserEmail(rs.getString("leaser_email"));
//                bookingPlace.setStartingDate(rs.getDate("starting_date").toLocalDate());
//                bookingPlace.setStartingTime(rs.getTime("starting_time").toLocalTime());
//                bookingPlace.setEndingDate(rs.getDate("ending_date").toLocalDate());
//                bookingPlace.setEndingTime(rs.getTime("ending_time").toLocalTime());
//                bookingPlace.setAmount(rs.getDouble("amount"));
//                bookingPlace.setTenantEmail(rs.getString("tenant_email"));
//                bookingPlace.setBookingStatus(rs.getString("booking_status"));
//                bookingPlace.setDurationTime(rs.getString("duration_time"));
//
//                bookingPlaceList.add(bookingPlace);
//            }
//        } catch (SQLException e) {
//            throw new DAOException("Error occurred while retrieving booking places by tenant email", e);
//        } finally {
//            ConnectionUtil.close(conn, ps, rs);
//        }
//        return bookingPlaceList;
//    }
//
//    public BookingPlace findById(int bookingPlaceId) throws DAOException, ServiceException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        BookingPlace bookingPlace = null;
//        try {
//            String query = "SELECT * FROM ParkingPlaceBooking WHERE booking_id = ?";
//            conn = ConnectionUtil.getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setInt(1, bookingPlaceId);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                bookingPlace = new BookingPlace();
//                bookingPlace.setBookingId(rs.getInt("booking_id"));
//                bookingPlace.setLeaserEmail(rs.getString("leaser_email"));
//                bookingPlace.setStartingDate(rs.getDate("starting_date").toLocalDate());
//                bookingPlace.setStartingTime(rs.getTime("starting_time").toLocalTime());
//                bookingPlace.setEndingDate(rs.getDate("ending_date").toLocalDate());
//                bookingPlace.setEndingTime(rs.getTime("ending_time").toLocalTime());
//                bookingPlace.setAmount(rs.getDouble("amount"));
//                bookingPlace.setTenantEmail(rs.getString("tenant_email"));
//                bookingPlace.setBookingStatus(rs.getString("booking_status"));
//                bookingPlace.setDurationTime(rs.getString("duration_time"));
//            }
//        } catch (SQLException e) {
//            throw new DAOException("Error occurred while retrieving booking place by booking place id", e);
//        } finally {
//            ConnectionUtil.close(conn, ps, rs);
//        }
//        return bookingPlace;
//    }
//
//    public void updateStatus(int bookingPlaceId, String status) throws DAOException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        try {
//            String query = "UPDATE ParkingPlaceBooking SET booking_status = ? WHERE booking_id = ?";
//            conn = ConnectionUtil.getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, status);
//            ps.setInt(2, bookingPlaceId);
//            ps.executeUpdate();
//            // Log success here
//        } catch (SQLException e) {
//            throw new DAOException("Error occurred while updating booking place status", e);
//        } finally {
//            ConnectionUtil.close(conn, ps);
//        }
//    }
//}
//
