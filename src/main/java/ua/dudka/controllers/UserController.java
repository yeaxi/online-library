package ua.dudka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.dudka.beans.User;
import ua.dudka.managers.MessageManager;
import ua.dudka.store.DAO.Factory;

/**
 * Created by RASTA on 19.04.2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private Factory factory;


    @RequestMapping(value = "/login")
    public String login(ModelMap map) {
        String login = (String) map.get("login");
        String password = (String) map.get("password");
        String resp;
        if (factory.userDAO.contains(login)) {
            User user = factory.userDAO.getUser(login);
            if (user.getPassword() == password) {
                resp = "/book/Main";
            } else {
                map.addAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
                resp = "/user/Login";
            }
        } else {
            map.addAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            resp = "/general/Login;";
        }
        return resp;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute User user, ModelMap map) {
        factory.userDAO.updateUser(user);
        map.addAttribute("user", user);
        return "/user/UserProfile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(@RequestParam String login, ModelMap map) {
        User user = factory.userDAO.getUser(login);
        map.addAttribute("user", user);
        return "/user/UserProfile";
    }
}
