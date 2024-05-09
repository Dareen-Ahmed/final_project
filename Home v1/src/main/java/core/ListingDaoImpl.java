package core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.DataAccessException;
import database.DatabaseConnection;

public class ListingDaoImpl implements ListingDao {
    private DatabaseConnection dbConnection;

    public ListingDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Listing> getAllListings() throws DataAccessException {
        List<Listing> listings = new ArrayList<>();
        String sql = "SELECT * FROM final_project.listing";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            
            while (rs.next()) {
                int listing_id = rs.getInt("listing_id");
                int city_id = rs.getInt("city_id");
                int category_id = rs.getInt("category_id");
                int agent_id = rs.getInt("agent_id");
                int offer_id = rs.getInt("offer_id");
                int type_id = rs.getInt("type_id");
                int document_id = rs.getInt("document_id"); // Corrected variable name
                int bedrooms = rs.getInt("bedrooms");
                int bathrooms = rs.getInt("bathrooms");
                String square_footage = rs.getString("square_footage");
                String price = rs.getString("price");
                listings.add(new Listing(listing_id, city_id, category_id, agent_id,offer_id,type_id,document_id,bedrooms,bathrooms,square_footage,price));
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error accessing the database", e);
        }
        
        return listings;
    }
}

