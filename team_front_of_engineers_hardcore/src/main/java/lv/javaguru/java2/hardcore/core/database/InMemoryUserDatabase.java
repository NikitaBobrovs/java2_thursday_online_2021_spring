package lv.javaguru.java2.hardcore.core.database;



import lv.javaguru.java2.hardcore.core.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class InMemoryUserDatabase implements UserDatabase {

    private Long nextId = 1L;
    private List<User> users = new ArrayList<>();
    private List<User> loggedInUsers = new ArrayList<>();


    @Override
    public void addUser(User user) {
        user.setUserId(nextId);
        nextId++;
        users.add(user);
    }

    @Override
    public void getUserByLogin(User user) {
        if (users.contains(user)) {
            System.out.println("Welcome: " + user.getName());
            loggedInUsers.add(user);
        } else {
            System.out.println("Username or password are incorrect,please try again");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}


