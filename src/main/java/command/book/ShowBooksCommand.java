package command.book;

import command.ActionCommand;
import managers.ConfigurationManager;
import store.cache.BookCache;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RASTA on 16.03.2016.
 */
public class ShowBooksCommand implements ActionCommand {
    private static final BookCache CACHE = BookCache.getInstance();

    public String execute(HttpServletRequest req) {
        req.setAttribute("books", CACHE.getBooks());
        return ConfigurationManager.getProperty("path.page.main");

    }

}
