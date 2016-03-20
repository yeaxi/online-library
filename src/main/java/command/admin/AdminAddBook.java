package command.admin;

import command.ActionCommand;
import managers.ConfigurationManager;
import managers.MessageManager;
import models.Book;
import org.apache.commons.io.IOUtils;
import store.cache.BookCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;

/**
 * Created by RASTA on 17.03.2016.
 */
public class AdminAddBook implements ActionCommand {
    private static final BookCache CACHE = BookCache.getInstance();
    private static final String ABSOLUTE_PATH = ConfigurationManager.getProperty("path.resources.books");

    public String execute(HttpServletRequest req) {
        String page;
        String bookName = req.getParameter("bookName");
        if (!CACHE.contains(bookName)) {
            Book book = initBook(req);
            CACHE.addBook(book);
            req.setAttribute("successAddingBook", MessageManager.getProperty("message.addbook.success"));
        } else {
            req.setAttribute("errorAddingBook", MessageManager.getProperty("message.addbook.hasbook"));
        }
        page = ConfigurationManager.getProperty("path.page.admin");
        return page;
    }

    private Book initBook(HttpServletRequest req) {
        String bookName = req.getParameter("bookName");
        String author = req.getParameter("author");
        String genre = req.getParameter("genre");
        String description = req.getParameter("description");
        Part filePart = null;
        try {
            filePart = req.getPart("file");
        } catch (IOException | ServletException e) {
            return null;
        }
        Book book = new Book(bookName, author);
        book.setGenre(genre);
        book.setDescription(description);
        book.setFilePath(createFile(filePart));
        return book;
    }

    private String createFile(Part part) {
        if (part == null) {
            return null;
        }
        File pdfFile = null;
        try {
            String pdfFileName = part.getSubmittedFileName();
            pdfFile = new File(ABSOLUTE_PATH + pdfFileName);
            InputStream input = part.getInputStream();
            byte[] fileBytes = IOUtils.toByteArray(input);
            OutputStream outputStream = new FileOutputStream(pdfFile);
            outputStream.write(fileBytes);
            outputStream.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pdfFile.getName();
    }
}
