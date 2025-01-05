<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Patient</title>
</head>
<body>
    <h1>Edit Patient</h1>
    
    <form action="PatientController" method="POST">
        <input type="hidden" name="action" value="updatePatient">
        <input type="hidden" name="id" value="${patient.id}">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${patient.name}" required><br>

        <label for="dateOfBirth">Date of Birth:</label>
        <input type="date" id="dateOfBirth" name="dateOfBirth" value="${patient.dateOfBirth}" required><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="Male" ${patient.gender == 'Male' ? 'selected' : ''}>Male</option>
            <option value="Female" ${patient.gender == 'Female' ? 'selected' : ''}>Female</option>
            <option value="Other" ${patient.gender == 'Other' ? 'selected' : ''}>Other</option>
        </select><br>

        <label for="contactNumber">Contact Number:</label>
        <input type="text" id="contactNumber" name="contactNumber" value="${patient.contactNumber}" required><br>

        <label for="address">Address:</label>
        <textarea id="address" name="address" required>${patient.address}</textarea><br>

        <label for="emergencyContactNumber">Emergency Contact:</label>
        <input type="text" id="emergencyContactNumber" name="emergencyContactNumber" value="${patient.emergencyContactNumber}" required><br>

        <label for="medicalHistory">Medical History:</label>
        <textarea id="medicalHistory" name="medicalHistory" required>${patient.medicalHistory}</textarea><br>

        <button type="submit">Update Patient</button>
    </form>

    <a href="patientList.jsp">Back to Patient List</a>
</body>
</html>
