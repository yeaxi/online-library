package ua.dudka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.dudka.beans.Book;
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
        return "/general/Main";
    }

    @RequestMapping(value = "/editBook", method = RequestMethod.GET)
    public String editBook(@ModelAttribute Book book) {
        factory.bookDAO.updateBook(book);
        return "/general/AboutBook";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "/admin/Admin";
    }

}
