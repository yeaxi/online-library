package ua.dudka.store.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RASTA on 15.03.2016.
 */
@Service
class Factory {
    public final UserDAO userDAO;
    public final BookDAO bookDAO;

    @Autowired
    public Factory(UserDAO userDAO, BookDAO bookDAO) {
        this.userDAO = userDAO;
        this.bookDAO = bookDAO;
    }
}
