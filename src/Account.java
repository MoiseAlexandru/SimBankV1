import java.util.Date;

public class Account {
    protected String IBAN;
    protected double balance;
    protected Date accountCreationDate;
    protected boolean activeStatus;
    protected String ownerId;
    public Account() {}
    public Account(String ownerId) {
        this.IBAN = Utils.generateRandomIBAN();
        this.ownerId = ownerId;
        this.activeStatus = false;
        this.accountCreationDate = new Date();
        balance = 0;
    }
    public double getBalance() {
        return balance;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public String getAccountId() {
        return IBAN;
    }
    public boolean getActiveStatus() {
        return activeStatus;
    }
    public void updateAccountStatus(boolean newActiveStatus) {
        this.activeStatus = newActiveStatus;
    }
    public void updateBalance(double newBalance) {
        this.balance = newBalance;
    }
}
