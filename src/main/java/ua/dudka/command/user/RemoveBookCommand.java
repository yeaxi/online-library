package ua.dudka.command.user;

import ua.dudka.command.ActionCommand;
import ua.dudka.managers.ConfigurationManager;
import ua.dudka.managers.MessageManager;
import ua.dudka.beans.Book;
import ua.dudka.beans.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RASTA on 18.03.2016.
 */
public class RemoveBookCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest req) {
       /* User user = CACHE.getUser(req.getParameter("login"));
        Book book = BOOK_CACHE.getBook(req.getParameter("bookName"));

        if (user.hasBook(book)) {
            user.removeBook(book);
            CACHE.updateUser(user);
            req.setAttribute("removeMessage", MessageManager.getProperty("message.removeBook.success"));
        } else {
            req.setAttribute("removeMessage", MessageManager.getProperty("message.removeBook.error"));
        }
        req.setAttribute("book", book);*/
        return ConfigurationManager.getProperty("path.page.aboutbook");
    }
}
