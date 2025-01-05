package com.healthcare.controller;

import com.healthcare.dao.PatientsDAO;
import com.healthcare.model.Patients;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PatientController extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private PatientsDAO patientsDAO;

    @Override
    public void init() throws ServletException {
        // Initialize the PatientsDAO with a database connection
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        patientsDAO = new PatientsDAO(connection);
    }

    // Handling GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "listPatients"; // Default action
        }

        switch (action) {
            case "listPatients":
                listPatients(request, response);
                break;
            case "viewPatient":
                viewPatient(request, response);
                break;
            case "editPatient":
                editPatient(request, response);
                break;
            case "deletePatient":
                deletePatient(request, response);
                break;
            default:
                listPatients(request, response);
                break;
        }
    }

    // Handling POST requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "listPatients"; // Default action
        }

        switch (action) {
            case "addPatient":
                addPatient(request, response);
                break;
            case "updatePatient":
                updatePatient(request, response);
                break;
            case "deletePatient":
                deletePatient(request, response);
                break;
            default:
                listPatients(request, response);
                break;
        }
    }

    private void listPatients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Patients> patients = patientsDAO.getAllPatients();
            request.setAttribute("patients", patients);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/patientList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving patients list", e);
        }
    }

    private void viewPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Patients patient = patientsDAO.getPatientById(id);
            request.setAttribute("patient", patient);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewPatient.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving patient details", e);
        }
    }

    private void addPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        java.sql.Date dateOfBirth = java.sql.Date.valueOf(request.getParameter("dateOfBirth"));
        String gender = request.getParameter("gender");
        String contactNumber = request.getParameter("contactNumber");
        String address = request.getParameter("address");
        String emergencyContactNumber = request.getParameter("emergencyContactNumber");
        String medicalHistory = request.getParameter("medicalHistory");

        Patients patient = new Patients(0, name, dateOfBirth, gender, contactNumber, address, emergencyContactNumber, medicalHistory);
        try {
            patientsDAO.addPatient(patient);
            response.sendRedirect("PatientController?action=listPatients");
        } catch (SQLException e) {
            throw new ServletException("Error adding patient", e);
        }
    }

    private void editPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Patients patient = patientsDAO.getPatientById(id);
            request.setAttribute("patient", patient);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/editPatient.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving patient for editing", e);
        }
    }

    private void updatePatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        java.sql.Date dateOfBirth = java.sql.Date.valueOf(request.getParameter("dateOfBirth"));
        String gender = request.getParameter("gender");
        String contactNumber = request.getParameter("contactNumber");
        String address = request.getParameter("address");
        String emergencyContactNumber = request.getParameter("emergencyContactNumber");
        String medicalHistory = request.getParameter("medicalHistory");

        Patients patient = new Patients(id, name, dateOfBirth, gender, contactNumber, address, emergencyContactNumber, medicalHistory);
        try {
            patientsDAO.updatePatient(patient);
            response.sendRedirect("PatientController?action=listPatients");
        } catch (SQLException e) {
            throw new ServletException("Error updating patient", e);
        }
    }

    private void deletePatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            patientsDAO.deletePatient(id);
            response.sendRedirect("PatientController?action=listPatients");
        } catch (SQLException e) {
            throw new ServletException("Error deleting patient", e);
        }
    }
}
