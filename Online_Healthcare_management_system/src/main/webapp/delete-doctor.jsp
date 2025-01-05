<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Doctor</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Are you sure you want to delete this doctor?</h1>
        
        <form action="delete-doctor" method="post">
            <input type="hidden" name="id" value="${doctor.id}">
            <p><strong>Name:</strong> ${doctor.name}</p>
            <p><strong>Specialty:</strong> ${doctor.specialty}</p>
            <p><strong>Contact Number:</strong> ${doctor.contactNumber}</p>
            <p><strong>Email:</strong> ${doctor.email}</p>
            <p><strong>Years of Experience:</strong> ${doctor.yearsOfExperience}</p>
            
            <button type="submit" class="btn btn-danger">Delete</button>
            <a href="doctor-list.jsp" class="btn btn-secondary ml-2">Cancel</a>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
