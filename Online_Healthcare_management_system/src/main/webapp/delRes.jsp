<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Resource</title>
</head>
<body>
    <h2>Are you sure you want to delete this resource?</h2>
    <form action="resources" method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="${param.id}">
        <button type="submit">Yes, delete</button>
    </form>
    <a href="resources?action=view">Cancel</a>
</body>
</html>
