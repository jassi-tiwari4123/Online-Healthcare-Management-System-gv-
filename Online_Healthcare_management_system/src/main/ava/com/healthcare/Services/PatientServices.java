package com.healthcare.Services;

import com.healthcare.dao.PatientsDAO;
import com.healthcare.model.Patients;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PatientServices {
    private PatientsDAO patientsDAO;

    // Constructor to initialize the DAO with a connection
    public PatientServices(Connection connection) {
        this.patientsDAO = new PatientsDAO(connection);
    }

    // Add a new patient
    public void addPatient(String name, java.util.Date dateOfBirth, String gender, String contactNumber,
                           String address, String emergencyContactNumber, String medicalHistory) throws SQLException {
        Patients patient = new Patients(0, name, new java.sql.Date(dateOfBirth.getTime()), gender, contactNumber,
                                        address, emergencyContactNumber, medicalHistory); // id is 0 for new patients
        patientsDAO.addPatient(patient);
    }

    // Update an existing patient's information
    public void updatePatient(int id, String name, java.util.Date dateOfBirth, String gender, String contactNumber,
                              String address, String emergencyContactNumber, String medicalHistory) throws SQLException {
        Patients patient = new Patients(id, name, new java.sql.Date(dateOfBirth.getTime()), gender, contactNumber,
                                        address, emergencyContactNumber, medicalHistory);
        patientsDAO.updatePatient(patient);
    }

    // Delete a patient by ID
    public void deletePatient(int id) throws SQLException {
        patientsDAO.deletePatient(id);
    }

    // Get a patient by ID
    public Patients getPatientById(int id) throws SQLException {
        return patientsDAO.getPatientById(id);
    }

    // Get all patients
    public List<Patients> getAllPatients() throws SQLException {
        return patientsDAO.getAllPatients();
    }

    // Check if a patient exists by ID
    public boolean patientExists(int id) throws SQLException {
        return patientsDAO.exists(id);
    }
}
