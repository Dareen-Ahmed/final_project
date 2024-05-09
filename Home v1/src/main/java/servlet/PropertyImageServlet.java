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

import core.PropertyImages;
import core.PropertyImageDao;
import core.PropertyImageDaoImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/propertyimages")
public class PropertyImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PropertyImageDao propertyImageDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/final_project", "root", "rdmm..rdmm123");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        propertyImageDao = new PropertyImageDaoImpl(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<PropertyImages> propertyImages = propertyImageDao.getAllPropertyImages();
            System.out.println("Number of property images: " + propertyImages.size());
            for (PropertyImages propertyImage : propertyImages) {
                System.out.println("Image ID: " + propertyImage.getImage_id());
                System.out.println("Listing ID: " + propertyImage.getListing_id());
                System.out.println("Image URL: " + propertyImage.getImage_url());
            }
            request.setAttribute("propertyImages", propertyImages);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PropertyImage.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Error accessing the database");
            // Add a redirect to the JSP page
            response.sendRedirect("PropertyImage.jsp");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Unexpected error occurred");
            // Add a redirect to the JSP page
            response.sendRedirect("PropertyImage.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
