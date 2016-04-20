package ua.dudka.servlets;

import ua.dudka.models.Book;
import ua.dudka.store.cache.BookCache;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RASTA on 20.03.2016.
 */
@WebServlet("/downloader")
public class DownloadServlet extends HttpServlet {

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
        byte[] bytes = book.getFile();
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(bytes);

    }
}
