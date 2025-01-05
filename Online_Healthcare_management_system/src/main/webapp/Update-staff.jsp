<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Staff</title>
</head>
<body>
    <h2>Update Staff Information</h2>
    <form action="updateStaff" method="POST">
        <label for="id">Staff ID:</label>
        <input type="number" id="id" name="id" required/><br/><br/>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name"/><br/><br/>

        <label for="position">Position:</label>
        <input type="text" id="position" name="position"/><br/><br/>

        <label for="contactNumber">Contact Number:</label>
        <input type="text" id="contactNumber" name="contactNumber"/><br/><br/>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email"/><br/><br/>

        <label for="hireDate">Hire Date:</label>
        <input type="date" id="hireDate" name="hireDate"/><br/><br/>

        <label for="salary">Salary:</label>
        <input type="number" step="0.01" id="salary" name="salary"/><br/><br/>

        <input type="submit" value="Update Staff"/>
    </form>

    <a href="viewAllStaff.jsp">View All Staff</a>
</body>
</html>
