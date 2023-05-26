public class CheckingAccount extends Account {
    private int minBalanceAlert;
    private int dailyWithdrawLimit;
    private double monthlyMaintenanceFee;
    public CheckingAccount() {
        this.minBalanceAlert = 0;
        this.dailyWithdrawLimit = 1000;
    }
    public CheckingAccount(String userId) {
        super(userId);
        this.minBalanceAlert = 0;
        this.dailyWithdrawLimit = 1000;
        this.monthlyMaintenanceFee = 1;
    }
    public void updateMinBalanceAlert(int newMinBalanceAlert) {
        this.minBalanceAlert = newMinBalanceAlert;
    }
    public void updateDailyWithdrawLimit(int newDailyWithdrawLimit) {
        this.dailyWithdrawLimit = newDailyWithdrawLimit;
    }
    public int getMinBalanceAlert() {
        return this.getMinBalanceAlert();
    }
    public int getDailyWithdrawLimit() {
        return this.getDailyWithdrawLimit();
    }
}
