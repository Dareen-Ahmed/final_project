package core;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DataAccessException;
import database.DatabaseConnection;

public class CategoriesDaoImpl implements CategoryDao{
	private DatabaseConnection dbConnection;

    public CategoriesDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM final_project.category";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            
            while (rs.next()) {
                int categoryId = rs.getInt("categoryId");
                String categoryName = rs.getString("categoryName");
               
                categories.add(new Category(categoryId,categoryName));
            }
        } catch (SQLException e) {
        	// Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        
    }
        return categories;
    }
}
