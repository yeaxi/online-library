package ua.dudka.store.DAO;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.dudka.beans.Role;
import ua.dudka.beans.User;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 15.03.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-context.xml"})
public class UserDAOImplTest {

    @Autowired
    Factory factory;


    @Test
    public void testAddUser() throws Exception {
        User user = new User("test", "test");
        user.setRole(Role.ROLE_USER);
        factory.userDAO.addUser(user);

        User required = factory.userDAO.getUser("test");
        assertEquals("test", required.getPassword());
        assertEquals(Role.ROLE_USER, required.getRole());
    }

    @Test
    public void testGetUser() throws Exception {
        User user = factory.userDAO.getUser("admin");
        assertEquals("admin", user.getLogin());
        assertEquals("password", user.getPassword());
        assertEquals(Role.ROLE_USER, user.getRole());

    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = factory.userDAO.getUser("admin");
        user.addBook(factory.bookDAO.getBook("test"));
        factory.userDAO.updateUser(user);
        User required = factory.userDAO.getUser("admin");
        assertEquals(1, required.getBooks().size());
    }

    @Test
    public void getAllUsers() throws Exception {
        for (User user : factory.userDAO.getAllUsers()) {
            System.out.println(user.getLogin());
        }

    }

    @Test
    public void getUserById() throws Exception {
        User user = factory.userDAO.getUser(8);
        assertEquals("admin", user.getLogin());
    }

    @Test
    public void updateUser() throws Exception {

    }
}