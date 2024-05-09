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

import core.PropertyTypes;
import core.PropertyTypesDao;
import core.PropertyTypesDaoImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/propertytypes")
public class PropertyTypesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PropertyTypesDao propertytypeDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/final_project", "root", "rdmm..rdmm123");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        propertytypeDao = new PropertyTypesDaoImpl(dbConnection);
    }

  
    	@Override
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	    try {
    	        List<PropertyTypes> propertytypes = propertytypeDao.getAllPropertyTypes();
    	        System.out.println("Number of propertytypes: " + propertytypes.size());
    	        for (PropertyTypes propertytype : propertytypes) {
    	            System.out.println("PropertyType ID: " + propertytype.gettype_id());
    	            System.out.println("PropertyType Name: " + propertytype.gettype_name());
    	        }
    	        request.setAttribute("propertytypes", propertytypes);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("PropertyTypes.jsp");
    	        dispatcher.forward(request, response);
    	    } catch (SQLException e) {
    	        // Log the exception
    	        e.printStackTrace();
    	        // Set an error message
    	        request.setAttribute("errorMessage", "Error accessing the database");
    	        // Add a redirect to the JSP page
    	        response.sendRedirect("PropertyTypes.jsp");
    	    } catch (Exception e) {
    	        // Log the exception
    	        e.printStackTrace();
    	        // Set an error message
    	        request.setAttribute("errorMessage", "Unexpected error occurred");
    	        // Add a redirect to the JSP page
    	        response.sendRedirect("PropertyTypes.jsp");
    	    }
    	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

