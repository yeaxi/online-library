package ua.dudka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.dudka.beans.Book;
import ua.dudka.managers.MessageManager;
import ua.dudka.store.DAO.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RASTA on 19.04.2016.
 */
@Controller
public class MainController {
    @Autowired
    private Factory factory;

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String showBooks(ModelMap model) {

        model.addAttribute("books", factory.bookDAO.getBooks());
        return "/general/Main";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "/general/Login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpPage() {
        return "/general/SignUp";
    }

    @RequestMapping(value = "/aboutBook", method = RequestMethod.GET)
    public String aboutBook(@RequestParam("book") String book, ModelMap model) {
        model.addAttribute("book", factory.bookDAO.getBook(book));
        return "/general/AboutBook";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("by") String findBy, @RequestParam("searchString") String searchString, ModelMap map) {
        List<Book> list;
        switch (findBy) {
            case "bookName":
                list = findByBookName(searchString);
                break;
            case "genre":
                list = findByGenre(searchString);
                break;
            case "author":
                list = findByAuthor(searchString);
                break;
            default:
                list = new ArrayList<>();
        }
        if (list.isEmpty()) {
            map.addAttribute("searchMessage", MessageManager.getProperty("message.search.nothing"));
        } else {
            map.addAttribute("searchMessage", MessageManager.getProperty("message.search.success"));
        }
        map.addAttribute("searchResult", list);
        return "/general/Main";
    }

    private List<Book> findByBookName(String bookName) {
        List<Book> list = new ArrayList<>();
        for (Book book : factory.bookDAO.getBooks()) {

            if (book.getName().toLowerCase().equals(bookName.toLowerCase())) {
                list.add(book);
            }
        }
        return list;
    }

    private List<Book> findByAuthor(String author) {
        List<Book> list = new ArrayList<>();
        for (Book book : factory.bookDAO.getBooks()) {

            if (book.getAuthor().toLowerCase().equals(author.toLowerCase())) {
                list.add(book);
            }
        }
        return list;
    }

    private List<Book> findByGenre(String genre) {
        List<Book> list = new ArrayList<>();
        for (Book book : factory.bookDAO.getBooks()) {
            if (book.getGenre().toLowerCase().equals(genre.toLowerCase())) {
                list.add(book);
            }
        }
        return list;
    }


}
