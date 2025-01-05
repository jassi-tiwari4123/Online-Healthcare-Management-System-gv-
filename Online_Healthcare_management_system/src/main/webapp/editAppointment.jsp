<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Appointment</title>
</head>
<body>
    <h1>Edit Appointment</h1>
    <form action="appointments" method="post">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="${appointment.id}"/>

        <label for="patient_id">Patient ID:</label>
        <input type="text" name="patient_id" value="${appointment.patientId}" required/><br><br>

        <label for="doctor_id">Doctor ID:</label>
        <input type="text" name="doctor_id" value="${appointment.doctorId}" required/><br><br>

        <label for="appointment_date">Appointment Date:</label>
        <input type="datetime-local" name="appointment_date" value="${appointment.appointmentDate.toLocalDateTime().toString().replace('T', ' ')}" required/><br><br>

        <label for="status">Status:</label>
        <select name="status" required>
            <option value="Scheduled" ${appointment.status == 'Scheduled' ? 'selected' : ''}>Scheduled</option>
            <option value="Completed" ${appointment.status == 'Completed' ? 'selected' : ''}>Completed</option>
            <option value="Canceled" ${appointment.status == 'Canceled' ? 'selected' : ''}>Canceled</option>
        </select><br><br>

        <button type="submit">Update Appointment</button>
    </form>

    <a href="appointments.jsp">Back to Appointment List</a>
</body>
</html>
