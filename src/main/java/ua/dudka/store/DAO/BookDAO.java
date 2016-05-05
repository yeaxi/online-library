package ua.dudka.store.DAO;

import ua.dudka.beans.Book;
import ua.dudka.beans.User;

import java.util.Collection;

/**
 * Created by RASTA on 15.03.2016.
 */
public interface BookDAO {
    Collection<Book> getBooks();

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(Book book);

    Book getBook(String bookName);

    Collection<Book> getBooksByUser(User user);
}
