package com.healthcare.dao;
import com.healthcare.model.Doctors;
//here all CRUD operations will be performed for doctors


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorsDAO {
    private Connection connection;

    public DoctorsDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a new doctor
    public void addDoctor(Doctors doctor) throws SQLException {
        String sql = "INSERT INTO doctors (name, specialty, contact_number, email, years_of_experience) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialty());
            statement.setString(3, doctor.getContactNumber());
            statement.setString(4, doctor.getEmail());
            statement.setInt(5, doctor.getYearsOfExperience());
            statement.executeUpdate();
        }
    }

    // Update a doctor's information
    public void updateDoctor(Doctors doctor) throws SQLException {
        String sql = "UPDATE doctors SET name = ?, specialty = ?, contact_number = ?, email = ?, years_of_experience = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialty());
            statement.setString(3, doctor.getContactNumber());
            statement.setString(4, doctor.getEmail());
            statement.setInt(5, doctor.getYearsOfExperience());
            statement.setInt(6, doctor.getId());
            statement.executeUpdate();
        }
    }

    // Delete a doctor by ID
    public void deleteDoctor(int id) throws SQLException {
        String sql = "DELETE FROM doctors WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // Get a doctor by ID
    public Doctors getDoctorById(int id) throws SQLException {
        String sql = "SELECT * FROM doctors WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Doctors(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("specialty"),
                    resultSet.getString("contact_number"),
                    resultSet.getString("email"),
                    resultSet.getInt("years_of_experience")
                );
            }
        }
        return null;
    }

    // List all doctors
    public List<Doctors> getAllDoctors() throws SQLException {
        List<Doctors> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                doctors.add(new Doctors(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("specialty"),
                    resultSet.getString("contact_number"),
                    resultSet.getString("email"),
                    resultSet.getInt("years_of_experience")
                ));
            }
        }
        return doctors;
    }
    public boolean exists(int id) throws SQLException {
        String query = "SELECT COUNT(*) FROM doctors WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        }
        return false;
    }

}
