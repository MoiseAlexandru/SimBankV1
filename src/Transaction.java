import java.util.Date;
import java.util.UUID;

public class Transaction {
    private String transactionId;
    private String senderAccount;
    private String receiverAccount;
    private double amount;
    private Date transactionDate;
    private String description;
    private int transactionType;
    // Tip 1: retragere bani
    // Tip 2: alimenentare cont
    // Tip 3: intre doua conturi
    private String status; // pending, completed, failed, canceled
    public Transaction() {}
    public Transaction(int type, double amount, String account) {
        this.transactionId = UUID.randomUUID().toString();
        this.transactionDate = new Date();
        this.amount = amount;
        this.transactionType = type;
        this.status = "Pending";
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
    public Transaction(double amount, String senderId, String receiverId, String description) {
        this.transactionId = UUID.randomUUID().toString();
        this.transactionDate = new Date();
        this.senderAccount = senderId;
        this.receiverAccount = receiverId;
        this.amount = amount;
        this.transactionType = 3;
        this.description = description;
        this.status = "Pending";
    }
    public String getStatus() {
        return this.status;
    }
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }
}
