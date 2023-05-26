import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CardRepository {
    public static Card findCardById(String cardNumber) {
        try {
            String sql = "SELECT * FROM CARD WHERE cardNumber = ?";
            PreparedStatement statement = DatabaseConnection.connection.prepareStatement(sql);
            statement.setString(1, cardNumber);
            ResultSet result = statement.executeQuery();
            DataStorage.dbRequests.add(new DbRequest("find card with number " + cardNumber, new java.util.Date()));
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
    public static void addCard(Card card) throws IllegalArgumentException {
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
            DataStorage.dbRequests.add(new DbRequest("add card with number " + card.getCardNumber(), new java.util.Date()));
            System.out.println("Card with id " + card.getCardNumber() + " added successfully");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteCard(Card card) throws IllegalArgumentException {
        if(findCardById(card.getCardNumber()) == null) {
            System.out.println("Card does not exist in the database.");
            throw new IllegalArgumentException();
        }
        try {
            String sql = "DELETE FROM CARD WHERE cardNumber = ?";
            PreparedStatement statement = DatabaseConnection.connection.prepareStatement(sql);
            statement.setString(1, card.getCardNumber());
            statement.executeUpdate();
            DataStorage.dbRequests.add(new DbRequest("delete card with number " + card.getCardNumber(), new java.util.Date()));
            System.out.println("Card with id " + card.getCardNumber() + " deleted successfully");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateCard(Card card) throws IllegalArgumentException {
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
            DataStorage.dbRequests.add(new DbRequest("update card with number " + card.getCardNumber(), new java.util.Date()));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void getAllCards() {
        try {
            List<Card> cardList;
            String sql = "SELECT * FROM CARD";
            PreparedStatement statement = DatabaseConnection.connection.prepareStatement(sql);
            DataStorage.dbRequests.add(new DbRequest("display all cards", new java.util.Date()));
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                String cardNumber = result.getString("cardNumber");
                int CVV = result.getInt("CVV");
                String ownerId = result.getString("ownerId");
                LocalDate cardCreationDate = result.getDate("cardCreationDate").toLocalDate();
                LocalDate cardExpirationDate = result.getDate("cardExpirationDate").toLocalDate();
                boolean cardActivationStatus = result.getBoolean("cardActivationStatus");
                Card returnedCard = new Card(cardNumber, CVV, ownerId, cardCreationDate, cardActivationStatus);
                returnedCard.display();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
