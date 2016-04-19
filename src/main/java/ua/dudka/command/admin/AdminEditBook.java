package ua.dudka.command.admin;

import org.apache.commons.io.IOUtils;
import ua.dudka.beans.Book;
import ua.dudka.command.ActionCommand;
import ua.dudka.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by RASTA on 15.04.2016.
 */
public class AdminEditBook implements ActionCommand {
//    private static final BookCache CACHE = BookCache.getInstance();

    @Override
    public String execute(HttpServletRequest req) {
        String page;
        Book book = initBook(req);
//        CACHE.updateBook(book);
        page = ConfigurationManager.getProperty("path.page.admin");
        return page;
    }

    private Book initBook(HttpServletRequest req) {
       /* String bookName = req.getParameter("bookName");
//        Book book = CACHE.getBook(bookName);
        req.setAttribute("book", book);
        String newBookName = req.getParameter("newBookName");
        if (newBookName.length() != 0) {
            book.setName(newBookName);
            book.setGenre(req.getParameter("newAuthor"));
            book.setAuthor(req.getParameter("newAuthor"));
            book.setDescription(req.getParameter("newDescription"));
            Part filePart = null;
            try {
                filePart = req.getPart("newFile");
            } catch (Exception e) {
                //// TODO: 15.04.2016 logger
            }
            book.setFile(getBytes(filePart));
        }
        return book;*/
        return null;
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
