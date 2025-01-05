import com.healthcare.dao.DoctorsDAO;
import com.healthcare.dao.PatientsDAO;
import com.healthcare.dao.AppointmentsDAO;
import com.healthcare.dao.StaffsDAO;
import com.healthcare.dao.ResourcesDAO;


import com.healthcare.model.Doctors;
import com.healthcare.model.Patients;
import com.healthcare.model.Appointments;
import com.healthcare.model.Staffs;
import com.healthcare.model.Resources;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare_db", "root", "Jassi@4123");
             Scanner scanner = new Scanner(System.in)) {

            DoctorsDAO doctorsDAO = new DoctorsDAO(connection);
            PatientsDAO patientsDAO = new PatientsDAO(connection);
            AppointmentsDAO appointmentsDAO=new AppointmentsDAO(connection);
            StaffsDAO staffsDAO=new StaffsDAO(connection);
            ResourcesDAO resourcesDAO=new ResourcesDAO(connection);
            boolean running = true;

            while (running) {
                System.out.println("Choose an option:");
                System.out.println("1. Manage Doctors");
                System.out.println("2. Manage Patients");
                System.out.println("3. Manage Appointments");
                System.out.println("4. Manage Staffs");
                System.out.println("5. Manage Resources");
                System.out.println("6. Exit");
                int mainChoice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (mainChoice) {
                    case 1: // Manage Doctors
                        manageDoctors(scanner, doctorsDAO);
                        break;
                    case 2: // Manage Patients
                        managePatients(scanner, patientsDAO);
                        break;
                    case 3: // Manage Appointments
                        manageAppointments(scanner, appointmentsDAO, doctorsDAO, patientsDAO);
                        break;
                    case 4://Manage staffs
                    	manageStaffs(scanner, staffsDAO);
                    	break;
                    case 5://Manage resources
                    	manageResources(scanner, resourcesDAO);
                    	break;
                    case 6: // Exit
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void manageDoctors(Scanner scanner, DoctorsDAO doctorsDAO) throws SQLException {
        boolean doctorMenuRunning = true;
        while (doctorMenuRunning) {
            System.out.println("Doctor Management:");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Get Doctor by ID");
            System.out.println("5. List All Doctors");
            System.out.println("6. Back");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Add Doctor
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter specialty: ");
                    String specialty = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter years of experience: ");
                    int yearsOfExperience = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Doctors newDoctor = new Doctors(0, name, specialty, contactNumber, email, yearsOfExperience);
                    doctorsDAO.addDoctor(newDoctor);
                    System.out.println("Doctor added successfully!");
                    break;

                case 2: // Update Doctor
                    System.out.print("Enter Doctor ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Doctors doctorToUpdate = doctorsDAO.getDoctorById(updateId);
                    if (doctorToUpdate != null) {
                        System.out.print("Enter new name (leave empty to keep current): ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new specialty (leave empty to keep current): ");
                        String newSpecialty = scanner.nextLine();
                        System.out.print("Enter new contact number (leave empty to keep current): ");
                        String newContactNumber = scanner.nextLine();
                        System.out.print("Enter new email (leave empty to keep current): ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter new years of experience (0 to keep current): ");
                        int newYearsOfExperience = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (!newName.isEmpty()) doctorToUpdate.setName(newName);
                        if (!newSpecialty.isEmpty()) doctorToUpdate.setSpecialty(newSpecialty);
                        if (!newContactNumber.isEmpty()) doctorToUpdate.setContactNumber(newContactNumber);
                        if (!newEmail.isEmpty()) doctorToUpdate.setEmail(newEmail);
                        if (newYearsOfExperience > 0) doctorToUpdate.setYearsOfExperience(newYearsOfExperience);

                        doctorsDAO.updateDoctor(doctorToUpdate);
                        System.out.println("Doctor updated successfully!");
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                case 3: // Delete Doctor
                    System.out.print("Enter Doctor ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    doctorsDAO.deleteDoctor(deleteId);
                    System.out.println("Doctor deleted successfully!");
                    break;

                case 4: // Get Doctor by ID
                    System.out.print("Enter Doctor ID: ");
                    int getId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Doctors doctor = doctorsDAO.getDoctorById(getId);
                    if (doctor != null) {
                        System.out.println("ID: " + doctor.getId() +
                                ", Name: " + doctor.getName() +
                                ", Specialty: " + doctor.getSpecialty() +
                                ", Contact: " + doctor.getContactNumber() +
                                ", Email: " + doctor.getEmail() +
                                ", Years of Experience: " + doctor.getYearsOfExperience());
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                case 5: // List All Doctors
                    List<Doctors> doctorsList = doctorsDAO.getAllDoctors();
                    if (doctorsList.isEmpty()) {
                        System.out.println("No doctors found.");
                    } else {
                        System.out.println("List of Doctors:");
                        for (Doctors d : doctorsList) {
                            System.out.println("ID: " + d.getId() +
                                    ", Name: " + d.getName() +
                                    ", Specialty: " + d.getSpecialty() +
                                    ", Contact: " + d.getContactNumber() +
                                    ", Email: " + d.getEmail() +
                                    ", Years of Experience: " + d.getYearsOfExperience());
                        }
                    }
                    break;

                case 6: // Back
                    doctorMenuRunning = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void managePatients(Scanner scanner, PatientsDAO patientsDAO) throws SQLException {
        boolean patientMenuRunning = true;
        while (patientMenuRunning) {
            System.out.println("Patient Management:");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Get Patient by ID");
            System.out.println("5. List All Patients");
            System.out.println("6. Back");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Add Patient
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
                    Date dateOfBirth = Date.valueOf(scanner.nextLine());
                    System.out.print("Enter gender (Male/Female/Other): ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter emergency contact number: ");
                    String emergencyContactNumber = scanner.nextLine();
                    System.out.print("Enter medical history: ");
                    String medicalHistory = scanner.nextLine();

                    Patients newPatient = new Patients(0, name, dateOfBirth, gender, contactNumber, address, emergencyContactNumber, medicalHistory);
                    patientsDAO.addPatient(newPatient);
                    System.out.println("Patient added successfully!");
                    break;

                case 2: // Update Patient
                    System.out.print("Enter Patient ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Patients patientToUpdate = patientsDAO.getPatientById(updateId);
                    if (patientToUpdate != null) {
                        System.out.print("Enter new name (leave empty to keep current): ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new date of birth (YYYY-MM-DD) (leave empty to keep current): ");
                        String newDobInput = scanner.nextLine();
                        Date newDateOfBirth = newDobInput.isEmpty() ? patientToUpdate.getDateOfBirth() : Date.valueOf(newDobInput);
                        System.out.print("Enter new gender (leave empty to keep current): ");
                        String newGender = scanner.nextLine();
                        System.out.print("Enter new contact number (leave empty to keep current): ");
                        String newContactNumber = scanner.nextLine();
                        System.out.print("Enter new address (leave empty to keep current): ");
                        String newAddress = scanner.nextLine();
                        System.out.print("Enter new emergency contact number (leave empty to keep current): ");
                        String newEmergencyContactNumber = scanner.nextLine();
                        System.out.print("Enter new medical history (leave empty to keep current): ");
                        String newMedicalHistory = scanner.nextLine();

                        if (!newName.isEmpty()) patientToUpdate.setName(newName);
                        if (!newDobInput.isEmpty()) patientToUpdate.setDateOfBirth(newDateOfBirth);
                        if (!newGender.isEmpty()) patientToUpdate.setGender(newGender);
                        if (!newContactNumber.isEmpty()) patientToUpdate.setContactNumber(newContactNumber);
                        if (!newAddress.isEmpty()) patientToUpdate.setAddress(newAddress);
                        if (!newEmergencyContactNumber.isEmpty()) patientToUpdate.setEmergencyContactNumber(newEmergencyContactNumber);
                        if (!newMedicalHistory.isEmpty()) patientToUpdate.setMedicalHistory(newMedicalHistory);

                        patientsDAO.updatePatient(patientToUpdate);
                        System.out.println("Patient updated successfully!");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 3: // Delete Patient
                    System.out.print("Enter Patient ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    patientsDAO.deletePatient(deleteId);
                    System.out.println("Patient deleted successfully!");
                    break;

                case 4: // Get Patient by ID
                    System.out.print("Enter Patient ID: ");
                    int getId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Patients patient = patientsDAO.getPatientById(getId);
                    if (patient != null) {
                        System.out.println("ID: " + patient.getId() +
                                ", Name: " + patient.getName() +
                                ", Date of Birth: " + patient.getDateOfBirth() +
                                ", Gender: " + patient.getGender() +
                                ", Contact: " + patient.getContactNumber() +
                                ", Address: " + patient.getAddress() +
                                ", Emergency Contact: " + patient.getEmergencyContactNumber() +
                                ", Medical History: " + patient.getMedicalHistory());
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 5: // List All Patients
                    List<Patients> patientsList = patientsDAO.getAllPatients();
                    if (patientsList.isEmpty()) {
                        System.out.println("No patients found.");
                    } else {
                        System.out.println("List of Patients:");
                        for (Patients p : patientsList) {
                            System.out.println("ID: " + p.getId() +
                                    ", Name: " + p.getName() +
                                    ", Date of Birth: " + p.getDateOfBirth() +
                                    ", Gender: " + p.getGender() +
                                    ", Contact: " + p.getContactNumber() +
                                    ", Address: " + p.getAddress() +
                                    ", Emergency Contact: " + p.getEmergencyContactNumber() +
                                    ", Medical History: " + p.getMedicalHistory());
                        }
                    }
                    break;

                case 6: // Back
                    patientMenuRunning = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private static void manageAppointments(Scanner scanner, AppointmentsDAO appointmentsDAO, DoctorsDAO doctorsDAO, PatientsDAO patientsDAO) throws SQLException {
        boolean appointmentMenuRunning = true;
        while (appointmentMenuRunning) {
            System.out.println("Appointment Management:");
            System.out.println("1. Add Appointment");
            System.out.println("2. Update Appointment:");
            System.out.println("3. Delete Appointment:");
            System.out.println("4. Get Appointment by ID");
            System.out.println("5. List All Appointments");
            System.out.println("6. Back");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Add Appointment
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    System.out.print("Enter Doctor ID: ");
                    int doctorId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    if (!patientsDAO.exists(patientId)) {
                        System.out.println("Patient ID does not exist.");
                        break;
                    }
                    if (!doctorsDAO.exists(doctorId)) {
                        System.out.println("Doctor ID does not exist.");
                        break;
                    }

                    Timestamp appointmentDate = null;
                    while (appointmentDate == null) {
                        System.out.print("Enter appointment date (YYYY-MM-DD HH:MM:SS): ");
                        String dateInput = scanner.nextLine();
                        try {
                            appointmentDate = Timestamp.valueOf(dateInput);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid date format. Please use YYYY-MM-DD HH:MM:SS.");
                        }
                    }

                    Appointments newAppointment = new Appointments(0, patientId, doctorId, appointmentDate, "Scheduled");
                    appointmentsDAO.addAppointment(newAppointment);
                    System.out.println("Appointment added successfully!");
                    break;

                case 2: // Update Appointment
                    System.out.print("Enter Appointment ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Appointments existingAppointment = appointmentsDAO.getAppointmentById(updateId);
                    if (existingAppointment == null) {
                        System.out.println("No appointment found with the provided ID.");
                        break;
                    }

                    System.out.println("Leave blank to keep existing details.");
                    System.out.print("Current patient ID: " + existingAppointment.getPatientId() + ". Enter new patient ID: ");
                    String newPatientIdInput = scanner.nextLine();
                    if (!newPatientIdInput.isEmpty()) existingAppointment.setPatientId(Integer.parseInt(newPatientIdInput));

                    System.out.print("Current doctor ID: " + existingAppointment.getDoctorId() + ". Enter new doctor ID: ");
                    String newDoctorIdInput = scanner.nextLine();
                    if (!newDoctorIdInput.isEmpty()) existingAppointment.setDoctorId(Integer.parseInt(newDoctorIdInput));

                    System.out.print("Current appointment date: " + existingAppointment.getAppointmentDate() + ". Enter new appointment date (YYYY-MM-DD HH:MM:SS): ");
                    String newDateInput = scanner.nextLine();
                    if (!newDateInput.isEmpty()) existingAppointment.setAppointmentDate(Timestamp.valueOf(newDateInput));

                    System.out.print("Current status: " + existingAppointment.getStatus() + ". Enter new status: ");
                    String newStatusInput = scanner.nextLine();
                    if (!newStatusInput.isEmpty()) existingAppointment.setStatus(newStatusInput);

                    appointmentsDAO.updateAppointment(existingAppointment);
                    System.out.println("Appointment updated successfully!");
                    break;

                case 3: // Delete Appointment
                    System.out.print("Enter Appointment ID to delete: ");
                    int deleteId = scanner.nextInt();
                    appointmentsDAO.deleteAppointment(deleteId);
                    System.out.println("Appointment deleted successfully!");
                    break;

                case 4: // Get Appointment by ID
                    System.out.print("Enter Appointment ID: ");
                    int getId = scanner.nextInt();
                    Appointments appointment = appointmentsDAO.getAppointmentById(getId);
                    if (appointment != null) {
                        System.out.println("Appointment found: " +
                                "ID: " + appointment.getId() +
                                ", Patient ID: " + appointment.getPatientId() +
                                ", Doctor ID: " + appointment.getDoctorId() +
                                ", Appointment Date: " + appointment.getAppointmentDate() +
                                ", Status: " + appointment.getStatus());
                    } else {
                        System.out.println("Appointment not found.");
                    }
                    break;

                case 5: // List All Appointments
                    List<Appointments> appointmentsList = appointmentsDAO.getAllAppointments();
                    if (appointmentsList.isEmpty()) {
                        System.out.println("No appointments found.");
                    } else {
                        System.out.println("List of Appointments:");
                        for (Appointments a : appointmentsList) {
                            System.out.println("ID: " + a.getId() +
                                    ", Patient ID: " + a.getPatientId() +
                                    ", Doctor ID: " + a.getDoctorId() +
                                    ", Appointment Date: " + a.getAppointmentDate() +
                                    ", Status: " + a.getStatus());
                        }
                    }
                    break;

                case 6: // Back
                	appointmentMenuRunning = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private static void manageStaffs(Scanner scanner, StaffsDAO staffsDAO) throws SQLException {
        boolean staffMenuRunning = true;
        while (staffMenuRunning) {
            System.out.println("Staff Management:");
            System.out.println("1. Add Staff");
            System.out.println("2. Update Staff");
            System.out.println("3. Delete Staff");
            System.out.println("4. Get Staff by ID");
            System.out.println("5. List All Staff");
            System.out.println("6. Back");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Add Staff
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter hire date (YYYY-MM-DD): ");
                    String hireDateInput = scanner.nextLine();
                    Date hireDate = Date.valueOf(hireDateInput); // You may want to add error handling for date

                    System.out.print("Enter salary: ");
                    BigDecimal salary = scanner.nextBigDecimal();
                    scanner.nextLine();  // Consume newline

                    Staffs newStaff = new Staffs(0, name, position, contactNumber, email, hireDate, salary);
                    staffsDAO.addStaff(newStaff);
                    System.out.println("Staff added successfully!");
                    break;

                case 2: // Update Staff
                    System.out.print("Enter Staff ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Staffs existingStaff = staffsDAO.getStaffById(updateId);
                    if (existingStaff == null) {
                        System.out.println("No staff found with the provided ID.");
                        break;
                    }

                    System.out.println("Leave blank to keep existing details.");
                    
                    System.out.print("Current name: " + existingStaff.getName() + ". Enter new name: ");
                    String newName = scanner.nextLine();
                    if (!newName.isEmpty()) existingStaff.setName(newName);

                    System.out.print("Current position: " + existingStaff.getPosition() + ". Enter new position: ");
                    String newPosition = scanner.nextLine();
                    if (!newPosition.isEmpty()) existingStaff.setPosition(newPosition);

                    System.out.print("Current contact number: " + existingStaff.getContactNumber() + ". Enter new contact number: ");
                    String newContactNumber = scanner.nextLine();
                    if (!newContactNumber.isEmpty()) existingStaff.setContactNumber(newContactNumber);

                    System.out.print("Current email: " + existingStaff.getEmail() + ". Enter new email: ");
                    String newEmail = scanner.nextLine();
                    if (!newEmail.isEmpty()) existingStaff.setEmail(newEmail);

                    System.out.print("Current hire date: " + existingStaff.getHireDate() + ". Enter new hire date (YYYY-MM-DD): ");
                    String newHireDateInput = scanner.nextLine();
                    if (!newHireDateInput.isEmpty()) {
                        Date newHireDate = Date.valueOf(newHireDateInput); // Error handling can be added
                        existingStaff.setHireDate(newHireDate);
                    }

                    System.out.print("Current salary: " + existingStaff.getSalary() + ". Enter new salary: ");
                    String newSalaryInput = scanner.nextLine();
                    if (!newSalaryInput.isEmpty()) {
                        BigDecimal newSalary = new BigDecimal(newSalaryInput);
                        existingStaff.setSalary(newSalary);
                    }

                    staffsDAO.updateStaff(existingStaff);
                    System.out.println("Staff updated successfully!");
                    break;

                case 3: // Delete Staff
                    System.out.print("Enter Staff ID to delete: ");
                    int deleteId = scanner.nextInt();
                    staffsDAO.deleteStaff(deleteId);
                    System.out.println("Staff deleted successfully!");
                    break;

                case 4: // Get Staff by ID
                    System.out.print("Enter Staff ID: ");
                    int getId = scanner.nextInt();
                    Staffs staff = staffsDAO.getStaffById(getId);
                    if (staff != null) {
                        System.out.println("Staff found: " +
                                "ID: " + staff.getId() +
                                ", Name: " + staff.getName() +
                                ", Position: " + staff.getPosition() +
                                ", Contact Number: " + staff.getContactNumber() +
                                ", Email: " + staff.getEmail() +
                                ", Hire Date: " + staff.getHireDate() +
                                ", Salary: " + staff.getSalary());
                    } else {
                        System.out.println("Staff not found.");
                    }
                    break;

                case 5: // List All Staff
                    List<Staffs> staffList = staffsDAO.getAllStaffs();
                    if (staffList.isEmpty()) {
                        System.out.println("No staff found.");
                    } else {
                        System.out.println("List of Staff:");
                        for (Staffs s : staffList) {
                            System.out.println("ID: " + s.getId() +
                                    ", Name: " + s.getName() +
                                    ", Position: " + s.getPosition() +
                                    ", Contact Number: " + s.getContactNumber() +
                                    ", Email: " + s.getEmail() +
                                    ", Hire Date: " + s.getHireDate() +
                                    ", Salary: " + s.getSalary());
                        }
                    }
                    break;

                case 6: // Back
                    staffMenuRunning = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private static void manageResources(Scanner scanner, ResourcesDAO resourcesDAO) throws SQLException {
        boolean resourcesMenuRunning = true;
        while (resourcesMenuRunning) {
            System.out.println("Resources Management:");
            System.out.println("1. Add Resource");
            System.out.println("2. Update Resource");
            System.out.println("3. Delete Resource");
            System.out.println("4. Get Resource by ID");
            System.out.println("5. List All Resources");
            System.out.println("6. Back");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Add Resource
                    System.out.print("Enter resource name: ");
                    String resourceName = scanner.nextLine();
                    System.out.print("Enter resource type: ");
                    String resourceType = scanner.nextLine();
                    System.out.print("Enter resource status: ");
                    String status = scanner.nextLine();
                    System.out.print("Enter resource location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Resources newResource = new Resources(0, resourceName, resourceType, status, location, quantity);
                    resourcesDAO.addResource(newResource);
                    System.out.println("Resource added successfully!");
                    break;

                case 2: // Update Resource
                    System.out.print("Enter Resource ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Resources existingResource = resourcesDAO.getResourceById(updateId);
                    if (existingResource == null) {
                        System.out.println("No resource found with the provided ID.");
                        break;
                    }

                    System.out.println("Leave blank to keep existing details.");
                    System.out.print("Current name: " + existingResource.getName() + ". Enter new name: ");
                    String newName = scanner.nextLine();
                    if (!newName.isEmpty()) existingResource.setName(newName);

                    System.out.print("Current type: " + existingResource.getType() + ". Enter new type: ");
                    String newType = scanner.nextLine();
                    if (!newType.isEmpty()) existingResource.setType(newType);

                    System.out.print("Current status: " + existingResource.getStatus() + ". Enter new status: ");
                    String newStatus = scanner.nextLine();
                    if (!newStatus.isEmpty()) existingResource.setStatus(newStatus);

                    System.out.print("Current location: " + existingResource.getLocation() + ". Enter new location: ");
                    String newLocation = scanner.nextLine();
                    if (!newLocation.isEmpty()) existingResource.setLocation(newLocation);

                    System.out.print("Current quantity: " + existingResource.getQuantity() + ". Enter new quantity: ");
                    String newQuantityInput = scanner.nextLine();
                    if (!newQuantityInput.isEmpty()) {
                        existingResource.setQuantity(Integer.parseInt(newQuantityInput));
                    }

                    resourcesDAO.updateResource(existingResource);
                    System.out.println("Resource updated successfully!");
                    break;

                case 3: // Delete Resource
                    System.out.print("Enter Resource ID to delete: ");
                    int deleteId = scanner.nextInt();
                    resourcesDAO.deleteResource(deleteId);
                    System.out.println("Resource deleted successfully!");
                    break;

                case 4: // Get Resource by ID
                    System.out.print("Enter Resource ID: ");
                    int getId = scanner.nextInt();
                    Resources resource = resourcesDAO.getResourceById(getId);
                    if (resource != null) {
                        System.out.println("Resource found: " +
                                "ID: " + resource.getId() +
                                ", Name: " + resource.getName() +
                                ", Type: " + resource.getType() +
                                ", Status: " + resource.getStatus() +
                                ", Location: " + resource.getLocation() +
                                ", Quantity: " + resource.getQuantity());
                    } else {
                        System.out.println("Resource not found.");
                    }
                    break;

                case 5: // List All Resources
                    List<Resources> resourceList = resourcesDAO.getAllResources();
                    if (resourceList.isEmpty()) {
                        System.out.println("No resources found.");
                    } else {
                        System.out.println("List of Resources:");
                        for (Resources r : resourceList) {
                            System.out.println("ID: " + r.getId() +
                                    ", Name: " + r.getName() +
                                    ", Type: " + r.getType() +
                                    ", Status: " + r.getStatus() +
                                    ", Location: " + r.getLocation() +
                                    ", Quantity: " + r.getQuantity());
                        }
                    }
                    break;

                case 6: // Back
                    resourcesMenuRunning = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
}