<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctors List</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f4f9;
        }
        .container {
            margin-top: 30px;
        }
        table th, table td {
            text-align: center;
        }
        .btn-danger {
            background-color: #dc3545;
        }
        .btn-primary {
            background-color: #007bff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Doctors List</h2>
        <table class="table table-bordered table-striped table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Specialty</th>
                    <th>Contact Number</th>
                    <th>Email</th>
                    <th>Years of Experience</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="doctor" items="${doctors}">
                    <tr>
                        <td>${doctor.id}</td>
                        <td>${doctor.name}</td>
                        <td>${doctor.specialty}</td>
                        <td>${doctor.contactNumber}</td>
                        <td>${doctor.email}</td>
                        <td>${doctor.yearsOfExperience}</td>
                        <td>
                            <a href="editDoctor?id=${doctor.id}" class="btn btn-primary">Edit</a>
                            <a href="deleteDoctor?id=${doctor.id}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this doctor?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="addDoctor.jsp" class="btn btn-success">Add New Doctor</a>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Optional: JavaScript to enhance interactivity -->
    <script>
        // Custom JavaScript for confirmation or alerts if needed
    </script>
</body>
</html>
