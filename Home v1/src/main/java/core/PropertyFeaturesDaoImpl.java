package core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.DataAccessException;
import database.DatabaseConnection;

public class PropertyFeaturesDaoImpl implements PropertyFeaturesDao {
	private DatabaseConnection dbConnection;

    public PropertyFeaturesDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<PropertyFeatures> getAllPropertyFeatures(){
        List<PropertyFeatures> propertyfeatures = new ArrayList<>();
        String sql = "SELECT * FROM final_project.`property features`";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            
            while (rs.next()) {
                int feature_id = rs.getInt("feature_id");
                int listing_id = rs.getInt("listing_id");
                String feature_name = rs.getString("feature_name");
                String feature_value = rs.getString("feature_value");
                propertyfeatures.add(new PropertyFeatures(feature_id,listing_id,feature_name,feature_value));
            }
        } catch (SQLException e) {
        	// Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        
    }
        return propertyfeatures;
    }
}