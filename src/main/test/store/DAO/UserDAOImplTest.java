package store.DAO;

import models.User;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 15.03.2016.
 */
public class UserDAOImplTest {

    @Test
    public void testAddUser() throws Exception {
        final UserDAO userDAO = Factory.getInstance().getUserDAO();
        User user = new User("admin", "password");
        if (!userDAO.contains("admin")) {
            userDAO.addUser(user);
        }
        User required = userDAO.getUser("admin");
        assertEquals("password", required.getPassword());
        userDAO.close();
    }

    @Test
    public void testGetUser() throws Exception {
        final UserDAO userDAO = Factory.getInstance().getUserDAO();
        User user = userDAO.getUser("admin");
        assertEquals("admin", user.getLogin());
        assertEquals("password", user.getPassword());

        userDAO.close();

    }

    @Test
    public void testUpdateUser() throws Exception {
        final UserDAO userDAO = Factory.getInstance().getUserDAO();
        User user = userDAO.getUser("admin");
        user.addBook(Factory.getInstance().getBookDAO().getBook("Цифровая крепость"));
        userDAO.updateUser(user);
        User required = userDAO.getUser("admin");
        assertEquals(1, required.getBooks().size());
    }
}