<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Healthcare_Management_System - Home_page</title>
    <link rel="stylesheet" href="styles.css">
    <script src="scripts.js" defer></script>
</head>
<body>
    <div class="navbar">
        <ul>
            <li><a href="appointments.jsp">Appointments</a></li>
            <li><a href="doctors.jsp">Doctors</a></li>
            <li><a href="patients.jsp">Patients</a></li>
            <li><a href="resources.jsp">Resources</a></li>
            <li><a href="staffs.jsp">Staffs</a></li>
        </ul>
    </div>

    <div class="content">
        <h1>Welcome to the Healthcare_Management_System</h1>
        <p>Select an option from the menu to manage relevant data.</p>

        <div class="categories">
            <h2>Manage Categories</h2>
            
            <!-- Appointments Section -->
            <section class="category">
                <h3>Appointments</h3>
                <button class="add-btn" onclick="showForm('appointmentForm')">Add Appointment</button>
                <div id="appointmentForm" class="form-container" style="display:none;">
                    <h4>Add New Appointment</h4>
                    <form id="addAppointmentForm">
                        <input type="text" placeholder="Appointment ID" required><br>
                        <input type="text" placeholder="Patient Name" required><br>
                        <input type="text" placeholder="Doctor Name" required><br>
                        <input type="date" placeholder="Date" required><br>
                        <button type="submit">Add Appointment</button>
                    </form>
                </div>
                <button class="delete-btn">Delete Appointment</button>
                <button class="update-btn">Update Appointment</button>
                <div class="list-container">
                    <h4>List of Appointments</h4>
                    <!-- Appointments List will be displayed here -->
                </div>
            </section>

            <!-- Doctors Section -->
            <section class="category">
                <h3>Doctors</h3>
                <button class="add-btn" onclick="showForm('doctorForm')">Add Doctor</button>
                <div id="doctorForm" class="form-container" style="display:none;">
                    <h4>Add New Doctor</h4>
                    <form id="addDoctorForm">
                        <input type="text" placeholder="Doctor ID" required><br>
                        <input type="text" placeholder="Doctor Name" required><br>
                        <input type="text" placeholder="Specialization" required><br>
                        <button type="submit">Add Doctor</button>
                    </form>
                </div>
                <button class="delete-btn">Delete Doctor</button>
                <button class="update-btn">Update Doctor</button>
                <div class="list-container">
                    <h4>List of Doctors</h4>
                    <!-- Doctors List will be displayed here -->
                </div>
            </section>

            <!-- Patients Section -->
            <section class="category">
                <h3>Patients</h3>
                <button class="add-btn" onclick="showForm('patientForm')">Add Patient</button>
                <div id="patientForm" class="form-container" style="display:none;">
                    <h4>Add New Patient</h4>
                    <form id="addPatientForm">
                        <input type="text" placeholder="Patient ID" required><br>
                        <input type="text" placeholder="Patient Name" required><br>
                        <input type="text" placeholder="Disease" required><br>
                        <button type="submit">Add Patient</button>
                    </form>
                </div>
                <button class="delete-btn">Delete Patient</button>
                <button class="update-btn">Update Patient</button>
                <div class="list-container">
                    <h4>List of Patients</h4>
                    <!-- Patients List will be displayed here -->
                </div>
            </section>

            <!-- Resources Section -->
            <section class="category">
                <h3>Resources</h3>
                <button class="add-btn" onclick="showForm('resourceForm')">Add Resource</button>
                <div id="resourceForm" class="form-container" style="display:none;">
                    <h4>Add New Resource</h4>
                    <form id="addResourceForm">
                        <input type="text" placeholder="Resource ID" required><br>
                        <input type="text" placeholder="Resource Name" required><br>
                        <input type="number" placeholder="Quantity" required><br>
                        <button type="submit">Add Resource</button>
                    </form>
                </div>
                <button class="delete-btn">Delete Resource</button>
                <button class="update-btn">Update Resource</button>
                <div class="list-container">
                    <h4>List of Resources</h4>
                    <!-- Resources List will be displayed here -->
                </div>
            </section>

            <!-- Staffs Section -->
            <section class="category">
                <h3>Staffs</h3>
                <button class="add-btn" onclick="showForm('staffForm')">Add Staff</button>
                <div id="staffForm" class="form-container" style="display:none;">
                    <h4>Add New Staff</h4>
                    <form id="addStaffForm">
                        <input type="text" placeholder="Staff ID" required><br>
                        <input type="text" placeholder="Staff Name" required><br>
                        <input type="text" placeholder="Role" required><br>
                        <button type="submit">Add Staff</button>
                    </form>
                </div>
                <button class="delete-btn">Delete Staff</button>
                <button class="update-btn">Update Staff</button>
                <div class="list-container">
                    <h4>List of Staffs</h4>
                    <!-- Staffs List will be displayed here -->
                </div>
            </section>
        </div>
    </div>

    <footer>
        <p>&copy; 2025 Healthcare_Management_System. All rights reserved.</p>
    </footer>
</body>
</html>
