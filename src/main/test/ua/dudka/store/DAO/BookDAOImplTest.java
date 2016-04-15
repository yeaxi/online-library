package ua.dudka.store.DAO;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.dudka.models.Book;
import ua.dudka.models.User;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 15.03.2016.
 */
public class BookDAOImplTest {

    static BookDAO bookDAO;

    @BeforeClass
    public static void init() {
        bookDAO = Storage.bookDAO;
    }

    @Test
    public void testGetBooks() throws Exception {
        Collection<Book> books = bookDAO.getBooks();
        for (Book book : books) {
            System.out.println(book.getName() + " " + book.getAuthor() + " " + book.getGenre());
        }

    }

    @Test
    public void testAddBook() throws Exception {
        Book book = new Book("myBook", "me");
        book.setGenre("novel");
        bookDAO.addBook(book);
        Book required = bookDAO.getBook("myBook");
        assertEquals("novel", required.getGenre());

    }

    @Test
    public void testGetBooksByUser() throws Exception {

        User user = Storage.userDAO.getUser(4);
        Collection<Book> booksByUser = bookDAO.getBooksByUser(user);
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