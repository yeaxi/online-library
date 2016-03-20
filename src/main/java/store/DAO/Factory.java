package store.DAO;

/**
 * Created by RASTA on 15.03.2016.
 */
public class Factory {
    private static UserDAO userDAO = null;
    private static BookDAO bookDAO = null;
    private static Factory instance = null;

    private Factory() {

    }

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }

    public BookDAO getBookDAO() {
        if (bookDAO == null) {
            bookDAO = new BookDAOImpl();
        }
        return bookDAO;
    }
}
