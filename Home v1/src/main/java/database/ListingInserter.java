package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ListingInserter {
    private static final String URL = "jdbc:mysql://localhost:3306/final_project";
    private static final String USER = "root";
    private static final String PASSWORD = "rdmm..rdmm123";

    public static void main(String[] args) {
        try {
            // Establish connection to the MySQL database
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Prepare an SQL INSERT statement for the 'property_types' table
            String sql = "INSERT INTO final_project.listing(listing_id, city_id,category_id,agent_id,offer_id,type_id,bedrooms,bathrooms,square_footage,price,Document_id) VALUES (?, ?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Set the values for the parameters in the SQL statement
            pstmt.setInt(1, 7); // Assuming type_id is an integer and you want to insert 1
            pstmt.setInt(2,4);
            pstmt.setInt(3, 4);
            pstmt.setInt(4, 4);
            pstmt.setInt(5, 2);
            pstmt.setInt(6, 4);
            pstmt.setInt(7, 12);
            pstmt.setInt(8, 8);
            pstmt.setString(9, "190 sq.ft");
            pstmt.setString(10, "$762726");
            pstmt.setInt(11, 4);
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
