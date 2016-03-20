package store.DAO;

import models.Book;
import models.User;
import org.hibernate.*;
import store.util.HibernateUtil;

import java.util.Collection;
import java.util.List;

/**
 * Created by RASTA on 15.03.2016.
 */
class BookDAOImpl implements BookDAO {
    private final SessionFactory factory;

    public BookDAOImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    public Collection<Book> getBooks() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Book").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    public Collection getBooksByUser(User user) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Integer user_id = user.getCode();
            Query query = session.createQuery("" +
                    "select b from Book  b INNER JOIN b.users user where user.id=:userId").setInteger("userId", user_id);
            return (List<Book>) query.list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void addBook(Book book) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(book);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void updateBook(Book book) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(book);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void deleteBook(Book book) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(book);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public Book getBook(String bookName) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("from Book as book where book.name=:name").setString("name", bookName);
            return (Book) query.iterate().next();
        } finally {
            tx.commit();
            session.close();
        }
    }
}

