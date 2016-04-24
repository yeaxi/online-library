package ua.dudka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.dudka.beans.Book;
import ua.dudka.beans.User;
import ua.dudka.managers.MessageManager;
import ua.dudka.store.DAO.Factory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.getFile;

/**
 * Created by RASTA on 19.04.2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private Factory factory;


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(ModelMap map) {
        User user = factory.userDAO.getUser(getPrincipal());
        map.addAttribute("user", user);
        return "/user/Profile";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute User user, ModelMap map) {
        factory.userDAO.updateUser(user);
        map.addAttribute("user", user);
        return "/user/Profile";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBook(@RequestParam String bookName) {
        User user = factory.userDAO.getUser(getPrincipal());
        Book book = factory.bookDAO.getBook(bookName);
        user.addBook(book);
        factory.userDAO.updateUser(user);
        return "redirect:/main";
    }

    @RequestMapping(value = "/removeBook", method = RequestMethod.GET)
    public String removeBook(@RequestParam String bookName) {
        User user = factory.userDAO.getUser(getPrincipal());
        Book book = factory.bookDAO.getBook(bookName);
        user.removeBook(book);
        factory.userDAO.updateUser(user);
        return "redirect:/main";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String download(@RequestParam String bookName, HttpServletResponse response) {

        Book book = factory.bookDAO.getBook(bookName);
        byte[] bytes = book.getFile();
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename" + bookName);


        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            stream.write(bytes);

            ServletOutputStream outputStream = response.getOutputStream();
            stream.writeTo(outputStream);
            outputStream.flush();
            outputStream.flush();
        } catch (IOException e) {

        }
        return "/general/Main";
    }


    public static String getPrincipal() {
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
