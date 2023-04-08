public class TransactionRepository {

    public Transaction findTransactionById(String transactionId) {
        for(Transaction transaction : DataStorage.Transactions)
            if(transaction.getTransactionId().equals(transactionId))
                return transaction;
        return null;
    }
    public void updateTransactionStatus(String transactionId, String newStatus) throws IllegalArgumentException {
        for(Transaction transaction : DataStorage.Transactions) {
            if(transaction.getTransactionId().equals(transactionId)) {
                transaction.updateStatus(newStatus);
                return;
            }
        }
        throw new IllegalArgumentException("Transaction not found");
    }
    public void addTransaction(Transaction transaction) throws  IllegalArgumentException {
        if(findTransactionById(transaction.getTransactionId()) != null)
            throw new IllegalArgumentException("Transaction already exists in the database!");
    }
}
