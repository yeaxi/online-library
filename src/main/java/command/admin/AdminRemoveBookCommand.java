package command.admin;

import command.ActionCommand;
import managers.ConfigurationManager;
import managers.MessageManager;

import store.cache.BookCache;
import store.cache.UserCache;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by RASTA on 18.03.2016.
 */
public class AdminRemoveBookCommand implements ActionCommand {
    private static final BookCache BOOK_CACHE = BookCache.getInstance();
    private static final String CONTEXT_PATH = ConfigurationManager.getProperty("path.resources.books");

    @Override
    public String execute(HttpServletRequest req) {
        String bookName = req.getParameter("bookName");
        String filePath = CONTEXT_PATH + BOOK_CACHE.getBook(bookName).getFilePath();
        try {
            Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {

        }
        BOOK_CACHE.deleteBook(bookName);
        if (BOOK_CACHE.contains(bookName)) {
            req.setAttribute("removeMessage", MessageManager.getProperty("message.removeBook.error"));
        }
        BOOK_CACHE.updateAll();
        UserCache.getInstance().updateAll();
        req.setAttribute("removeMessage", MessageManager.getProperty("message.removeBook.success"));
        return ConfigurationManager.getProperty("path.page.aboutbook");
    }
}
