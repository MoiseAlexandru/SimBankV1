import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;

public class TransactionRepository {

    public static Transaction findTransactionById(String transactionId) {
        try {
            String sql = "SELECT * FROM CARD WHERE transactionId = ?";
            PreparedStatement statement = DatabaseConnection.connection.prepareStatement(sql);
            statement.setString(1, transactionId);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                String senderAccount = result.getString("senderAccount");
                String receiverAccount = result.getString("receiverAccount");
                double amount = result.getDouble("amount");
                Date transactionDate = result.getDate("transactionDate");
                String description = result.getString("description");
                int transactionType = result.getInt("transactionType");
                String status = result.getString("status");
                Transaction returnedTransaction = new Transaction(transactionId, senderAccount, receiverAccount, amount, transactionDate, description, transactionType, status);
                System.out.println("Transaction with id " + transactionId + " found");
                return returnedTransaction;
            }
            System.out.println("Transaction with id " + transactionId + " was not found");
            return null;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateTransactionStatus(String transactionId, String newStatus) {
        Transaction transaction = findTransactionById(transactionId);
        if(transaction == null) {
            System.out.println("Could not find the transaction.");
            return;
        }
        try {
            transaction.updateStatus(newStatus);
            String sql = "UPDATE TRANSACTION SET description = ?, transactionStatus = ? WHERE transactionId = ?";
            PreparedStatement statement = DatabaseConnection.connection.prepareStatement(sql);
            statement.setString(1, transaction.getDescription());
            statement.setString(2, transaction.getStatus());
            statement.setString(3, transactionId);
            statement.executeUpdate();
            System.out.println("Transaction with id " + transaction.getTransactionId() + " updated successfully");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void addTransaction(Transaction transaction) {
        try {
            String sql = "INSERT INTO TRANSACTION(transactionId, senderAccount, receiverAccount, amount, transactionDate, description, transactionType, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = DatabaseConnection.connection.prepareStatement(sql);
            statement.setString(1, transaction.getTransactionId());
            statement.setString(2, transaction.getSenderId());
            statement.setString(3, transaction.getReceiverId());
            statement.setDouble(4, transaction.getAmount());
            statement.setDate(5, new java.sql.Date(transaction.getTransactionDate().getTime()));
            statement.setString(6, transaction.getDescription());
            statement.setInt(7, transaction.getType());
            statement.setString(8, transaction.getStatus());
            statement.executeUpdate();
            System.out.println("Transaction with id " + transaction.getTransactionId() + " updated successfully");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
