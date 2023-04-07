public class AccountRepository {
    public Account getAccountByIBAN(String IBAN) {
        for(Account account : DataStorage.Accounts)
            if(account.getAccountId() == IBAN)
                return account;
        return null;
    }
    public void addAccount(Account account) throws IllegalArgumentException {
        if(getAccountByIBAN(account.getAccountId()) != null)
            throw new IllegalArgumentException("Error in function addAccount from class AccountRepository, account already exists");
        DataStorage.Accounts.add(account);
    }
}
