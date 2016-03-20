package store.cache;

import models.Book;
import store.DAO.BookDAO;
import store.DAO.Factory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by RASTA on 17.03.2016.
 */
public class BookCache {
    private static final BookDAO bookDAO = Factory.getInstance().getBookDAO();
    private static final Set<Book> books = new HashSet<>();
    private static final BookCache instance = new BookCache();

    private BookCache() {
        books.addAll(bookDAO.getBooks());
    }

    public static BookCache getInstance() {
        return instance;
    }

    public Set<Book> getBooks() {
        return books;

    }

    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
            bookDAO.addBook(book);
        }

    }

    public void updateBook(Book book) {
        if (book != null && contains(book.getName())) {
            books.add(book);
            bookDAO.updateBook(book);
        }

    }


    public void deleteBook(String bookName) {
        Book book = getBook(bookName);
        if (book != null) {
            books.remove(book);
            bookDAO.deleteBook(book);
        }
    }

    public Book getBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                return book;
            }
        }
        return null;

    }

    public boolean contains(String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return true;
            }
        }
        return false;

    }

    public void updateAll() {
        books.addAll(bookDAO.getBooks());
    }
}
