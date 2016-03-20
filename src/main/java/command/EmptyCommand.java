package command;

import managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RASTA on 16.03.2016.
 */
public class EmptyCommand implements ActionCommand {
    public String execute(HttpServletRequest req) {
        String page = ConfigurationManager.getProperty("path.page.errorpage");
        return page;
    }
}
