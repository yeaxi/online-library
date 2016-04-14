package ua.dudka.command;

import org.junit.Test;
import org.mockito.Mockito;
import ua.dudka.command.user.LoginCommand;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 18.03.2016.
 */
public class LoginCommandTest extends Mockito {

    @Test
    public void testExecute() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("login")).thenReturn("yeaxi");
        when(request.getParameter("password")).thenReturn("rostik1998");
        String page = new LoginCommand().execute(request);
        assertEquals("/views/Main.jsp", page);
    }
}