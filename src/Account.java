import java.util.Date;

public class Account {
    protected String IBAN;
    protected double balance;
    protected Date accountCreationDate;
    protected boolean activeStatus;
    protected String ownerId;
    Account() {}
    Account(String IBAN, String ownerId) {
        this.IBAN = IBAN;
        this.ownerId = ownerId;
        this.activeStatus = false;
        this.accountCreationDate = new Date();
        balance = 0;
    }
    double getBalance() {
        return balance;
    }
    String getOwnerId() {
        return ownerId;
    }
    String getAccountId() {
        return IBAN;
    }
    boolean getActiveStatus() {
        return activeStatus;
    }
    void updateAccountStatus(boolean newActiveStatus) {
        this.activeStatus = newActiveStatus;
    }
    void updateBalance(double newBalance) {
        this.balance = newBalance;
    }
}
