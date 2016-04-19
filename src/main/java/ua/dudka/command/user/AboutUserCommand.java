package ua.dudka.command.user;

import ua.dudka.command.ActionCommand;
import ua.dudka.managers.ConfigurationManager;
import ua.dudka.beans.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RASTA on 16.03.2016.
 */
public class AboutUserCommand implements ActionCommand {
//    private static final UserCache CACHE = UserCache.getInstance();

    public String execute(HttpServletRequest req) {
        String page;
        String login = req.getParameter("login");

//        User user = CACHE.getUser(login);
//        req.setAttribute("user", user);
        page = ConfigurationManager.getProperty("path.page.aboutuser");
        return page;
    }

}
