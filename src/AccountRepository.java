public class AccountRepository {
    public Account getAccountByIBAN(String IBAN) {
        for(Account account : DataStorage.Accounts)
            if(account.getAccountId().equals(IBAN))
                return account;
        return null;
    }
    public void addAccount(Account account) throws IllegalArgumentException {
        if(getAccountByIBAN(account.getAccountId()) != null)
            throw new IllegalArgumentException("Error in function addAccount from class AccountRepository, account already exists");
        DataStorage.Accounts.add(account);
    }
    public void removeMoneyFrom(String accountId, double amount) throws IllegalArgumentException, InsufficientFundsException {
        Account account = getAccountByIBAN(accountId);
        if(account == null)
            throw new IllegalArgumentException("User account does not exist");
        if(account.getBalance() < amount)
            throw new InsufficientFundsException("Insufficient funds on this account");
        double newBalance = account.getBalance() - amount;
        account.updateBalance(newBalance);
    }
    public void addMoneyTo(String accountId, double amount) throws IllegalArgumentException {
        Account account = getAccountByIBAN(accountId);
        if(account == null)
            throw new IllegalArgumentException("User account does not exist");
        double newBalance = account.getBalance() + amount;
        account.updateBalance(newBalance);
    }
    public void transferBetweenAccounts(String senderId, String receiverId, double amount) throws IllegalArgumentException, InsufficientFundsException {
        Account sender = getAccountByIBAN(senderId);
        Account receiver = getAccountByIBAN(receiverId);
        if(sender == null && receiver == null)
            throw new IllegalArgumentException("Accounts have not been found in the database");
        if(sender != null && receiver != null) { // ambele conturi sunt din banca mea
            try {
                this.removeMoneyFrom(senderId, amount);
                this.addMoneyTo(receiverId, amount);
            }
            catch(InsufficientFundsException err) {
                throw new InsufficientFundsException("Sender account does not have enough funds!", err);
            }
            return;
        }
        if(sender != null) { // trimit catre cineva din afara bancii
            try {
                this.removeMoneyFrom(senderId, amount);
            }
            catch(InsufficientFundsException err) {
                throw new InsufficientFundsException("Sender account does not have enough funds!", err);
            }
            return;
        }
        // daca am ajuns aici, e cazul in care un cont din afara bancii trimite catre un cont din interiorul bancii
        this.addMoneyTo(receiverId, amount);
    }
}
