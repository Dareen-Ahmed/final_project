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

import core.Agent;
import core.AgentDao;
import core.AgentsDaoImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/agents")
public class AgentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AgentDao agentDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/final_project", "root", "rdmm..rdmm123");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        agentDao = new AgentsDaoImpl(dbConnection);
    }

  
    	@Override
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	    try {
    	        List<Agent> agents = agentDao.getAllAgents();
    	        System.out.println("Number of agents: " + agents.size());
    	        for (Agent agent : agents) {
    	            System.out.println("Agent ID: " + agent.getAgentId());
    	            System.out.println("Agent Name: " + agent.getAgentName());
    	            System.out.println("Contact Information: " + agent.getContactInformation());
    	            System.out.println("Email: " + agent.getEmail());
    	        }
    	        request.setAttribute("agents", agents);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("Agent.jsp");
    	        dispatcher.forward(request, response);
    	    } catch (SQLException e) {
    	        // Log the exception
    	        e.printStackTrace();
    	        // Set an error message
    	        request.setAttribute("errorMessage", "Error accessing the database");
    	        // Add a redirect to the JSP page
    	        response.sendRedirect("Agent.jsp");
    	    } catch (Exception e) {
    	        // Log the exception
    	        e.printStackTrace();
    	        // Set an error message
    	        request.setAttribute("errorMessage", "Unexpected error occurred");
    	        // Add a redirect to the JSP page
    	        response.sendRedirect("Agent.jsp");
    	    }
    	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
