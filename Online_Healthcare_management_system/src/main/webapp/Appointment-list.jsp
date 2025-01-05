<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Appointments</title>
</head>
<body>
    <h1>Appointments</h1>
    <a href="addAppointment.jsp">Add New Appointment</a>
    <table border="1">
        <tr>
            <th>Patient ID</th>
            <th>Doctor ID</th>
            <th>Appointment Date</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="appointment" items="${appointments}">
            <tr>
                <td>${appointment.patientId}</td>
                <td>${appointment.doctorId}</td>
                <td>${appointment.appointmentDate}</td>
                <td>${appointment.status}</td>
                <td>
                    <a href="editAppointment.jsp?id=${appointment.id}">Edit</a>
                    <a href="appointments?action=delete&id=${appointment.id}" onclick="return confirm('Are you sure you want to delete this appointment?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
