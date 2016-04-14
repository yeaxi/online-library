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
public class SignUpCommand implements ActionCommand {
    private static final UserCache cache = UserCache.getInstance();

    public String execute(HttpServletRequest req) {
        String page = null;
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (cache.contains(login)) {
            req.setAttribute("errorSignUp", MessageManager.getProperty("message.signuperror"));
            page = ConfigurationManager.getProperty("path.page.signup");
        } else {
            cache.addUser(new User(login, password));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
