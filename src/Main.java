import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.setConnection();
        if(DatabaseConnection.connection == null) {
            System.out.println("Connection to database failed");
            return;
        }
        Menu menu = new Menu();
        menu.displayIntro();
    }
}
