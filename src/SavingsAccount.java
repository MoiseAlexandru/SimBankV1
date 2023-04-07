public class SavingsAccount extends Account{
    private int maxWithdawals; // number of withdrawals in a month
    private double interestRate;
    public SavingsAccount() {
        maxWithdawals = 2;
        interestRate = 10;
    };
    public SavingsAccount(String IBAN, String ownerId, int maxWithdawals, int interestRate) {
        super(IBAN, ownerId);
        this.maxWithdawals = maxWithdawals;
        this.interestRate = interestRate;
    }
    public double calculateMonthlyGain() {
        double monthlyInterestRate = interestRate / 12;
        return balance * monthlyInterestRate;
    }
    public double getMaxWithdrawals() {
        return maxWithdawals;
    }
}
