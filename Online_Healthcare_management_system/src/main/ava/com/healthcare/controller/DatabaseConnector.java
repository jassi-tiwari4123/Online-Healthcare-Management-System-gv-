package com.healthcare.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/healthcare_db"; // Update with your DB details
    private static final String USER = "root";  // Update with your DB username
    private static final String PASSWORD = "Jassi@4123";  // Update with your DB password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
