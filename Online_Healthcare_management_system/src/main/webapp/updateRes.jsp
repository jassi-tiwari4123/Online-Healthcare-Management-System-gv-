<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Resource</title>
</head>
<body>
    <h2>Update Resource</h2>
    <form action="resources" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${resource.id}">
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${resource.name}" required><br><br>
        
        <label for="type">Type:</label>
        <input type="text" id="type" name="type" value="${resource.type}" required><br><br>
        
        <label for="status">Status:</label>
        <input type="text" id="status" name="status" value="${resource.status}" required><br><br>
        
        <label for="location">Location:</label>
        <input type="text" id="location" name="location" value="${resource.location}" required><br><br>
        
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" value="${resource.quantity}" required><br><br>
        
        <input type="submit" value="Update Resource">
    </form>
</body>
</html>
