package ua.dudka.store.DAO;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by RASTA on 14.04.2016.
 */
public class Storage {
    private static Factory factory = new ClassPathXmlApplicationContext("spring-context.xml").getBean(Factory.class);
    public static UserDAO userDAO = factory.userDAO;
    public static BookDAO bookDAO = factory.bookDAO;
}
