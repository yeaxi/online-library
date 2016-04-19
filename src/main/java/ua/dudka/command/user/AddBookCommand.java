package ua.dudka.command.user;

import ua.dudka.command.ActionCommand;
import ua.dudka.managers.ConfigurationManager;
import ua.dudka.managers.MessageManager;
import ua.dudka.beans.Book;
import ua.dudka.beans.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RASTA on 16.03.2016.
 */
public class AddBookCommand implements ActionCommand {
//    private static final UserCache CACHE = UserCache.getInstance();
//    private static final BookCache bookCACHE = BookCache.getInstance();

    public String execute(HttpServletRequest req) {
        String login = req.getParameter("login");
//        User user = CACHE.getUser(login);
//        Book book = bookCACHE.getBook(req.getParameter("bookName"));
        /*if (book.getName().length() != 0 && !user.hasBook(book)) {
            user.addBook(book);
            CACHE.updateUser(user);
            req.setAttribute("success", MessageManager.getProperty("message.addbook.success"));
        } else {
            req.setAttribute("hasBook", MessageManager.getProperty("message.addbook.hasbook"));
        }
        req.setAttribute("book", book);*/
        return ConfigurationManager.getProperty("path.page.aboutbook");
    }
}
