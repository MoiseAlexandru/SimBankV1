public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
    public InsufficientFundsException(String message, Exception err) {
        super(message, err);
    }
}
