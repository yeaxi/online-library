package command.user;

import command.ActionCommand;
import managers.ConfigurationManager;
import managers.MessageManager;
import models.Book;
import models.User;
import store.cache.BookCache;
import store.cache.UserCache;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RASTA on 18.03.2016.
 */
public class RemoveBookCommand implements ActionCommand {
    private static final UserCache CACHE = UserCache.getInstance();
    private static final BookCache BOOK_CACHE = BookCache.getInstance();

    @Override
    public String execute(HttpServletRequest req) {
        User user = CACHE.getUser(req.getParameter("login"));
        Book book = BOOK_CACHE.getBook(req.getParameter("bookName"));

        if (user.hasBook(book)) {
            user.removeBook(book);
            CACHE.updateUser(user);
            req.setAttribute("removeMessage", MessageManager.getProperty("message.removeBook.success"));
        } else {
            req.setAttribute("removeMessage", MessageManager.getProperty("message.removeBook.error"));
        }
        req.setAttribute("book", book);
        return ConfigurationManager.getProperty("path.page.aboutbook");
    }
}
