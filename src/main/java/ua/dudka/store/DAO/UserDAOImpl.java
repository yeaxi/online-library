package ua.dudka.store.DAO;

import org.springframework.stereotype.Repository;
import ua.dudka.models.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.dudka.store.util.HibernateUtil;

import java.util.Collection;


/**
 * Created by RASTA on 15.03.2016.
 */
@Repository
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
            session.merge(user);
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
