package core;
import java.util.List;
public interface TransactionDao {
	List<Transaction> getAllTransactions() throws Exception;
}
