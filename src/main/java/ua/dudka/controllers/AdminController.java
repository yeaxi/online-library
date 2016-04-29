package ua.dudka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.dudka.beans.Book;
import ua.dudka.beans.User;
import ua.dudka.store.DAO.Factory;

/**
 * Created by RASTA on 19.04.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private Factory factory;

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute Book book) {
        factory.bookDAO.addBook(book);
        return "redirect:/main";
    }

    @RequestMapping(value = "/editBook", method = RequestMethod.GET)
    public String editBook(@ModelAttribute Book book) {
        factory.bookDAO.updateBook(book);
        return "/general/AboutBook";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(ModelMap map) {
        map.addAttribute("users", factory.userDAO.getAllUsers());
        return "/admin/Admin";
    }

    @RequestMapping(value = "/removeBook", method = RequestMethod.GET)
    public String removeBook(@RequestParam() String bookName) {
        Book book = factory.bookDAO.getBook(bookName);
        factory.bookDAO.deleteBook(book);
        return "redirect:/main";
    }


    @RequestMapping(value = "/removeUser", method = RequestMethod.GET)
    public String removeUser(@RequestParam String login) {
        User user = factory.userDAO.getUser(login);
        factory.userDAO.deleteUser(user);
        return "redirect:/admin/users";
    }

}
