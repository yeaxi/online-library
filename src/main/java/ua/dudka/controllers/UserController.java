package ua.dudka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.dudka.beans.Book;
import ua.dudka.beans.User;
import ua.dudka.store.DAO.Factory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by RASTA on 19.04.2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private Factory factory;

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute User user, ModelMap map) {
        factory.userDAO.updateUser(user);
        map.addAttribute("user", user);
        return "/user/UserProfile";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String editUser(@RequestParam String bookName, ModelMap map) {
        User user = factory.userDAO.getUser(getPrincipal());
        Book book = factory.bookDAO.getBook(bookName);
        user.addBook(book);
        factory.userDAO.updateUser(user);
        map.addAttribute("book", book);
        return "/general/AboutBook";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(ModelMap map) {
        User user = factory.userDAO.getUser(getPrincipal());
        map.addAttribute("user", user);
        return "/user/UserProfile";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "/general/Main";
    }

    private String getPrincipal() {
        String login;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            login = ((UserDetails) principal).getUsername();
        } else {
            login = principal.toString();
        }
        return login;
    }
}
