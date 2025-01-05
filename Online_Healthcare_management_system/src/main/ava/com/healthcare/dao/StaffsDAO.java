package com.healthcare.dao;

import com.healthcare.model.Staffs;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class StaffsDAO {
    private Connection connection;

    public StaffsDAO(Connection connection) {
        this.connection = connection;
    }

    public void addStaff(Staffs staff) throws SQLException {
        String sql = "INSERT INTO staffs (name, position, contact_number, email, hire_date, salary) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, staff.getName());
            statement.setString(2, staff.getPosition());
            statement.setString(3, staff.getContactNumber());
            statement.setString(4, staff.getEmail());
            statement.setDate(5, staff.getHireDate());
            statement.setBigDecimal(6, staff.getSalary());
            statement.executeUpdate();
        }
    }

    public void updateStaff(Staffs staff) throws SQLException {
        String sql = "UPDATE staffs SET name = ?, position = ?, contact_number = ?, email = ?, hire_date = ?, salary = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, staff.getName());
            statement.setString(2, staff.getPosition());
            statement.setString(3, staff.getContactNumber());
            statement.setString(4, staff.getEmail());
            statement.setDate(5, staff.getHireDate());
            statement.setBigDecimal(6, staff.getSalary());
            statement.setInt(7, staff.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Staff updated successfully!");
            } else {
                System.out.println("No staff found with the provided ID.");
            }
        }
    }
    
    public void deleteStaff(int id) throws SQLException {
        String sql = "DELETE FROM staffs WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public Staffs getStaffById(int id) throws SQLException {
        String sql = "SELECT * FROM staffs WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapRowToStaff(resultSet);
            }
        }
        return null;
    }

    public List<Staffs> getAllStaffs() throws SQLException {
        List<Staffs> staffs = new ArrayList<>();
        String sql = "SELECT * FROM staffs";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                staffs.add(mapRowToStaff(resultSet));
            }
        }
        return staffs;
    }

    private Staffs mapRowToStaff(ResultSet resultSet) throws SQLException {
        return new Staffs(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("position"),
            resultSet.getString("contact_number"),
            resultSet.getString("email"),
            resultSet.getDate("hire_date"),
            resultSet.getBigDecimal("salary")
        );
    }
}
