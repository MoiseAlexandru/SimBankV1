import javax.xml.crypto.Data;

public class CardRepository {
    public Card findCardById(String cardId) {
        for(Card card : DataStorage.Cards)
            if(card.getCardNumber().equals(cardId))
                return card;
        return null;
    }
    public void addCard(Card card) throws IllegalArgumentException {
        if(findCardById(card.getCardNumber()) != null)
            throw new IllegalArgumentException();
        DataStorage.Cards.add(card);
    }
}
