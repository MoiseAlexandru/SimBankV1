import java.time.LocalDate;
import java.util.Date;

public class Card {
    private String cardNumber;
    private int CVV;
    private String ownerId;
    private Date cardCreationDate;
    private LocalDate cardExpirationDate;
    private boolean cardActivationStatus;
    public Card() {}
    public Card(String ownerId, String cardNumber, int CVV) {
        this.cardNumber = cardNumber;
        this.ownerId = ownerId;
        this.CVV = CVV;
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
}
