package com.healthcare.Services;

import com.healthcare.dao.DoctorsDAO;
import com.healthcare.model.Doctors;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DoctorServices {
    private DoctorsDAO doctorsDAO;

    // Constructor to initialize the DAO with a connection
    public DoctorServices(Connection connection) {
        this.doctorsDAO = new DoctorsDAO(connection);
    }

    // Add a new doctor
    public void addDoctor(String name, String specialty, String contactNumber, String email, int yearsOfExperience) throws SQLException {
        Doctors doctor = new Doctors(0, name, specialty, contactNumber, email, yearsOfExperience); // id is 0 for new doctors
        doctorsDAO.addDoctor(doctor);
    }

    // Update an existing doctor's information
    public void updateDoctor(int id, String name, String specialty, String contactNumber, String email, int yearsOfExperience) throws SQLException {
        Doctors doctor = new Doctors(id, name, specialty, contactNumber, email, yearsOfExperience);
        doctorsDAO.updateDoctor(doctor);
    }

    // Delete a doctor by ID
    public void deleteDoctor(int id) throws SQLException {
        doctorsDAO.deleteDoctor(id);
    }

    // Get a doctor by ID
    public Doctors getDoctorById(int id) throws SQLException {
        return doctorsDAO.getDoctorById(id);
    }

    // Get all doctors
    public List<Doctors> getAllDoctors() throws SQLException {
        return doctorsDAO.getAllDoctors();
    }

    // Check if a doctor exists by ID
    public boolean doctorExists(int id) throws SQLException {
        return doctorsDAO.exists(id);
    }
}
