package ua.dudka.store.DAO;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.dudka.models.User;

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

        User user = new User("admin", "password");
        User required = userDAO.getUser("admin");
        assertEquals("password", required.getPassword());
        userDAO.close();
    }

    @Test
    public void testGetUser() throws Exception {
        User user = userDAO.getUser("admin");
        assertEquals("admin", user.getLogin());
        assertEquals("password", user.getPassword());

        userDAO.close();

    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = userDAO.getUser("admin");
        user.addBook(Storage.bookDAO.getBook("test"));
        userDAO.updateUser(user);
        User required = userDAO.getUser("admin");
        assertEquals(1, required.getBooks().size());
    }
}