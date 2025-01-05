package com.healthcare.Services;

import com.healthcare.dao.ResourcesDAO;
import com.healthcare.model.Resources;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ResourceServices {
    private ResourcesDAO resourcesDAO;

    // Constructor to initialize the DAO with a connection
    public ResourceServices(Connection connection) {
        this.resourcesDAO = new ResourcesDAO(connection);
    }

    // Add a new resource
    public void addResource(String name, String type, String status, String location, int quantity) throws SQLException {
        Resources resource = new Resources(0, name, type, status, location, quantity); // id is 0 for new resources
        resourcesDAO.addResource(resource);
    }

    // Update an existing resource's information
    public void updateResource(int id, String name, String type, String status, String location, int quantity) throws SQLException {
        Resources resource = new Resources(id, name, type, status, location, quantity);
        resourcesDAO.updateResource(resource);
    }

    // Delete a resource by ID
    public void deleteResource(int id) throws SQLException {
        resourcesDAO.deleteResource(id);
    }

    // Get a resource by ID
    public Resources getResourceById(int id) throws SQLException {
        return resourcesDAO.getResourceById(id);
    }

    // Get all resources
    public List<Resources> getAllResources() throws SQLException {
        return resourcesDAO.getAllResources();
    }
}
