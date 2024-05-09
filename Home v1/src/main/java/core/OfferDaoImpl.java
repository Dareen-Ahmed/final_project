package core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.DataAccessException;
import database.DatabaseConnection;

public class OfferDaoImpl implements OfferDao {
	private DatabaseConnection dbConnection;

    public OfferDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Offer> getAllOffers(){
        List<Offer> offers = new ArrayList<>();
        String sql = "SELECT * FROM final_project.offer";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            
            while (rs.next()) {
                int offer_id = rs.getInt("offer_id");
                String offer_description = rs.getString("offer_description");
                offers.add(new Offer(offer_id,offer_description));
            }
        } catch (SQLException e) {
        	// Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        
    }
        return offers;
    }
}