package ua.dudka.store.DAO;

import ua.dudka.models.User;

import java.util.Collection;


/**
 * Created by RASTA on 15.03.2016.
 */
public interface UserDAO {
    void addUser(User user);

    User getUser(int id);

    void updateUser(User user);

    User getUser(String login);

    Collection<User> getAllUsers();

    void close();

    boolean contains(String login);
}
