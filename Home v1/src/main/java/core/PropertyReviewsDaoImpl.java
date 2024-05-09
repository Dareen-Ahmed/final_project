package core;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;

public class PropertyReviewsDaoImpl implements PropertyReviewsDao {
    private DatabaseConnection dbConnection;

    public PropertyReviewsDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<PropertyReviews> getAllPropertyReviews() throws DataAccessException {
        List<PropertyReviews> propertyReviews = new ArrayList<>();
        String sql = "SELECT * FROM final_project.`property reviews`";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int review_id = rs.getInt("review_id");
                int listing_id = rs.getInt("listing_id");
                int user_id = rs.getInt("user_id");
                String rating = rs.getString("rating");
                String review_text = rs.getString("review_text");
                String review_date = rs.getString("review_date");

                PropertyReviews propertyReview = new PropertyReviews(review_id, listing_id, user_id, rating, review_text, review_date);
                propertyReviews.add(propertyReview);
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return propertyReviews;
    }
}