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

import core.Transaction;
import core.TransactionDao;
import core.TransactionDaoImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/transactions")
public class TransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TransactionDao transactionDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/final_project", "root", "rdmm..rdmm123");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        transactionDao = new TransactionDaoImpl(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Transaction> transactions = transactionDao.getAllTransactions();
            System.out.println("Number of transactions: " + transactions.size());
            for (Transaction transaction : transactions) {
                System.out.println("Transaction ID: " + transaction.getTransaction_id());
                System.out.println("Property ID: " + transaction.getListing_id());
                System.out.println("Buyer ID: " + transaction.getBuyer_id());
                System.out.println("Seller ID: " + transaction.getSeller_id());
                System.out.println("Transaction Date: " + transaction.getTransaction_date());
                System.out.println("Transaction Amount: " + transaction.getTransaction_amount());
            }
            request.setAttribute("transactions", transactions);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Transaction.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Error accessing the database");
            // Add a redirect to the JSP page
            response.sendRedirect("Transaction.jsp");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Unexpected error occurred");
            // Add a redirect to the JSP page
            response.sendRedirect("Transaction.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
