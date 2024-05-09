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

import core.User;
import core.UserDao;
import core.UsersDaoImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    // Initialize the servlet
    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/final_project", "root", "rdmm..rdmm123");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        userDao = new UsersDaoImpl(dbConnection);
    }

    // Handle GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve all users from the database
            List<User> users = userDao.getAllUsers();

            // Print user details to the console
            System.out.println("Number of users: " + users.size());
            for (User user : users) {
                System.out.println("User ID: " + user.getUser_id());
                System.out.println("User Name: " + user.getUsername());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Password: " + user.getPassword());
                System.out.println("Registration Date : " + user.getRegistration_date());
                System.out.println("Phone Number : " + user.getPhone_number());
                System.out.println("Address : " + user.getAddress());
            }

            // Set users as a request attribute and forward to User.jsp for display
            request.setAttribute("users", users);
            RequestDispatcher dispatcher = request.getRequestDispatcher("User.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Error accessing the database");
            // Redirect to the JSP page with error message
            response.sendRedirect("User.jsp");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Unexpected error occurred");
            // Redirect to the JSP page with error message
            response.sendRedirect("User.jsp");
        }
    }

    // Handle POST requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delegate to doGet() method for POST requests
        doGet(request, response);
    }
}
