package ua.dudka.command;

import ua.dudka.command.user.AboutUserCommand;
import org.junit.Test;
import org.mockito.Mockito;
import ua.dudka.beans.Book;

import javax.servlet.http.HttpServletRequest;

import java.util.Set;

/**
 * Created by RASTA on 17.03.2016.
 */
public class AboutUserCommandTest extends Mockito {

    @Test
    public void testExecute() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getAttribute("login")).thenReturn("yeaxi");
        new AboutUserCommand().execute(request);
        Set<Book> books = (Set<Book>) request.getAttribute("books");
        for (Book book : books) {
            System.out.println(book);
        }

    }
}