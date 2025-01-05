package com.healthcare.model;

public class Doctors {
    private int id;
    private String name;
    private String specialty;
    private String contactNumber;
    private String email;
    private int yearsOfExperience;

    public Doctors(int id, String name, String specialty, String contactNumber, String email, int yearsOfExperience) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.contactNumber = contactNumber;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
