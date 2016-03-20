package store.DAO;

import models.Book;
import models.User;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 15.03.2016.
 */
public class BookDAOImplTest {

    @Test
    public void testGetBooks() throws Exception {
        final BookDAO bookDAO = Factory.getInstance().getBookDAO();
        Collection<Book> books = bookDAO.getBooks();
        for (Book book : books) {
            System.out.println(book.getName());
            System.out.println(book.getAuthor());
            System.out.println(book.getGenre());
        }

    }

    @Test
    public void testAddBook() throws Exception {
        final BookDAO bookDAO = Factory.getInstance().getBookDAO();
        Book book = new Book("myBook", "me");
        book.setGenre("novel");
        bookDAO.addBook(book);
        Book required = bookDAO.getBook("myBook");
        assertEquals("novel", required.getGenre());

    }

    @Test
    public void testGetBooksByUser() throws Exception {

        final BookDAO bookDAO = Factory.getInstance().getBookDAO();
        User user = Factory.getInstance().getUserDAO().getUser(3);
        Collection<Book> booksByUser = bookDAO.getBooksByUser(user);
        for (Book book : booksByUser) {
            System.out.println(book.getName());
            System.out.println(book.getAuthor());
            System.out.println(book.getGenre());
        }

    }

    @Test
    public void testUpdateBook() throws Exception {
        final BookDAO bookDAO = Factory.getInstance().getBookDAO();


    }
}