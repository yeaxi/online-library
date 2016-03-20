package managers;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by RASTA on 16.03.2016.
 */
public class MessageManager {
    private static final String FILENAME = "messages.properties";
    private static final Properties properties = new Properties();

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(FILENAME);
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
