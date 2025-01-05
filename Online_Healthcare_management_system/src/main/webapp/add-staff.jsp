<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Staff</title>
</head>
<body>
    <h2>Add New Staff</h2>
    <form action="addStaff" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required/><br/><br/>

        <label for="position">Position:</label>
        <input type="text" id="position" name="position" required/><br/><br/>

        <label for="contactNumber">Contact Number:</label>
        <input type="text" id="contactNumber" name="contactNumber" required/><br/><br/>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required/><br/><br/>

        <label for="hireDate">Hire Date:</label>
        <input type="date" id="hireDate" name="hireDate" required/><br/><br/>

        <label for="salary">Salary:</label>
        <input type="number" step="0.01" id="salary" name="salary" required/><br/><br/>

        <input type="submit" value="Add Staff"/>
    </form>

    <a href="viewAllStaff.jsp">View All Staff</a>
</body>
</html>
