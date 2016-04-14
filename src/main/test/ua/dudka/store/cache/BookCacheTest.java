package ua.dudka.store.cache;

import org.junit.Test;
import ua.dudka.models.Book;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 17.03.2016.
 */
public class BookCacheTest {
    private static BookCache cache = BookCache.getInstance();

    @Test
    public void testGetBooks() throws Exception {
        Set<Book> bookSet = cache.getBooks();
        for (Book book : bookSet) {
            System.out.println(book.getName());
        }

    }

    @Test
    public void testAddBook() throws Exception {
        assertEquals(3, cache.getBooks().size());
        Book book = new Book("name", "author");
        book.setGenre("genre");
        cache.addBook(book);
        assertEquals(4, cache.getBooks().size());
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book book = cache.getBook("name");
        book.setGenre("myGenre");
        book.setAuthor("myAuthor");
        cache.updateBook(book);
        Book required = cache.getBook("name");
        assertEquals("myGenre", required.getGenre());
    }

    @Test
    public void testDeleteBook() throws Exception {
        assertEquals(true, cache.contains("name"));
        cache.deleteBook("name");
        assertEquals(false, cache.contains("name"));
    }

}