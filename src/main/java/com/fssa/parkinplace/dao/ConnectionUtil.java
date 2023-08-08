package com.fssa.parkinplace.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * This class provides a static method for obtaining a database connection using JDBC.
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

        String url, userName, passWord;

        if (System.getenv("CI") != null) {
            url = System.getenv("DATABASE_HOST");
            userName = System.getenv("DATABASE_USERNAME");
            passWord = System.getenv("DATABASE_PASSWORD");
        } else {
            Dotenv env = Dotenv.load();
            url = env.get("DATABASE_HOST");
            userName = env.get("DATABASE_USERNAME");
            passWord = env.get("DATABASE_PASSWORD");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, passWord);
            System.out.println("Connection created");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database");
        }
        return con;
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
