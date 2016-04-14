package ua.dudka.command.user;

import ua.dudka.command.ActionCommand;
import ua.dudka.managers.MessageManager;
import ua.dudka.models.User;
import ua.dudka.managers.ConfigurationManager;
import ua.dudka.store.cache.UserCache;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RASTA on 16.03.2016.
 */
public class LoginCommand implements ActionCommand {
    private static final String ADMIN_LOGIN = "root";
    private static final UserCache cache = UserCache.getInstance();

    public String execute(HttpServletRequest req) {
        String page = null;
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = cache.getUser(login);
        if (user.getLogin() != null && user.getPassword().equals(password)) {
            if (login.equals(ADMIN_LOGIN)) {
                req.setAttribute("isAdmin", true);
            }
            req.setAttribute("isLogIn", true);
            req.setAttribute("login", login);
            page = ConfigurationManager.getProperty("path.page.main");

        } else {
            req.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }

}
