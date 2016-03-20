package command.user;

import command.ActionCommand;
import managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RASTA on 16.03.2016.
 */
public class LogoutCommand implements ActionCommand {
    public String execute(HttpServletRequest req) {
        String page = ConfigurationManager.getProperty("path.page.main");
        req.getSession().invalidate();
        return page;
    }
}
