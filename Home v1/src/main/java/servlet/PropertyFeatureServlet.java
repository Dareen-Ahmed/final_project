package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import core.PropertyFeatures;
import core.PropertyFeaturesDao;
import core.PropertyFeaturesDaoImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/propertyfeatures")
public class PropertyFeatureServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PropertyFeaturesDao propertyfeatureDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/final_project", "root", "rdmm..rdmm123");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        propertyfeatureDao = new PropertyFeaturesDaoImpl(dbConnection);
    }

  
    	@Override
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	    try {
    	        List<PropertyFeatures> propertyfeatures = propertyfeatureDao.getAllPropertyFeatures();
    	        System.out.println("Number of propertyfeatures: " + propertyfeatures.size());
    	        for (PropertyFeatures propertyfeature : propertyfeatures) {
    	            System.out.println("Feature ID: " + propertyfeature.getFeature_id());
    	            System.out.println("Listing ID: " + propertyfeature.getListing_id());
    	            System.out.println("Feature Name: " + propertyfeature.getFeature_name());
    	            System.out.println("Feature Value: " + propertyfeature.getFeature_value());
    	        }
    	        request.setAttribute("propertyfeatures", propertyfeatures);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("PropertyFeatures.jsp");
    	        dispatcher.forward(request, response);
    	    } catch (SQLException e) {
    	        // Log the exception
    	        e.printStackTrace();
    	        // Set an error message
    	        request.setAttribute("errorMessage", "Error accessing the database");
    	        // Add a redirect to the JSP page
    	        response.sendRedirect("PropertyFeatures.jsp");
    	    } catch (Exception e) {
    	        // Log the exception
    	        e.printStackTrace();
    	        // Set an error message
    	        request.setAttribute("errorMessage", "Unexpected error occurred");
    	        // Add a redirect to the JSP page
    	        response.sendRedirect("PropertyFeatures.jsp");
    	    }
    	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

