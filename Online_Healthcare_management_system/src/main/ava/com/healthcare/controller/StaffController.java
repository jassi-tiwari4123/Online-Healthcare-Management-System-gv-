package com.healthcare.controller;

import com.healthcare.dao.StaffsDAO;
import com.healthcare.model.Staffs;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class StaffController {
    private StaffsDAO staffsDAO;
    private Scanner scanner;

    public StaffController(Connection connection) {
        this.staffsDAO = new StaffsDAO(connection);
        this.scanner = new Scanner(System.in);
    }

    public void addStaff() throws SQLException {
        System.out.println("Enter staff name:");
        String name = scanner.nextLine();

        System.out.println("Enter position:");
        String position = scanner.nextLine();

        System.out.println("Enter contact number:");
        String contactNumber = scanner.nextLine();

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter hire date (yyyy-mm-dd):");
        Date hireDate = Date.valueOf(scanner.nextLine());

        System.out.println("Enter salary:");
        BigDecimal salary = new BigDecimal(scanner.nextLine());

        Staffs staff = new Staffs(0, name, position, contactNumber, email, hireDate, salary);
        staffsDAO.addStaff(staff);
        System.out.println("Staff added successfully!");
    }

    public void updateStaff() throws SQLException {
        System.out.println("Enter staff ID to update:");
        int id = Integer.parseInt(scanner.nextLine());

        Staffs staff = staffsDAO.getStaffById(id);
        if (staff != null) {
            System.out.println("Enter new name (leave blank to keep the current):");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                staff.setName(name);
            }

            System.out.println("Enter new position (leave blank to keep the current):");
            String position = scanner.nextLine();
            if (!position.isEmpty()) {
                staff.setPosition(position);
            }

            System.out.println("Enter new contact number (leave blank to keep the current):");
            String contactNumber = scanner.nextLine();
            if (!contactNumber.isEmpty()) {
                staff.setContactNumber(contactNumber);
            }

            System.out.println("Enter new email (leave blank to keep the current):");
            String email = scanner.nextLine();
            if (!email.isEmpty()) {
                staff.setEmail(email);
            }

            System.out.println("Enter new hire date (yyyy-mm-dd, leave blank to keep the current):");
            String hireDateStr = scanner.nextLine();
            if (!hireDateStr.isEmpty()) {
                staff.setHireDate(Date.valueOf(hireDateStr));
            }

            System.out.println("Enter new salary (leave blank to keep the current):");
            String salaryStr = scanner.nextLine();
            if (!salaryStr.isEmpty()) {
                staff.setSalary(new BigDecimal(salaryStr));
            }

            staffsDAO.updateStaff(staff);
        } else {
            System.out.println("Staff not found.");
        }
    }

    public void deleteStaff() throws SQLException {
        System.out.println("Enter staff ID to delete:");
        int id = Integer.parseInt(scanner.nextLine());
        staffsDAO.deleteStaff(id);
        System.out.println("Staff deleted successfully!");
    }

    public void viewStaffById() throws SQLException {
        System.out.println("Enter staff ID to view:");
        int id = Integer.parseInt(scanner.nextLine());

        Staffs staff = staffsDAO.getStaffById(id);
        if (staff != null) {
            System.out.println("Staff ID: " + staff.getId());
            System.out.println("Name: " + staff.getName());
            System.out.println("Position: " + staff.getPosition());
            System.out.println("Contact Number: " + staff.getContactNumber());
            System.out.println("Email: " + staff.getEmail());
            System.out.println("Hire Date: " + staff.getHireDate());
            System.out.println("Salary: " + staff.getSalary());
        } else {
            System.out.println("Staff not found.");
        }
    }

    public void viewAllStaffs() throws SQLException {
        List<Staffs> staffs = staffsDAO.getAllStaffs();
        for (Staffs staff : staffs) {
            System.out.println("Staff ID: " + staff.getId());
            System.out.println("Name: " + staff.getName());
            System.out.println("Position: " + staff.getPosition());
            System.out.println("Contact Number: " + staff.getContactNumber());
            System.out.println("Email: " + staff.getEmail());
            System.out.println("Hire Date: " + staff.getHireDate());
            System.out.println("Salary: " + staff.getSalary());
            System.out.println("-------------------------");
        }
    }

    public void showMenu() {
        System.out.println("\nStaff Management Menu:");
        System.out.println("1. Add Staff");
        System.out.println("2. Update Staff");
        System.out.println("3. Delete Staff");
        System.out.println("4. View Staff By ID");
        System.out.println("5. View All Staff");
        System.out.println("6. Exit");

        System.out.print("Choose an option: ");
    }

    public void start() throws SQLException {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    updateStaff();
                    break;
                case 3:
                    deleteStaff();
                    break;
                case 4:
                    viewStaffById();
                    break;
                case 5:
                    viewAllStaffs();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        // Set up database connection
        String url = "jdbc:mysql://localhost:3306/healthcare";
        String user = "root";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            StaffController controller = new StaffController(connection);
            controller.start();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
        }
    }
}
