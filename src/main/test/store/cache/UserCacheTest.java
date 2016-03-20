package store.cache;

import models.Book;
import models.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 17.03.2016.
 */
public class UserCacheTest {
    private static final UserCache userCache = UserCache.getInstance();

    @Test
    public void testAddUser() throws Exception {
        User user = new User("login", "password");
        userCache.addUser(user);
        assertEquals(true, userCache.contains("login"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = userCache.getUser("admin");
        Book book = BookCache.getInstance().getBook("Бойцовский клуб");
        user.addBook(book);
        userCache.updateUser(user);
        User updated = userCache.getUser("admin");
        assertEquals(true, updated.hasBook(book));
        updated.removeBook(book);
        userCache.updateUser(updated);
        updated = userCache.getUser("login");
        assertEquals(false, updated.hasBook(book));
    }

    @Test
    public void testGetUser() throws Exception {
        User user = userCache.getUser("yeaxi");
        assertEquals("rostik1998", user.getPassword());
    }
}