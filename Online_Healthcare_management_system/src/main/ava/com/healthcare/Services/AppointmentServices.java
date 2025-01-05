package com.healthcare.Services;

import com.healthcare.dao.AppointmentsDAO;
import com.healthcare.model.Appointments;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class AppointmentServices {
    private AppointmentsDAO appointmentsDAO;

    public AppointmentServices(Connection connection) {
        this.appointmentsDAO = new AppointmentsDAO(connection);
    }

    // Add a new appointment
    public void addAppointment(int patientId, int doctorId, Timestamp appointmentDate, String status) throws SQLException {
        Appointments appointment = new Appointments(0, patientId, doctorId, appointmentDate, status);
        appointmentsDAO.addAppointment(appointment);
    }

    // Update an existing appointment
    public void updateAppointment(int id, int patientId, int doctorId, Timestamp appointmentDate, String status) throws SQLException {
        Appointments appointment = new Appointments(id, patientId, doctorId, appointmentDate, status);
        appointmentsDAO.updateAppointment(appointment);
    }

    // Delete an appointment
    public void deleteAppointment(int id) throws SQLException {
        appointmentsDAO.deleteAppointment(id);
    }

    // Get an appointment by ID
    public Appointments getAppointmentById(int id) throws SQLException {
        return appointmentsDAO.getAppointmentById(id);
    }

    // Get all appointments
    public List<Appointments> getAllAppointments() throws SQLException {
        return appointmentsDAO.getAllAppointments();
    }

    // Get appointments by status
    public List<Appointments> getAppointmentsByStatus(String status) throws SQLException {
        List<Appointments> allAppointments = appointmentsDAO.getAllAppointments();
        allAppointments.removeIf(appointment -> !appointment.getStatus().equalsIgnoreCase(status));
        return allAppointments;
    }
}
