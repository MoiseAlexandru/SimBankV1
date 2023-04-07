import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class User {
    protected String name;
    protected String address;
    protected String userId;
    protected Date userRegistrationDate;
    public User() {}
    public User(String name, String address) {
        this.name = name;
        this.address = address;
        this.userId = UUID.randomUUID().toString();
        this.userRegistrationDate = new Date();
    }
    public void updateAddress(String newAddress) {
        this.address = newAddress;
    }
}
