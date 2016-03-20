package command.book;

import command.ActionCommand;
import managers.ConfigurationManager;
import models.Book;
import store.cache.BookCache;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RASTA on 16.03.2016.
 */
public class AboutBookCommand implements ActionCommand {
    private static final BookCache BOOK_CACHE = BookCache.getInstance();

    public String execute(HttpServletRequest req) {

        String bookName = req.getParameter("bookName");
        Book book = BOOK_CACHE.getBook(bookName);
        req.setAttribute("book", book);
        return ConfigurationManager.getProperty("path.page.aboutbook");
    }
}
