package ua.dudka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.dudka.beans.Book;
import ua.dudka.beans.Role;
import ua.dudka.beans.User;
import ua.dudka.managers.MessageManager;
import ua.dudka.service.PasswordHelper;
import ua.dudka.store.DAO.Factory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RASTA on 19.04.2016.
 */
@Controller
public class MainController {
    @Autowired
    private Factory factory;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
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

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage() {
        return "/user/Edit";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String signUp(@ModelAttribute User user, ModelMap map) {
        if (factory.userDAO.contains(user.getUsername())) {
            map.addAttribute("errorSignUp", MessageManager.getProperty("message.signup.error"));
            return "/general/SignUp";
        }
        user.setRole(Role.ROLE_USER);
        user.setPassword(new PasswordHelper().encode(user.getPassword()));
        factory.userDAO.addUser(user);
        return "redirect:/main";
    }


    @RequestMapping(value = "/aboutBook", method = RequestMethod.GET)
    public String aboutBook(@RequestParam("book") String bookName, ModelMap model) {
        Book book = factory.bookDAO.getBook(bookName);
        model.addAttribute("book", book);
        User user = factory.userDAO.getUser(UserController.getPrincipal());
        if (user != null && user.hasBook(book)) {
            model.addAttribute("hasBook", true);
        }
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
