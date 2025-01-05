package com.healthcare.controller;

import com.healthcare.dao.DoctorsDAO;
import com.healthcare.model.Doctors;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/doctor")
public class DoctorController extends HttpServlet {

    private static final long serialVersionUID = 1L;  // Add this line for serialVersionUID

    private DoctorsDAO doctorsDAO;

    @Override
    public void init() throws ServletException {
        try {
            // Initialize the DoctorsDAO with a connection from DatabaseConnector
            Connection connection = DatabaseConnector.getConnection();
            doctorsDAO = new DoctorsDAO(connection);
        } catch (SQLException e) {
            throw new ServletException("Database connection error", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("list".equals(action)) {
                List<Doctors> doctorsList = doctorsDAO.getAllDoctors();
                request.setAttribute("doctorsList", doctorsList);
                request.getRequestDispatcher("/doctors-list.jsp").forward(request, response);
            } else if ("view".equals(action)) {
                int doctorId = Integer.parseInt(request.getParameter("id"));
                Doctors doctor = doctorsDAO.getDoctorById(doctorId);
                if (doctor != null) {
                    request.setAttribute("doctor", doctor);
                    request.getRequestDispatcher("/doctor-details.jsp").forward(request, response);
                } else {
                    response.sendRedirect("doctor?action=list");
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Error retrieving doctors data", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {
            	int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String specialty = request.getParameter("specialty");
                String contactNumber = request.getParameter("contactNumber");
                String email = request.getParameter("email");
                int yearsOfExperience = Integer.parseInt(request.getParameter("yearsOfExperience"));

                Doctors doctor = new Doctors(id,name, specialty, contactNumber, email, yearsOfExperience);
                doctorsDAO.addDoctor(doctor);
                response.sendRedirect("doctor?action=list");
            } else if ("update".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String specialty = request.getParameter("specialty");
                String contactNumber = request.getParameter("contactNumber");
                String email = request.getParameter("email");
                int yearsOfExperience = Integer.parseInt(request.getParameter("yearsOfExperience"));

                Doctors doctor = new Doctors(id, name, specialty, contactNumber, email, yearsOfExperience);
                doctorsDAO.updateDoctor(doctor);
                response.sendRedirect("doctor?action=list");
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                doctorsDAO.deleteDoctor(id);
                response.sendRedirect("doctor?action=list");
            }
        } catch (SQLException e) {
            throw new ServletException("Error handling doctor operations", e);
        }
    }

    @Override
    public void destroy() {
        try {
            Connection connection = DatabaseConnector.getConnection();
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
