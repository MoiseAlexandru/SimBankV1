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
    public Card(String cardNumber, int CVV, String ownerId) {
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.ownerId = ownerId;
        this.cardCreationDate = LocalDate.now();
        this.cardExpirationDate = cardExpirationDate.plusYears(5);
        this.cardActivationStatus = false;
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
