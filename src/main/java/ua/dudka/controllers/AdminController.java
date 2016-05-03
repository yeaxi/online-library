package ua.dudka.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.dudka.beans.Book;
import ua.dudka.beans.User;
import ua.dudka.store.DAO.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by RASTA on 19.04.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private Factory factory;


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

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String uploadFile(@RequestParam String book, @RequestParam String author, @RequestParam String genre, @RequestParam MultipartFile file) {

        Book current = new Book(book, author, genre);
        try {
            current.setFile(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();//// TODO: 03.05.2016 add logger
        }
        factory.bookDAO.addBook(current);
        return "redirect:/main";
    }
}
