package core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.DataAccessException;
import database.DatabaseConnection;

public class PropertyTypesDaoImpl implements PropertyTypesDao {
	private DatabaseConnection dbConnection;

    public PropertyTypesDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<PropertyTypes> getAllPropertyTypes(){
        List<PropertyTypes> propertytypes = new ArrayList<>();
        String sql = "SELECT * FROM final_project.`property types`";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            
            while (rs.next()) {
                int type_id = rs.getInt("type_id");
                String type_name = rs.getString("type_name");
                propertytypes.add(new PropertyTypes(type_id,type_name));
            }
        } catch (SQLException e) {
        	// Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        
    }
        return propertytypes;
    }
}