package com.healthcare.dao;

import com.healthcare.model.Resources;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResourcesDAO {
    private Connection connection;

    public ResourcesDAO(Connection connection) {
        this.connection = connection;
    }

    public void addResource(Resources resource) throws SQLException {
        String sql = "INSERT INTO resources (name, type, status, location, quantity) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, resource.getName());
            statement.setString(2, resource.getType());
            statement.setString(3, resource.getStatus());
            statement.setString(4, resource.getLocation());
            statement.setInt(5, resource.getQuantity());
            statement.executeUpdate();
        }
    }

    public void updateResource(Resources resource) throws SQLException {
        String sql = "UPDATE resources SET name = ?, type = ?, status = ?, location = ?, quantity = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, resource.getName());
            statement.setString(2, resource.getType());
            statement.setString(3, resource.getStatus());
            statement.setString(4, resource.getLocation());
            statement.setInt(5, resource.getQuantity());
            statement.setInt(6, resource.getId());
            statement.executeUpdate();
        }
    }

    public void deleteResource(int id) throws SQLException {
        String sql = "DELETE FROM resources WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public Resources getResourceById(int id) throws SQLException {
        String sql = "SELECT * FROM resources WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Resources(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("type"),
                    resultSet.getString("status"),
                    resultSet.getString("location"),
                    resultSet.getInt("quantity")
                );
            }
        }
        return null; // If no resource found
    }

    public List<Resources> getAllResources() throws SQLException {
        List<Resources> resources = new ArrayList<>();
        String sql = "SELECT * FROM resources";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Resources resource = new Resources(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("type"),
                    resultSet.getString("status"),
                    resultSet.getString("location"),
                    resultSet.getInt("quantity")
                );
                resources.add(resource);
            }
        }
        return resources;
    }
}
