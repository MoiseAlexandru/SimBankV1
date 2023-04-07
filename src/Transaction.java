import java.util.Date;
import java.util.UUID;

public class Transaction {
    String transactionId;
    String senderAccount;
    String receiverAccount;
    double amount;
    Date transactionDate;
    String description;
    int transactionType;
    // Tip 1: retragere bani
    // Tip 2: alimenentare cont
    // Tip 3: intre doua conturi
    Transaction() {}
    Transaction(int type, double amount, String account) {
        this.transactionId = UUID.randomUUID().toString();
        this.transactionDate = new Date();
        this.amount = amount;
        this.transactionType = type;
        if(type == 1) {
            this.description = "Retragere din cont";
            this.senderAccount = account;
            this.receiverAccount = null;
        }
        if(type == 2) {
            this.senderAccount = null;
            this.receiverAccount = account;
            this.description = "Alimentare cont";
        }
    }
    Transaction(double amount, String senderId, String receiverId, String description) {
        this.transactionId = UUID.randomUUID().toString();
        this.transactionDate = new Date();
        this.senderAccount = senderId;
        this.receiverAccount = receiverId;
        this.amount = amount;
        this.transactionType = 3;
        this.description = description;
    }
}
