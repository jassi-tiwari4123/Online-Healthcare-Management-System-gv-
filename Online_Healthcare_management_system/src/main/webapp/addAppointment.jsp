<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Appointment</title>
</head>
<body>
    <h1>Add New Appointment</h1>
    <form action="appointments" method="post">
        <input type="hidden" name="action" value="add"/>
        
        <label for="patient_id">Patient ID:</label>
        <input type="text" name="patient_id" required/><br><br>

        <label for="doctor_id">Doctor ID:</label>
        <input type="text" name="doctor_id" required/><br><br>

        <label for="appointment_date">Appointment Date:</label>
        <input type="datetime-local" name="appointment_date" required/><br><br>

        <label for="status">Status:</label>
        <select name="status" required>
            <option value="Scheduled">Scheduled</option>
            <option value="Completed">Completed</option>
            <option value="Canceled">Canceled</option>
        </select><br><br>

        <button type="submit">Add Appointment</button>
    </form>

    <a href="appointments.jsp">Back to Appointment List</a>
</body>
</html>
