package ua.dudka.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RASTA on 16.03.2016.
 */
public interface ActionCommand {
    String execute(HttpServletRequest req);
}
