package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DataAccessException;
import database.DatabaseConnection;

public class CitiesDaoImpl implements CityDao{
	private DatabaseConnection dbConnection;

    public CitiesDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<City> getAllCities(){
        List<City> cities = new ArrayList<>();
        String sql = "SELECT * FROM final_project.city";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            
            while (rs.next()) {
                int cityId = rs.getInt("cityId");
                String cityName = rs.getString("cityName");
                cities.add(new City(cityId,cityName));
            }
        } catch (SQLException e) {
        	// Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        
    }
        return cities;
    }
}
