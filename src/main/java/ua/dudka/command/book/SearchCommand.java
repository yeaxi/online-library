package ua.dudka.command.book;

import ua.dudka.command.ActionCommand;
import ua.dudka.managers.ConfigurationManager;
import ua.dudka.managers.MessageManager;
import ua.dudka.models.Book;
import ua.dudka.store.cache.BookCache;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by RASTA on 18.03.2016.
 */
public class SearchCommand implements ActionCommand {
    private static final BookCache CACHE = BookCache.getInstance();
    private static Set<Book> books = CACHE.getBooks();

    private static Set<Book> findByName(String bookName) {
        Set<Book> result = new HashSet<>();
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                result.add(book);
            }
        }
        return result;
    }

    private static Set<Book> findByGenre(String bookName) {
        Set<Book> result = new HashSet<>();
        for (Book book : books) {
            if (book.getGenre().equals(bookName)) {
                result.add(book);
            }
        }
        return result;
    }

    private static Set<Book> findByAuthor(String bookName) {
        Set<Book> result = new HashSet<>();
        for (Book book : books) {
            if (book.getAuthor().equals(bookName)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String by = req.getParameter("by");
        Set<Book> result = new HashSet<>();
        String searchString = req.getParameter("searchString");
        if (by.equals("bookName")) {
            result.addAll(findByName(searchString));
        } else if (by.equals("genre")) {
            result.addAll(findByGenre(searchString));
        } else if (by.equals("author")) {
            result.addAll(findByAuthor(searchString));
        }
        if (result.isEmpty()) {
            req.setAttribute("searchResult", MessageManager.getProperty("message.search.nothing"));

        } else {
            req.setAttribute("searchResult", MessageManager.getProperty("message.search.success"));
        }

        req.setAttribute("result", result);
        return ConfigurationManager.getProperty("path.page.main");
    }
}
