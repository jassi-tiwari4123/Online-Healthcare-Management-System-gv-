<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>View All Staff</title>
</head>
<body>
    <h2>All Staff Members</h2>
    
    <a href="addStaff.jsp">Add New Staff</a> |
    <a href="updateStaff.jsp">Update Staff</a> |
    <a href="deleteStaff.jsp">Delete Staff</a><br/><br/>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Position</th>
            <th>Contact Number</th>
            <th>Email</th>
            <th>Hire Date</th>
            <th>Salary</th>
        </tr>
        <c:forEach var="staff" items="${staffList}">
            <tr>
                <td>${staff.id}</td>
                <td>${staff.name}</td>
                <td>${staff.position}</td>
                <td>${staff.contactNumber}</td>
                <td>${staff.email}</td>
                <td>${staff.hireDate}</td>
                <td>${staff.salary}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
