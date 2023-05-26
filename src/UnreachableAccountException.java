public class UnreachableAccountException extends Exception {
    public UnreachableAccountException(String message) {
        super(message);
    }
    public UnreachableAccountException(String message, Exception err) {
        super(message, err);
    }
}
