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

import core.Offer;
import core.OfferDao;
import core.OfferDaoImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/offers")
public class OfferServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OfferDao offerDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/final_project", "root", "rdmm..rdmm123");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        offerDao = new OfferDaoImpl(dbConnection);
    }

  
    	@Override
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	    try {
    	        List<Offer> offers = offerDao.getAllOffers();
    	        System.out.println("Number of offers: " + offers.size());
    	        for (Offer offer : offers) {
    	            System.out.println("Offer ID: " + offer.getOffer_id());
    	            System.out.println("Offer Description: " + offer.getOffer_description());
    	        }
    	        request.setAttribute("offers", offers);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("Offer.jsp");
    	        dispatcher.forward(request, response);
    	    } catch (SQLException e) {
    	        // Log the exception
    	        e.printStackTrace();
    	        // Set an error message
    	        request.setAttribute("errorMessage", "Error accessing the database");
    	        // Add a redirect to the JSP page
    	        response.sendRedirect("Offer.jsp");
    	    } catch (Exception e) {
    	        // Log the exception
    	        e.printStackTrace();
    	        // Set an error message
    	        request.setAttribute("errorMessage", "Unexpected error occurred");
    	        // Add a redirect to the JSP page
    	        response.sendRedirect("Offer.jsp");
    	    }
    	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
