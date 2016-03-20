package managers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 16.03.2016.
 */
public class ConfigurationManagerTest {

    @Test
    public void testGetProperty() throws Exception {
        assertEquals("/views/Main.jsp", ConfigurationManager.getProperty("path.page.main"));
    }
}