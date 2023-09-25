package com.fssa.parkinplace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fssa.parkinplace.exception.DAOException;
import com.fssa.parkinplace.model.BookingPlace;
import com.fssa.util.ConnectionUtil;

public class BookingPlaceDAO {

	public static boolean createBookingPlace(BookingPlace booking) throws DAOException {
		final String query = "INSERT INTO ParkingPlaceBooking (tenantName, tenantPhone, leaserId, tenantEmail, startingPeriod, endingPeriod, amount, status, tenantBikeImg) VALUES (?,?,?,?,?,?,?,?,?)";

		try (Connection connection = ConnectionUtil.getConnection()) {

			try (PreparedStatement ps = connection.prepareStatement(query)) {

				ps.setString(1, booking.getTenantName());
				ps.setString(2, booking.getTenantPhone());
				ps.setInt(3, booking.getLeaserId());
				ps.setString(4, booking.getTenantEmail());
				ps.setObject(5, booking.getStartingPeriod());
				ps.setObject(6, booking.getEndingPeriod());
				ps.setDouble(7, booking.getAmount());
				ps.setString(8, booking.getStatus());
				ps.setString(9, booking.getTenantBikeImg());

				int row = ps.executeUpdate();

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
						bookingPlace.setTenantName(rs.getString("tenantName"));
						bookingPlace.setTenantPhone(rs.getString("tenantPhone"));
						bookingPlace.setTenantBikeImg(rs.getString("tenantBikeImg"));
						bookingPlace.setLeaserId(rs.getInt("leaserId"));
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
						bookingPlace.setTenantName(rs.getString("tenantName"));
						bookingPlace.setTenantPhone(rs.getString("tenantPhone"));
						bookingPlace.setTenantBikeImg(rs.getString("tenantBikeImg"));
						bookingPlace.setLeaserId(rs.getInt("leaserId"));
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

	public static Set<BookingPlace> findAllBookingPlacesByTenantEmail(String tenantEmail)
			throws DAOException, SQLException {
		String query = "SELECT * FROM ParkingPlaceBooking WHERE tenantEmail = ?";
		Set<BookingPlace> bookingPlaceList = new HashSet<>();

		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, tenantEmail);

				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						BookingPlace bookingPlace = new BookingPlace();
						bookingPlace.setBookingId(rs.getInt("bookingId"));
						bookingPlace.setTenantName(rs.getString("tenantName"));
						bookingPlace.setTenantPhone(rs.getString("tenantPhone"));
						bookingPlace.setTenantBikeImg(rs.getString("tenantBikeImg"));
						bookingPlace.setLeaserId(rs.getInt("leaserId"));
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
						bookingPlace.setTenantName(rs.getString("tenantName"));
						bookingPlace.setTenantPhone(rs.getString("tenantPhone"));
						bookingPlace.setTenantBikeImg(rs.getString("tenantBikeImg"));
						bookingPlace.setLeaserId(rs.getInt("leaserId"));
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

	public static List<BookingPlace> findByLeaserIdAndStatus(int leaserId, String status)
			throws DAOException, SQLException {

		List<BookingPlace> bookingRequests = new ArrayList<>();
		String query = "SELECT * FROM ParkingPlaceBooking WHERE leaserId = ? AND status = ?";
		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement psmt = con.prepareStatement(query)) {
				psmt.setInt(1, leaserId);
				psmt.setString(2, status);

				try (ResultSet rs = psmt.executeQuery()) {

					while (rs.next()) {
						BookingPlace bookingDetails = new BookingPlace();

						bookingDetails.setTenantName(rs.getString("tenantName"));
						bookingDetails.setTenantPhone(rs.getString("tenantPhone"));
						bookingDetails.setTenantBikeImg(rs.getString("tenantBikeImg"));
						bookingDetails.setLeaserId(rs.getInt("leaserId"));
						bookingDetails.setTenantEmail(rs.getString("tenantEmail"));
						bookingDetails.setStartingPeriod(rs.getTimestamp("startingPeriod").toLocalDateTime());
						bookingDetails.setEndingPeriod(rs.getTimestamp("endingPeriod").toLocalDateTime());
						bookingDetails.setAmount(rs.getDouble("amount"));
						bookingDetails.setStatus(rs.getString("status"));

						bookingRequests.add(bookingDetails);
					}

					return bookingRequests;
				}
			}
		}

	}
	public static void main(String[] args) {
		try {
			System.out.println(updateStatusById(2,"Accepted","Waiting List"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean updateStatusById(int leaserId, String status, String updateStatus) throws SQLException {
		String query = "UPDATE ParkingPlaceBooking SET status=? WHERE leaserId=? AND status=?";

		try (Connection connection = ConnectionUtil.getConnection()) {

			try (PreparedStatement psmt = connection.prepareStatement(query)) {
				psmt.setString(3, status);
				psmt.setString(1, updateStatus);
				psmt.setInt(2, leaserId);

				int row = psmt.executeUpdate();
				return (row > 0);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}
		
	}

	public static boolean updateBooking(BookingPlace booking) throws SQLException {
		String query = "UPDATE ParkingPlaceBooking SET tenantName=?, tenantPhone=?, tenantBikeImg=?, leaserId=?, tenantEmail=?, startingPeriod=?, endingPeriod=?, amount=?, status=? WHERE bookingId=?";

		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement ps = connection.prepareStatement(query)) {
				ps.setString(1, booking.getTenantName());
				ps.setString(2, booking.getTenantPhone());
				ps.setString(3, booking.getTenantBikeImg());
				ps.setInt(4, booking.getLeaserId());
				ps.setString(5, booking.getTenantEmail());
				ps.setObject(6, booking.getStartingPeriod());
				ps.setObject(7, booking.getEndingPeriod());
				ps.setDouble(8, booking.getAmount());
				ps.setString(9, booking.getStatus());
				ps.setInt(10, booking.getBookingId());

				int row = ps.executeUpdate();
				return (row > 0);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
