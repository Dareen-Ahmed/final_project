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

import core.Document;
import core.DocumentDao;
import core.DocumentsDaoImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/documents")
public class DocumentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DocumentDao documentDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/final_project", "root", "rdmm..rdmm123");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        documentDao = new DocumentsDaoImpl(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Document> documents = documentDao.getAllDocuments();
            System.out.println("Number of documents: " + documents.size());
            for (Document document : documents) {
                System.out.println("Document ID: " + document.getdocuments_id());
                System.out.println("Doccument Name: " + document.getdocuments_name());
                System.out.println("Document Description: " + document.getdocuments_description());
                System.out.println("Document Image: " + document.getdocuments_image());
            }
            request.setAttribute("documents", documents);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Document.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Error accessing the database");
            // Add a redirect to the JSP page
            response.sendRedirect("Document.jsp");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Unexpected error occurred");
            // Add a redirect to the JSP page
            response.sendRedirect("Document.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}