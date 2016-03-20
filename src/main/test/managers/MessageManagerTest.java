package managers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 16.03.2016.
 */
public class MessageManagerTest {

    @Test
    public void testGetProperty() throws Exception {
        assertEquals("Login or password is invalid!", MessageManager.getProperty("message.loginerror"));
    }
}