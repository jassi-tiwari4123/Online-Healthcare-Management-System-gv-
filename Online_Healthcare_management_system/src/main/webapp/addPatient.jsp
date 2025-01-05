<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Patient</title>
</head>
<body>
    <h1>Add New Patient</h1>
    <form action="PatientController" method="POST">
        <input type="hidden" name="action" value="addPatient">
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="dateOfBirth">Date of Birth:</label>
        <input type="date" id="dateOfBirth" name="dateOfBirth" required><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select><br>

        <label for="contactNumber">Contact Number:</label>
        <input type="text" id="contactNumber" name="contactNumber" required><br>

        <label for="address">Address:</label>
        <textarea id="address" name="address" required></textarea><br>

        <label for="emergencyContactNumber">Emergency Contact:</label>
        <input type="text" id="emergencyContactNumber" name="emergencyContactNumber" required><br>

        <label for="medicalHistory">Medical History:</label>
        <textarea id="medicalHistory" name="medicalHistory" required></textarea><br>

        <button type="submit">Add Patient</button>
    </form>

    <a href="patientList.jsp">Back to Patient List</a>
</body>
</html>
