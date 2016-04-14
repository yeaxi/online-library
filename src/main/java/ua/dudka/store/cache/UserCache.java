package ua.dudka.store.cache;

import ua.dudka.models.User;
import ua.dudka.store.DAO.Storage;
import ua.dudka.store.DAO.UserDAO;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RASTA on 17.03.2016.
 */
public class UserCache {
    private static final UserDAO userDAO = Storage.userDAO;
    private static final Set<User> users = new HashSet<User>();
    private static final UserCache instance = new UserCache();

    static {
        users.addAll(userDAO.getAllUsers());
    }

    private UserCache() {
    }

    public static UserCache getInstance() {
        return instance;
    }

    public void addUser(User user) {
        if (user != null && !contains(user.getLogin())) {
            users.add(user);
            userDAO.addUser(user);
        }
    }

    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return new User();

    }

    public void updateUser(User user) {
        if (user != null && contains(user.getLogin())) {
            users.add(user);
            userDAO.updateUser(user);
        }

    }

    public boolean contains(String login) {
        return findUser(login) != null;
    }

    public void updateAll() {
        users.addAll(userDAO.getAllUsers());

    }

    public User getUser(String login) {
        User result = findUser(login);
        if (result != null) {
            return result;
        }
        return new User();
    }

    private User findUser(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;

    }


}
