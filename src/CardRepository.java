import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CardRepository {
    public Card findCardById(String cardNumber) {
        try {
            String sql = "SELECT * FROM CARD WHERE cardNumber = ?";
            PreparedStatement statement = DatabaseConnection.connection.prepareStatement(sql);
            statement.setString(1, cardNumber);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                int CVV = result.getInt("CVV");
                String ownerId = result.getString("ownerId");
                LocalDate cardCreationDate = result.getDate("cardCreationDate").toLocalDate();
                LocalDate cardExpirationDate = result.getDate("cardExpirationDate").toLocalDate();
                boolean cardActivationStatus = result.getBoolean("cardActivationStatus");
                Card returnedCard = new Card(cardNumber, CVV, ownerId, cardCreationDate, cardActivationStatus);
                System.out.println("Card with id " + cardNumber + " was found");
                return returnedCard;
            }
            System.out.println("Card with id " + cardNumber + " was not found");
            return null;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addCard(Card card) throws IllegalArgumentException {
        if(findCardById(card.getCardNumber()) != null) {
            System.out.println("Card already exists in the database");
            throw new IllegalArgumentException();
        }
        try {
            String sql = "INSERT INTO CARD (cardNumber, CVV, ownerId, cardCreationDate, cardExpirationDate, cardActivationStatus) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = DatabaseConnection.connection.prepareStatement(sql);
            statement.setString(1, card.getCardNumber());
            statement.setInt(2, card.getCVV());
            statement.setString(3, card.getOwnerId());
            statement.setDate(4, Date.valueOf(card.getCardCreationDate()));
            statement.setDate(5, Date.valueOf(card.getCardExpirationDate()));
            statement.setBoolean(6, card.getCardActivationStatus());
            statement.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Card with id " + card.getCardNumber() + " added successfully");
    }
    public void deleteCard(Card card) throws IllegalArgumentException {
        if(findCardById(card.getCardNumber()) == null) {
            System.out.println("Card does not exist in the database.");
            throw new IllegalArgumentException();
        }
        try {
            String sql = "DELETE FROM CARD WHERE cardNumber = ?";
            PreparedStatement statement = DatabaseConnection.connection.prepareStatement(sql);
            statement.setString(1, card.getCardNumber());
            statement.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Card with id " + card.getCardNumber() + " deleted successfully");
    }
    public void updateCard(Card card) throws IllegalArgumentException {
        if(findCardById(card.getCardNumber()) == null) {
            System.out.println("Card does not exist in the database.");
            throw new IllegalArgumentException();
        }
        try {
            String sql = "UPDATE CARD SET CVV = ?, cardCreationDate = ?, cardExpirationDate = ?, cardActivationStatus = ? WHERE cardNumber = ?";
            PreparedStatement statement = DatabaseConnection.connection.prepareStatement(sql);
            int newCVV = card.getCVV();
            LocalDate newCardCreationDate = card.getCardCreationDate();
            LocalDate newCardExpirationDate = card.getCardExpirationDate();
            boolean newCardActivationStatus = card.getCardActivationStatus();
            statement.setInt(1, newCVV);
            statement.setDate(2, Date.valueOf(newCardCreationDate));
            statement.setDate(3, Date.valueOf(newCardExpirationDate));
            statement.setBoolean(4, newCardActivationStatus);
            statement.setString(5, card.getCardNumber());
            statement.executeUpdate();
            System.out.println("Card with id " + card.getCardNumber() + " updated successfully");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
