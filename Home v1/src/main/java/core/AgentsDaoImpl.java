package core;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;
public class AgentsDaoImpl implements AgentDao{
	private DatabaseConnection dbConnection;

    public AgentsDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Agent> getAllAgents(){
        List<Agent> agents = new ArrayList<>();
        String sql = "SELECT *FROM final_project.agent";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            
            while (rs.next()) {
                int agentId = rs.getInt("agentId");
                String agentName = rs.getString("agentName");
                String contactInformation = rs.getString("contactInformation");
                String email = rs.getString("email");
                agents.add(new Agent(agentId,agentName,contactInformation,email));
            }
        } catch (SQLException e) {
        	// Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        
    }
        return agents;
    }
    
}
