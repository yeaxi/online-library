package command;

import command.book.AboutBookCommand;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 17.03.2016.
 */
public class AboutBookCommandTest extends Mockito {

    @Test
    public void testExecute() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("bookName")).thenReturn("Бойцовский клуб");
        String page = new AboutBookCommand().execute(request);
        assertEquals("/views/AboutBook.jsp",page);

    }
}