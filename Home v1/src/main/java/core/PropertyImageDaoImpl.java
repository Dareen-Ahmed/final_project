package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;

public class PropertyImageDaoImpl implements PropertyImageDao {
    private DatabaseConnection dbConnection;

    public PropertyImageDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<PropertyImages> getAllPropertyImages() throws Exception {
        List<PropertyImages> propertyImages = new ArrayList<>();
        String sql = "SELECT * FROM final_project.`property images`";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int imageId = rs.getInt("image_id");
                int listingId = rs.getInt("listing_id");
                String imageUrl = rs.getString("image_url");
                propertyImages.add(new PropertyImages(imageId, listingId, imageUrl));
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return propertyImages;
    }
}