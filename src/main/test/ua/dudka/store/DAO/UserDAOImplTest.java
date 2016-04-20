package ua.dudka.store.DAO;


import org.junit.BeforeClass;
import org.junit.Test;
import ua.dudka.beans.Role;
import ua.dudka.beans.User;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 15.03.2016.
 */
public class UserDAOImplTest {
    static UserDAO userDAO;

    @BeforeClass
    public static void init() {
        userDAO = Storage.userDAO;
    }


    @Test
    public void testAddUser() throws Exception {
        User user = new User("test", "test");
        user.setRole(Role.USER);
            userDAO.addUser(user);

        User required = userDAO.getUser("test");
        assertEquals("test", required.getPassword());
        assertEquals(Role.USER, required.getRole());
    }

    @Test
    public void testGetUser() throws Exception {
        User user = userDAO.getUser("admin");
        assertEquals("admin", user.getLogin());
        assertEquals("password", user.getPassword());
        assertEquals(Role.USER, user.getRole());

    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = userDAO.getUser("admin");
        user.addBook(Storage.bookDAO.getBook("test"));
        userDAO.updateUser(user);
        User required = userDAO.getUser("admin");
        assertEquals(1, required.getBooks().size());
    }

    @Test
    public void getAllUsers() throws Exception {
        for (User user : userDAO.getAllUsers()) {
            System.out.println(user.getLogin());
        }

    }

    @Test
    public void getUserById() throws Exception {
        User user = userDAO.getUser(8);
        assertEquals("admin", user.getLogin());
    }

    @Test
    public void updateUser() throws Exception {

    }
}