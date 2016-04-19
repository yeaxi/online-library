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
@RequestMapping("/book")
public class BookController {
    @Autowired
    private Factory factory;

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String showBooks(ModelMap model) {
        model.addAttribute("books", factory.bookDAO.getBooks());
        return "/book/Main";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String aboutBook(@ModelAttribute Book book, ModelMap model) {
        model.addAttribute("book", book);
        return "/book/AboutBook";
    }
}
