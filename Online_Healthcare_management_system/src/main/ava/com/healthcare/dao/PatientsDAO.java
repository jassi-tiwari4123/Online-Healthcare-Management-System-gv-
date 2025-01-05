
package com.healthcare.dao;
import com.healthcare.model.Patients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientsDAO {
    private Connection connection;

    
    public PatientsDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a new patient
    public void addPatient(Patients patient) throws SQLException {
        String sql = "INSERT INTO patients (name, date_of_birth, gender, contact_number, address, emergency_contact_number, medical_history) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, patient.getName());
            statement.setDate(2, new java.sql.Date(patient.getDateOfBirth().getTime()));
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getContactNumber());
            statement.setString(5, patient.getAddress());
            statement.setString(6, patient.getEmergencyContactNumber());
            statement.setString(7, patient.getMedicalHistory());
            statement.executeUpdate();
        }
    }

    // Update a patient's information
    public void updatePatient(Patients patient) throws SQLException {
        String sql = "UPDATE patients SET name = ?, date_of_birth = ?, gender = ?, contact_number = ?, address = ?, emergency_contact_number = ?, medical_history = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, patient.getName());
            statement.setDate(2, new java.sql.Date(patient.getDateOfBirth().getTime()));
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getContactNumber());
            statement.setString(5, patient.getAddress());
            statement.setString(6, patient.getEmergencyContactNumber());
            statement.setString(7, patient.getMedicalHistory());
            statement.setInt(8, patient.getId());
            statement.executeUpdate();
        }
    }

    // Delete a patient by ID
    public void deletePatient(int id) throws SQLException {
        String sql = "DELETE FROM patients WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // Get a patient by ID
    public Patients getPatientById(int id) throws SQLException {
        String sql = "SELECT * FROM patients WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Patients(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("date_of_birth"),
                    resultSet.getString("gender"),
                    resultSet.getString("contact_number"),
                    resultSet.getString("address"),
                    resultSet.getString("emergency_contact_number"),
                    resultSet.getString("medical_history")
                );
            }
        }
        return null;
    }

    // List all patients
    public List<Patients> getAllPatients() throws SQLException {
        List<Patients> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                patients.add(new Patients(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("date_of_birth"),
                    resultSet.getString("gender"),
                    resultSet.getString("contact_number"),
                    resultSet.getString("address"),
                    resultSet.getString("emergency_contact_number"),
                    resultSet.getString("medical_history")
                ));
            }
        }
        return patients;
    }
    public boolean exists(int id) throws SQLException {
        String query = "SELECT COUNT(*) FROM patients WHERE id = ?";
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
