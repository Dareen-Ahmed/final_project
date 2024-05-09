package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;

public class TransactionDaoImpl implements TransactionDao {
    private DatabaseConnection dbConnection;

    public TransactionDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Transaction> getAllTransactions() throws Exception {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM final_project.transaction";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int transaction_id = rs.getInt("transaction_id");
                int listing_id = rs.getInt("listing_id");
                int buyer_id = rs.getInt("buyer_id");
                int seller_id = rs.getInt("seller_id");
                String transaction_date = rs.getString("transaction_date");
                String transaction_amount = rs.getString("transaction_amount");
                transactions.add(new Transaction(transaction_id, listing_id, buyer_id, seller_id, transaction_date, transaction_amount));
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return transactions;
    }
}