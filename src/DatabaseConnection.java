import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/BANKSIM_DB";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";
    public static Connection connection = null;
    public static void setConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
