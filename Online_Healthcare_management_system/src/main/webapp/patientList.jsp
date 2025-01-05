<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patients List</title>
</head>
<body>
    <h1>Patients List</h1>
    <a href="addPatient.jsp">Add New Patient</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                <th>Contact Number</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="patient" items="${patients}">
                <tr>
                    <td>${patient.id}</td>
                    <td>${patient.name}</td>
                    <td>${patient.dateOfBirth}</td>
                    <td>${patient.gender}</td>
                    <td>${patient.contactNumber}</td>
                    <td>
                        <a href="viewPatient.jsp?id=${patient.id}">View</a>
                        <a href="editPatient.jsp?id=${patient.id}">Edit</a>
                        <a href="deletePatient?id=${patient.id}" onclick="return confirm('Are you sure you want to delete this patient?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
