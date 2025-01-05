<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Patient</title>
</head>
<body>
    <h1>Are you sure you want to delete this patient?</h1>
    <form action="PatientController" method="POST">
        <input type="hidden" name="action" value="deletePatient">
        <input type="hidden" name="id" value="${param.id}">
        <button type="submit">Yes, Delete</button>
    </form>
    <a href="patientList.jsp">No, Back to Patient List</a>
</body>
</html>
