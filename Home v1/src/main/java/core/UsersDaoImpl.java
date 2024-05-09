package core;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;
public class UsersDaoImpl implements UserDao{
	private DatabaseConnection dbConnection;

    public UsersDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM final_project.user";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String registration_date = rs.getString("registration_date");
                String phone_number = rs.getString("phone_number");
                String address = rs.getString("address");
                users.add(new User(user_id,username,email,password,registration_date,phone_number,address));
            }
        } catch (SQLException e) {
        	// Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        
    }
        return users;
    }
    
}
