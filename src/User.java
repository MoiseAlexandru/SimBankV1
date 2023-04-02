import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class User {
    private String name;
    private String address;
    private String userId;
    private String nationality;
    private long identityCard;
    private String phoneNumber;
    private String occupation;
    private LocalDate birthdate;
    private String gender;
    private boolean married;
    private Date userRegistrationDate;
    private double creditScore;
    User() {}
    User(String name, String address, String nationality, long identityCard, String phoneNumber, String occupation, LocalDate birthdate, String gender, boolean married) {
        this.name = name;
        this.address = address;
        this.userId = UUID.randomUUID().toString();
        this.nationality = nationality;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.birthdate = birthdate;
        this.gender = gender;
        this.married = married;
        this.userRegistrationDate = new Date();
        this.creditScore = 30;
    }
    void updateAddress(String newAddress) {
        this.address = newAddress;
    }
    void updateOccupation(String newOccupation) {
        this.occupation = newOccupation;
    }
    void updatePhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }
    void updateMaritalStatus(boolean married) {
        this.married = married;
    }
    void updateCreditScore(double newCreditScore) {
        this.creditScore = newCreditScore;
    }
}