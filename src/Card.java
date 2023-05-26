import java.time.LocalDate;
import java.util.Date;

public class Card {
    private String cardNumber;
    private int CVV;
    private String ownerId;
    private LocalDate cardCreationDate;
    private LocalDate cardExpirationDate;
    private boolean cardActivationStatus;
    public Card() {}
    public Card(String ownerId) {
        this.cardNumber = Utils.generateRandomCardNumber();
        this.CVV = Utils.generateRandomCVV();
        this.ownerId = ownerId;
        this.cardCreationDate = LocalDate.now();
        this.cardExpirationDate = cardCreationDate.plusYears(5);
        this.cardActivationStatus = false;
    }
    public Card(String cardNumber, int CVV, String ownerId, LocalDate cardCreationDate, boolean cardActivationStatus) {
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.cardCreationDate = cardCreationDate;
        this.cardExpirationDate = cardCreationDate.plusYears(5);
        this.cardActivationStatus = cardActivationStatus;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public int getCVV() {
        return CVV;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public LocalDate getCardCreationDate() {
        return cardCreationDate;
    }
    public LocalDate getCardExpirationDate() {
        return cardExpirationDate;
    }
    public boolean getCardActivationStatus() {
        return cardActivationStatus;
    }
    public void activateCard() {
        this.cardActivationStatus = true;
    }
    public void deactivateCard() {
        this.cardActivationStatus = false;
    }
    public boolean expired() {
        LocalDate today = LocalDate.now();
        if(today.isAfter(cardExpirationDate))
            return true;
        return false;
    }
    public boolean validateCVV(int enteredCVV) {
        if(enteredCVV != this.CVV)
            return false;
        return true;
    }
}
