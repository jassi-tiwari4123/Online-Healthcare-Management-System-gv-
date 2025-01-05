package com.healthcare.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Staffs {
    private int id;
    private String name;
    private String position;
    private String contactNumber;
    private String email;
    private Date hireDate;
    private BigDecimal salary;

    // Constructor
    public Staffs(int id, String name, String position, String contactNumber, String email, Date hireDate, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.contactNumber = contactNumber;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
