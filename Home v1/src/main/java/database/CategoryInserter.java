package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryInserter {
    private static final String URL = "jdbc:mysql://localhost:3306/final_project";
    private static final String USER = "root";
    private static final String PASSWORD = "rdmm..rdmm123";

    public static void main(String[] args) {
        try {
            // Establish connection to the MySQL database
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Prepare an SQL INSERT statement for the 'property_types' table
            String sql = "INSERT INTO final_project.category (categoryId, categoryName) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Set the values for the parameters in the SQL statement
            pstmt.setInt(1, 6); // Assuming type_id is an integer and you want to insert 1
            pstmt.setString(2, "Therapeutic");
            
            
            // Execute the INSERT statement
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            
            // Close the connection and statement
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Insertion failed. Error: " + e.getMessage());
        }
    }
}
