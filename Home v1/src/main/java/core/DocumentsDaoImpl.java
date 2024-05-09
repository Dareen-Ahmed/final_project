package core;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DataAccessException;
import database.DatabaseConnection;

public class DocumentsDaoImpl implements DocumentDao{
    private DatabaseConnection dbConnection;

    public DocumentsDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Document> getAllDocuments(){
        List<Document> documents = new ArrayList<>();
        String sql = "SELECT * FROM final_project.document";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int documents_id = rs.getInt("documents_id");
                String documents_name = rs.getString("documents_name");
                String documents_description = rs.getString("documents_description");
                String documents_image = rs.getString("documents_image");
                documents.add(new Document(documents_id,documents_name,documents_description,documents_image));
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);

        }
        return documents;
    }
}