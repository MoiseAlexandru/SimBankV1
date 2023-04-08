import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataStorage {
    public static ArrayList <User> Users = new ArrayList <User>();
    public static ArrayList <Card> Cards = new ArrayList <Card>();
    public static ArrayList <Account> Accounts = new ArrayList <Account>();
    public static ArrayList <Transaction> Transactions = new ArrayList <Transaction>();
    public static Map <String, String> Clients = new HashMap <>(); // hashmap de tipul <userId, userName> pentru cautari
}
