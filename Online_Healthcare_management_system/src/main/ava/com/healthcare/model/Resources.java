package com.healthcare.model;

public class Resources {
    private int id;
    private String name;
    private String type; // e.g., equipment, room, supply
    private String status; // e.g., available, in use
    private String location;
    private int quantity;

    // Constructor
    public Resources(int id, String name, String type, String status, String location, int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.location = location;
        this.quantity = quantity;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
