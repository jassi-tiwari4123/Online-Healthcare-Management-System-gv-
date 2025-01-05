package com.healthcare.controller;

import com.healthcare.dao.ResourcesDAO;
import com.healthcare.model.Resources;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/resources")
public class ResourceController extends HttpServlet {
    /*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResourcesDAO resourcesDAO;

    @Override
    public void init() throws ServletException {
        // Initialize ResourcesDAO with a database connection
        Connection connection = (Connection) getServletContext().getAttribute("DB_CONNECTION");
        resourcesDAO = new ResourcesDAO(connection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                // Show the form for adding new resources
                request.getRequestDispatcher("/addResource.jsp").forward(request, response);
                break;
            case "update":
                // Show the form to update a resource
                int id = Integer.parseInt(request.getParameter("id"));
                try {
                    Resources resource = resourcesDAO.getResourceById(id);
                    request.setAttribute("resource", resource);
                    request.getRequestDispatcher("/updateResource.jsp").forward(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                // Delete a resource
                try {
                    int resourceId = Integer.parseInt(request.getParameter("id"));
                    resourcesDAO.deleteResource(resourceId);
                    response.sendRedirect("resources?action=view");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "view":
                // Show all resources
                try {
                    List<Resources> resourcesList = resourcesDAO.getAllResources();
                    request.setAttribute("resourcesList", resourcesList);
                    request.getRequestDispatcher("/viewAllResources.jsp").forward(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                // Show the default page
                request.getRequestDispatcher("/viewAllResources.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                // Handle adding new resource
                addResource(request, response);
                break;
            case "update":
                // Handle updating existing resource
                updateResource(request, response);
                break;
            default:
                // Redirect to the default view page
                response.sendRedirect("resources?action=view");
                break;
        }
    }

    private void addResource(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String status = request.getParameter("status");
        String location = request.getParameter("location");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Resources newResource = new Resources(0, name, type, status, location, quantity);

        try {
            resourcesDAO.addResource(newResource);
            response.sendRedirect("resources?action=view");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateResource(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String status = request.getParameter("status");
        String location = request.getParameter("location");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Resources updatedResource = new Resources(id, name, type, status, location, quantity);

        try {
            resourcesDAO.updateResource(updatedResource);
            response.sendRedirect("resources?action=view");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
