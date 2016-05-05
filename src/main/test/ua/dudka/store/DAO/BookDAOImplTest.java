package ua.dudka.store.DAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.dudka.beans.Book;
import ua.dudka.beans.User;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 15.03.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-context.xml")
public class BookDAOImplTest {

    @Autowired
    private Factory factory;

    @Test
    public void testGetBooks() throws Exception {
        Collection<Book> books = factory.bookDAO.getBooks();
        for (Book book : books) {
            System.out.println(book.getName() + " " + book.getAuthor() + " " + book.getGenre());
        }

    }

    @Test
    public void testAddBook() throws Exception {
        Book book = new Book("myBook", "me", "novel");
        factory.bookDAO.addBook(book);
        Book required = factory.bookDAO.getBook("myBook");
        assertEquals("novel", required.getGenre());

    }

    @Test
    public void testGetBooksByUser() throws Exception {

        User user = factory.userDAO.getUser(4);
        Collection<Book> booksByUser = factory.bookDAO.getBooksByUser(user);
        for (Book book : booksByUser) {
            System.out.println(book.getName());
            System.out.println(book.getAuthor());
            System.out.println(book.getGenre());
        }

    }

    @Test
    public void testUpdateBook() throws Exception {

    }
}