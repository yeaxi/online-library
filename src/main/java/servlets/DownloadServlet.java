package servlets;

import managers.ConfigurationManager;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
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

        ServletOutputStream outputStream = resp.getOutputStream();
        String filePath = CONTEXT_PATH + req.getParameter("path");
        FileInputStream inputStream = new FileInputStream(filePath);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        outputStream.write(bytes);
        inputStream.close();
    }
}
