package ua.dudka.servlets;

import ua.dudka.managers.ConfigurationManager;
import ua.dudka.managers.MessageManager;
import ua.dudka.beans.Book;

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
       /* Book book = BookCache.getInstance().getBook(req.getParameter("bookName"));
        try {
            ServletOutputStream outputStream = resp.getOutputStream();
            outputStream.write(book.getFile());
        } catch (IOException e) {
            //// TODO: 15.04.2016 add logger
            req.setAttribute("book", book);
            req.setAttribute("downloadError", MessageManager.getProperty("message.download.error"));
            req.getRequestDispatcher(ConfigurationManager.getProperty("path.page.aboutbook")).forward(req, resp);
        }*/
    }
}
