package store.DAO;

import models.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import store.util.HibernateUtil;

import java.util.Collection;


/**
 * Created by RASTA on 15.03.2016.
 */
class UserDAOImpl implements UserDAO {
    private final SessionFactory factory;

    public UserDAOImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    public void addUser(User user) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(user);
        } finally {
            tx.commit();
            session.close();

        }
    }

    public Collection<User> getAllUsers() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from User").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    public User getUser(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (User) session.load(User.class, id);
        } finally {
            tx.commit();
            session.close();
        }
    }


    public User getUser(String login) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            final Query query = session.createQuery("from User as user where user.login=:login");
            query.setString("login", login);
            return (User) query.iterate().next();
        } finally {
            tx.commit();
            session.close();
        }
    }


    public void updateUser(User user) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(user);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public boolean contains(String login) {
        return getUser(login) != null;
    }

    public void close() {
        factory.close();
    }
}
