package Library.service;

import Library.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {
    private List<User> users;
    public UserRepository(){
        this.users = new ArrayList<>();
    }
    public void addUser(User user){
        this.users.add(user);
    }
    public List<User> getUsers(){
        return this.users;
    }
    public User getUserById(UUID userId){
        return this.users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null);
    }
}
