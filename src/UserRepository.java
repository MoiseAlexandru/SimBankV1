import javax.xml.crypto.Data;

public class UserRepository {
    public void deleteUserById(String userId) throws IllegalArgumentException {
        User user = getUserById(userId);
        if(user == null)
            throw new IllegalArgumentException("Error in function deleteByUserId of class UserRepository: user not found");
        DataStorage.Users.remove(user);
    }
    public void deleteUserByName(String name) throws IllegalArgumentException {
        User user = getUserByName(name);
        if(user == null)
            throw new IllegalArgumentException("Error in function deleteByUserId of class UserRepository: user not found");
        DataStorage.Users.remove(user);
    }
    public User getUserById(String userId) {
        for(User user : DataStorage.Users) {
            if(user.getUserId() == userId)
                return user;
        }
        return null;
    }
    public User getUserByName(String name) {
        for(User user : DataStorage.Users) {
            if(user.getName() == name)
                return user;
        }
        return null;
    }
    public void addUser(User user) throws IllegalArgumentException {
        if(getUserById(user.userId) != null) {
            throw new IllegalArgumentException("Error in addUser of UserRepository class: User already exists in the database!");
        }
        DataStorage.Users.add(user);
    }
}
