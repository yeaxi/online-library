package ua.dudka.command;

import ua.dudka.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RASTA on 16.03.2016.
 */
public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest req) {
        ActionCommand current = new EmptyCommand();
        String action = req.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            req.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));

        }
        return current;
    }
}
