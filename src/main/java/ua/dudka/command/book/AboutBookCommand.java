package ua.dudka.command.book;

import ua.dudka.command.ActionCommand;
import ua.dudka.managers.ConfigurationManager;
import ua.dudka.beans.Book;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RASTA on 16.03.2016.
 */
public class AboutBookCommand implements ActionCommand {

    public String execute(HttpServletRequest req) {

        String bookName = req.getParameter("bookName");
//        Book book = BOOK_CACHE.getBook(bookName);
//        req.setAttribute("book", book);
        return ConfigurationManager.getProperty("path.page.aboutbook");
    }
}
