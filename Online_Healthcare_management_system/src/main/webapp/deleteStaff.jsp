<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Staff</title>
</head>
<body>
    <h2>Delete Staff Member</h2>
    <form action="deleteStaff" method="POST">
        <label for="id">Staff ID:</label>
        <input type="number" id="id" name="id" required/><br/><br/>
        <input type="submit" value="Delete Staff"/>
    </form>

    <a href="viewAllStaff.jsp">View All Staff</a>
</body>
</html>
