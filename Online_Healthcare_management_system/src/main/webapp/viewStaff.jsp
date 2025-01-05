<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Staff</title>
</head>
<body>
    <h2>Staff Details</h2>

    <p><strong>ID:</strong> ${staff.id}</p>
    <p><strong>Name:</strong> ${staff.name}</p>
    <p><strong>Position:</strong> ${staff.position}</p>
    <p><strong>Contact Number:</strong> ${staff.contactNumber}</p>
    <p><strong>Email:</strong> ${staff.email}</p>
    <p><strong>Hire Date:</strong> ${staff.hireDate}</p>
    <p><strong>Salary:</strong> ${staff.salary}</p>

    <a href="viewAllStaff.jsp">Back to All Staff</a>
</body>
</html>
