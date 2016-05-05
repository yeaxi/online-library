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
import ua.dudka.store.DAO.Factory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


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
    public String editUser(@ModelAttribute User user) {
        User current = factory.userDAO.getUser(getPrincipal());
        current.setName(user.getName());
        current.setSurname(user.getSurname());
        current.setAge(user.getAge());
        current.setSex(user.getSex());
        factory.userDAO.updateUser(current);
        return "redirect:/user/profile";
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
        response.setHeader("Content-disposition", "attachment; filename " + bookName);

        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            stream.write(bytes);

            ServletOutputStream outputStream = response.getOutputStream();
            stream.writeTo(outputStream);
            outputStream.flush();
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
            //// TODO: 03.05.2016 add logger
        }
        return "redirect:/main";
    }


    public static String getPrincipal() {
        String login;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal.equals("anonymousUser")) {
            return "";
        } else if (principal instanceof UserDetails) {
            login = ((UserDetails) principal).getUsername();
        } else {
            login = principal.toString();
        }
        return login;
    }
}
