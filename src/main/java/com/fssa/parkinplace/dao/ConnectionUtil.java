// Class to provide a static method for obtaining a database connection
package com.fssa.parkinplace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	// Method to get a database connection using JDBC
	public static Connection getConnection() {
		// Declare a Connection variable to hold the database connection
		Connection con = null;
		
		// Define the URL to connect to the database (here, MySQL is used with the database name "parkin_java")
		String url = "jdbc:mysql://localhost:3306/parkin_java";
		
		// Define the database username
		String userName = "root";
		
		// Define the database password
		String passWord = "123456";

		try {
			// Attempt to establish the database connection using the DriverManager class
			con = DriverManager.getConnection(url, userName, passWord);
			
			// Print a success message if the connection is established successfully
			System.out.println("Connection successful");
		} catch (SQLException e) {
			// Print the stack trace if any SQLException occurs during the connection attempt
			e.printStackTrace();
			
			// Throw a RuntimeException with an error message if the connection fails
			throw new RuntimeException("Unable to connect to the database");
		}
		// Return the established connection or null if the connection was not successful
		return con; 
	}
}
