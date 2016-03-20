package servlets;

import managers.ConfigurationManager;
import managers.MessageManager;
import models.Book;
import store.cache.BookCache;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by RASTA on 20.03.2016.
 */
@WebServlet("/downloader")
public class DownloadServlet extends HttpServlet {
    private static final String CONTEXT_PATH = ConfigurationManager.getProperty("path.resources.books");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = BookCache.getInstance().getBook(req.getParameter("bookName"));
        String filePath = CONTEXT_PATH + book.getFilePath();
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            ServletOutputStream outputStream = resp.getOutputStream();
            outputStream.write(bytes);

        } catch (IOException e) {
            req.setAttribute("book", book);
            req.setAttribute("downloadError", MessageManager.getProperty("message.download.error"));
            req.getRequestDispatcher(ConfigurationManager.getProperty("path.page.aboutbook")).forward(req, resp);
            return;
        }
    }
}
