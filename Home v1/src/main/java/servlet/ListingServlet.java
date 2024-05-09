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

import core.Listing;
import core.ListingDao;
import core.ListingDaoImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/listings")
public class ListingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ListingDao listingDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/final_project", "root", "rdmm..rdmm123");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        listingDao = new ListingDaoImpl(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Listing> listings = listingDao.getAllListings();
            System.out.println("Number of listings: " + listings.size());
            for (Listing listing : listings) {
                System.out.println("Listing ID: " + listing.getListing_id());
                System.out.println("City ID: " + listing.getCity_id());
                System.out.println("Category ID: " + listing.getCategory_id());
                System.out.println("Agent ID: " + listing.getAgent_id());
                System.out.println("Offer ID: " + listing.getOffer_id());
                System.out.println("Type ID: " + listing.getType_id());
                System.out.println("Document ID: " + listing.getDocument_id());
                System.out.println("Bedrooms: " + listing.getBedrooms());
                System.out.println("Bathrooms: " + listing.getBathrooms());
                System.out.println("Square Footage: " + listing.getSquare_footage());
                System.out.println("Price: " + listing.getPrice());
            }
            request.setAttribute("listings", listings);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Listing.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Error accessing the database");
            // Add a redirect to the JSP page
            response.sendRedirect("Listing.jsp");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Unexpected error occurred");
            // Add a redirect to the JSP page
            response.sendRedirect("Listing.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
