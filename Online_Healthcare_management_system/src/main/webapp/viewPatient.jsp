<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patient Details</title>
</head>
<body>
    <h1>Patient Details</h1>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <td>${patient.id}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${patient.name}</td>
        </tr>
        <tr>
            <th>Date of Birth</th>
            <td>${patient.dateOfBirth}</td>
        </tr>
        <tr>
            <th>Gender</th>
            <td>${patient.gender}</td>
        </tr>
        <tr>
            <th>Contact Number</th>
            <td>${patient.contactNumber}</td>
        </tr>
        <tr>
            <th>Address</th>
            <td>${patient.address}</td>
        </tr>
        <tr>
            <th>Emergency Contact</th>
            <td>${patient.emergencyContactNumber}</td>
        </tr>
        <tr>
            <th>Medical History</th>
            <td>${patient.medicalHistory}</td>
        </tr>
    </table>

    <a href="patientList.jsp">Back to Patient List</a>
</body>
</html>
