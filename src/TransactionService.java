
public class TransactionService {
    TransactionRepository transactionRepository;
    AccountRepository accountRepository;
    public void createTransaction(int type, double amount, String accountId) throws IllegalArgumentException, InsufficientFundsException {
        Transaction transaction = new Transaction(type, amount, accountId);
        transactionRepository.addTransaction(transaction);
        String transactionId = transaction.getTransactionId();
        transactionRepository.updateTransactionStatus(transactionId, "pending");
        if(amount <= 0) {
            transactionRepository.updateTransactionStatus(transactionId, "canceled");
            throw new IllegalArgumentException("Transaction error: number specified must be positive!");
        }
    }
    public void processTransaction(Transaction transaction) throws IllegalArgumentException, InsufficientFundsException {
        if(transaction.getStatus() == "canceled" || transaction.getStatus() == "completed")
            throw new IllegalArgumentException("Cannot resolve transaction");
        int type = transaction.getType();
        String transactionId = transaction.getTransactionId();
        if(type == 2) { // alimentare cont
            try {
                accountRepository.addMoneyTo(transaction.getReceiverId(), transaction.getAmount());
                transactionRepository.updateTransactionStatus(transactionId, "completed");
            }
            catch(IllegalArgumentException err) {
                transactionRepository.updateTransactionStatus(transactionId, "failed");
                throw new IllegalArgumentException("Transaction error from processTransaction() of TransactionService", err);
            }
            return;
        }
        if(type == 1) { // scoatere bani din cont
            try {
                accountRepository.removeMoneyFrom(transaction.getSenderId(), transaction.getAmount());
                transactionRepository.updateTransactionStatus(transactionId, "completed");
            }
            catch(IllegalArgumentException err) {
                transactionRepository.updateTransactionStatus(transactionId, "failed");
                throw new IllegalArgumentException("Transaction error from processTransaction() of TransactionService", err);
            }
            catch(InsufficientFundsException err) {
                transactionRepository.updateTransactionStatus(transactionId, "failed");
                throw new InsufficientFundsException("Insufficient funds error from processTransaction() of TransactionService", err);
            }
            return;
        }
        if(type == 3) { // transfer bancar cont-cont
            try {
                accountRepository.transferBetweenAccounts(transaction.getSenderId(), transaction.getReceiverId(), transaction.getAmount());
                transactionRepository.updateTransactionStatus(transactionId, "completed");
            }
            catch(IllegalArgumentException err) {
                transactionRepository.updateTransactionStatus(transactionId, "failed");
                throw new IllegalArgumentException("Error while processing account to account tranfer", err);
            }
            catch(InsufficientFundsException err) {
                transactionRepository.updateTransactionStatus(transactionId, "failed");
                throw new InsufficientFundsException("Insufficient funds error from processTransaction()", err);
            }
        }
    }
}
