package com.fssa.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.fssa.logger.Logger;

/**
 * This class provides a static method for obtaining a database connection using
 * JDBC.
 */
public class ConnectionUtil {

	/**
	 * Returns a database connection using JDBC based on environment variables.
	 *
	 * @return A database connection using JDBC.
	 * @throws RuntimeException if unable to connect to the database.
	 */
	public static Connection getConnection() {
		Connection con = null;

		String url;
		String userName;
		String passWord;

		url = System.getenv("DATABASE_HOST1");
		userName = System.getenv("DATABASE_USERNAME1");
		passWord = System.getenv("DATABASE_PASSWORD1");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
			Logger.info("Connection created"); 
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database");
		}
		return con;
	}

	private ConnectionUtil() {
		super();
	}

	/**
	 * Main method to demonstrate obtaining a database connection.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		getConnection();
	}
}
