import java.time.LocalDate;

public class UserService {
    private final UserRepository userRepository;
    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    public UserService(UserRepository userRepository, CardRepository cardRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }
    public void createUser(User user) {
        try {
            userRepository.addUser(user);
        }
        catch(Exception err) {
            throw new IllegalArgumentException("Error in function createUser of userRepository", err);
        }
    }
    public void createUser(String name, String address, String nationality, long identityCard, String phoneNumber, String occupation, LocalDate birthdate, String gender, boolean married) throws IllegalArgumentException{
        UserProfile user = new UserProfile(name, address, nationality, identityCard, phoneNumber, occupation, birthdate, gender, married);
        createUser(user);
    }
    public void createUser(String name, String address, String contactPerson, String contactPhone, String industry, int companySizeMin, int companySizeMax) throws IllegalArgumentException{
        BusinessProfile user = new BusinessProfile(name, address, contactPerson, contactPhone, industry, companySizeMin, companySizeMax);

        try {
            userRepository.addUser(user);
            CheckingAccount firstAccount = new CheckingAccount(user.userId);
            Card card = new Card(user.userId);
            accountRepository.addAccount(firstAccount);
            cardRepository.addCard(card);
        }
        catch(Exception err) {
            throw new IllegalArgumentException("Error in function createUser of userRepository", err);
        }
    }
    public void deleteUserById(String userId) throws IllegalArgumentException {
        try {
            userRepository.deleteUserById(userId);
        }
        catch(Exception err) {
            throw new IllegalArgumentException("Error in function deleteUserById of class UserService", err);
        }
    }
    public void deleteUserByName(String name) {
        try {
            userRepository.deleteUserByName(name);
        }
        catch(Exception err) {
            throw new IllegalArgumentException("Error in function deleteUserByName of class UserService", err);
        }
    }
}
