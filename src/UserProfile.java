import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class UserProfile extends User {
    private String nationality;
    private long identityCard;
    private String phoneNumber;
    private String occupation;
    private LocalDate birthdate;
    private String gender;
    private boolean married;
    private double creditScore;

    public UserProfile(String name, String address, String nationality, long identityCard, String phoneNumber, String occupation, LocalDate birthdate, String gender, boolean married) {
        this.name = name;
        this.address = address;
        this.userId = UUID.randomUUID().toString();
        this.userRegistrationDate = new Date();
        this.nationality = nationality;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.birthdate = birthdate;
        this.gender = gender;
        this.married = married;
        this.creditScore = 30;
    }
    public void updateOccupation(String newOccupation) {
        this.occupation = newOccupation;
    }
    public void updatePhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }
    public void updateMaritalStatus(boolean married) {
        this.married = married;
    }

    public void updateCreditScore(double newCreditScore) {
        this.creditScore = newCreditScore;
    }
}
