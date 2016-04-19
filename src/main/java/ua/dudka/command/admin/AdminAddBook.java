package ua.dudka.command.admin;

import ua.dudka.command.ActionCommand;
import ua.dudka.managers.ConfigurationManager;
import ua.dudka.managers.MessageManager;
import ua.dudka.beans.Book;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;

/**
 * Created by RASTA on 17.03.2016.
 */
public class AdminAddBook implements ActionCommand {
//    private static final BookCache CACHE = BookCache.getInstance();

    public String execute(HttpServletRequest req) {
        String page;
        String bookName = req.getParameter("bookName");
       /* if (!CACHE.contains(bookName)) {
            Book book = initBook(req);
            CACHE.addBook(book);
            req.setAttribute("successAddingBook", MessageManager.getProperty("message.addbook.success"));
        } else {
            req.setAttribute("errorAddingBook", MessageManager.getProperty("message.addbook.hasbook"));
        }*/
        page = ConfigurationManager.getProperty("path.page.admin");
        return page;
    }

    private Book initBook(HttpServletRequest req) {
        String bookName = req.getParameter("bookName");
        String author = req.getParameter("author");
        String genre = req.getParameter("genre");
        String description = req.getParameter("description");
        Part filePart;
        try {
            filePart = req.getPart("file");
        } catch (IOException | ServletException e) {
            //// TODO: 15.04.2016 add logger
            return null;
        }
        Book book = new Book(bookName, author, genre);
        book.setDescription(description);
        book.setFile(getBytes(filePart));
        return book;
    }

    private byte[] getBytes(Part part) {
        byte[] fileBytes = null;
        try {
            InputStream input = part.getInputStream();
            fileBytes = IOUtils.toByteArray(input);
            input.close();
        } catch (IOException e) {
            //// TODO: 15.04.2016 Add logger
        }
        return fileBytes;
    }
}
