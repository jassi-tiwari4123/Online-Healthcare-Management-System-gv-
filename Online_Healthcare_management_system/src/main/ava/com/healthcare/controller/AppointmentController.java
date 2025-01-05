package com.healthcare.controller;

import com.healthcare.dao.AppointmentsDAO;
import com.healthcare.model.Appointments;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet("/appointments")
public class AppointmentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AppointmentsDAO appointmentsDAO;

    public AppointmentController() {
        super();
    }

    @Override
    public void init() throws ServletException {
        // Initialize the DAO and database connection here
        try {
			appointmentsDAO = new AppointmentsDAO(DatabaseConnector.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Add a new appointment
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addAppointment(request, response);
        } else if ("update".equals(action)) {
            updateAppointment(request, response);
        }
    }

    private void addAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int patientId = Integer.parseInt(request.getParameter("patient_id"));
            int doctorId = Integer.parseInt(request.getParameter("doctor_id"));
            String status = request.getParameter("status");
            
            String appointmentDateStr = request.getParameter("appointment_date");
            if (appointmentDateStr != null && !appointmentDateStr.isEmpty()) {
                // Convert 'T' to space for compatibility with Timestamp.valueOf()
                appointmentDateStr = appointmentDateStr.replace("T", " ");
                
                try {
                    Timestamp appointmentDate = Timestamp.valueOf(appointmentDateStr);
                    Appointments appointment = new Appointments(0, patientId, doctorId, appointmentDate, status);
                    appointmentsDAO.addAppointment(appointment);
                    response.sendRedirect("appointments.jsp");  // Redirect to the list page after success
                } catch (IllegalArgumentException e) {
                    throw new ServletException("Invalid appointment date format. Please use 'yyyy-MM-dd HH:mm:ss'.");
                }
            } else {
                throw new ServletException("Appointment date is required.");
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error adding the appointment.");
        }
    }

    private void updateAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int patientId = Integer.parseInt(request.getParameter("patient_id"));
            int doctorId = Integer.parseInt(request.getParameter("doctor_id"));
            String status = request.getParameter("status");
            
            String appointmentDateStr = request.getParameter("appointment_date");
            if (appointmentDateStr != null && !appointmentDateStr.isEmpty()) {
                // Convert 'T' to space for compatibility with Timestamp.valueOf()
                appointmentDateStr = appointmentDateStr.replace("T", " ");
                
                try {
                    Timestamp appointmentDate = Timestamp.valueOf(appointmentDateStr);
                    Appointments appointment = new Appointments(id, patientId, doctorId, appointmentDate, status);
                    appointmentsDAO.updateAppointment(appointment);
                    response.sendRedirect("appointments.jsp");  // Redirect to the list page after success
                } catch (IllegalArgumentException e) {
                    throw new ServletException("Invalid appointment date format. Please use 'yyyy-MM-dd HH:mm:ss'.");
                }
            } else {
                throw new ServletException("Appointment date is required.");
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error updating the appointment.");
        }
    }

    // Delete an appointment
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            deleteAppointment(request, response);
        }
    }

    private void deleteAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            appointmentsDAO.deleteAppointment(id);
            response.sendRedirect("appointments.jsp");  // Redirect to the list page after deletion
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error deleting the appointment.");
        }
    }
}
