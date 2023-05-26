import java.util.Date;

public class DbRequest {
    public String actionName;
    public Date timestamp;
    public DbRequest(String actionName, Date timestamp) {
        this.actionName = actionName;
        this.timestamp = timestamp;
    }
}
