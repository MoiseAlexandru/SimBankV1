import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class User {
    protected String name;
    protected String address;
    protected String userId;
    protected Date userRegistrationDate;
    public User() {}
    public void updateAddress(String newAddress) {
        this.address = newAddress;
    }
}
