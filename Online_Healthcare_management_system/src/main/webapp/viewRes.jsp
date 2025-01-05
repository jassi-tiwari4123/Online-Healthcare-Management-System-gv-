<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Resources</title>
</head>
<body>
    <h2>All Resources</h2>
    <a href="resources?action=add">Add New Resource</a><br><br>
    
    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Status</th>
                <th>Location</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="resource" items="${resourcesList}">
                <tr>
                    <td>${resource.name}</td>
                    <td>${resource.type}</td>
                    <td>${resource.status}</td>
                    <td>${resource.location}</td>
                    <td>${resource.quantity}</td>
                    <td>
                        <a href="resources?action=update&id=${resource.id}">Edit</a> | 
                        <a href="resources?action=delete&id=${resource.id}" onclick="return confirm('Are you sure you want to delete this resource?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
