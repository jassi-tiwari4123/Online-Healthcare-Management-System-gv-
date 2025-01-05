<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Doctor</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Edit Doctor</h1>
        <form action="edit-doctor" method="post">
            <input type="hidden" name="id" value="${doctor.id}">

            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="${doctor.name}" required>
            </div>
            <div class="form-group">
                <label for="specialty">Specialty</label>
                <input type="text" class="form-control" id="specialty" name="specialty" value="${doctor.specialty}" required>
            </div>
            <div class="form-group">
                <label for="contactNumber">Contact Number</label>
                <input type="text" class="form-control" id="contactNumber" name="contactNumber" value="${doctor.contactNumber}" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${doctor.email}" required>
            </div>
            <div class="form-group">
                <label for="yearsOfExperience">Years of Experience</label>
                <input type="number" class="form-control" id="yearsOfExperience" name="yearsOfExperience" value="${doctor.yearsOfExperience}" required>
            </div>
            <button type="submit" class="btn btn-warning">Update Doctor</button>
            <a href="doctor-list.jsp" class="btn btn-secondary ml-2">Cancel</a>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
