public class CheckingAccount extends Account {
    private int minBalanceAlert;
    private int dailyWithdrawLimit;
    private double monthlyMaintenanceFee;
    private String ownerId;
    public CheckingAccount() {
        this.minBalanceAlert = 0;
        this.dailyWithdrawLimit = 1000;
    }
    public CheckingAccount(String IBAN, String userId, int minBalanceAlert, int withdrawDailyLimit) {
        super(IBAN, userId);
        this.minBalanceAlert = minBalanceAlert;
        this.dailyWithdrawLimit = withdrawDailyLimit;
        this.ownerId = userId;
    }
    public void updateMinBalanceAlert(int newMinBalanceAlert) {
        this.minBalanceAlert = newMinBalanceAlert;
    }
    public void updateDailyWithdrawLimit(int newDailyWithdrwawLimit) {
        this.dailyWithdrawLimit = newDailyWithdrwawLimit;
    }
    public int getMinBalanceAlert() {
        return this.getMinBalanceAlert();
    }
    public int getDailyWithdrawLimit() {
        return this.getDailyWithdrawLimit();
    }
}
