package com.healthcare.Services;

import com.healthcare.dao.StaffsDAO;
import com.healthcare.model.Staffs;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StaffServices {
    private StaffsDAO StaffsDAO;

    // Constructor to initialize the DAO with a connection
    public StaffServices(Connection connection) {
        this.StaffsDAO = new StaffsDAO(connection);
    }

    // Add a new staff member
    public void addStaff(String name, String position, String contactNumber, String email, java.util.Date hireDate, BigDecimal salary) throws SQLException {
        Staffs staff = new Staffs(0, name, position, contactNumber, email, new java.sql.Date(hireDate.getTime()), salary); // id is 0 for new staff members
        StaffsDAO.addStaff(staff);
    }

    // Update an existing staff member's information
    public void updateStaff(int id, String name, String position, String contactNumber, String email, java.util.Date hireDate, BigDecimal salary) throws SQLException {
        Staffs staff = new Staffs(id, name, position, contactNumber, email, new java.sql.Date(hireDate.getTime()), salary);
        StaffsDAO.updateStaff(staff);
    }

    // Delete a staff member by ID
    public void deleteStaff(int id) throws SQLException {
        StaffsDAO.deleteStaff(id);
    }

    // Get a staff member by ID
    public Staffs getStaffById(int id) throws SQLException {
        return StaffsDAO.getStaffById(id);
    }

    // Get all staff members
    public List<Staffs> getAllStaffs() throws SQLException {
        return StaffsDAO.getAllStaffs();
    }
}
