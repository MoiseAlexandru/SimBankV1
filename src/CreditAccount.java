public class CreditAccount extends Account {
    private int loanAmount;
    private double maxCreditGain;
    private double interestRate; // interest per year
    private int duration; // duration of the loan
    public CreditAccount() {}
    public CreditAccount(String IBAN, String userId, int loan, double maxCreditGain, double interestRate, int duration) {
        super(IBAN, userId);
        this.loanAmount = loan;
        this.maxCreditGain = maxCreditGain;
        this.interestRate = interestRate;
        this.duration = duration;
    }
    public double calculateMonthlyPayment(int currentMonth) {
        double monthlyInterestRate = interestRate / 12;
        double numerator = loanAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, duration));
        double denominator = Math.pow(1 + monthlyInterestRate, duration) - 1;
        double payment = numerator / denominator;
        double balanceForInterest = loanAmount - (payment * (currentMonth - 1));
        double interest = balanceForInterest * monthlyInterestRate;
        return payment + interest;
    }
}
