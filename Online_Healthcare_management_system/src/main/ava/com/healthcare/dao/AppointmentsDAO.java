package com.healthcare.dao;

import com.healthcare.model.Appointments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentsDAO {
    private Connection connection;

    public AppointmentsDAO(Connection connection) {
        this.connection = connection;
    }

    public void addAppointment(Appointments appointment) throws SQLException {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, appointment.getPatientId());
            statement.setInt(2, appointment.getDoctorId());
            statement.setTimestamp(3, appointment.getAppointmentDate());
            statement.setString(4, appointment.getStatus());
            statement.executeUpdate();
        }
    }

    public void updateAppointment(Appointments appointment) throws SQLException {
        String sql = "UPDATE appointments SET patient_id = ?, doctor_id = ?, appointment_date = ?, status = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, appointment.getPatientId());
            statement.setInt(2, appointment.getDoctorId());
            statement.setTimestamp(3, appointment.getAppointmentDate());
            statement.setString(4, appointment.getStatus());
            statement.setInt(5, appointment.getId());
            statement.executeUpdate();
        }
    }

    public void deleteAppointment(int id) throws SQLException {
        String sql = "DELETE FROM appointments WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public Appointments getAppointmentById(int id) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Appointments(
                    resultSet.getInt("id"),
                    resultSet.getInt("patient_id"),
                    resultSet.getInt("doctor_id"),
                    resultSet.getTimestamp("appointment_date"),
                    resultSet.getString("status")
                );
            }
        }
        return null; // If no appointment found
    }

    public List<Appointments> getAllAppointments() throws SQLException {
        List<Appointments> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Appointments appointment = new Appointments(
                    resultSet.getInt("id"),
                    resultSet.getInt("patient_id"),
                    resultSet.getInt("doctor_id"),
                    resultSet.getTimestamp("appointment_date"),
                    resultSet.getString("status")
                );
                appointments.add(appointment);
            }
        }
        return appointments;
    }
}
