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
    public String getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public void displayUser() {
        System.out.println("name: " + name + ", address: " + address + ", userId: " + userId + ", userRegistrationDate: " + userRegistrationDate);
    }
}
