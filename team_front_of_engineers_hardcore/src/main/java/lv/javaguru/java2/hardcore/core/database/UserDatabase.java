package lv.javaguru.java2.hardcore.core.database;


import lv.javaguru.java2.hardcore.core.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDatabase {

    void addUser(User user);

    Optional<User> getUserByLogin(String login);

    List<User> getAllUsers();

}
