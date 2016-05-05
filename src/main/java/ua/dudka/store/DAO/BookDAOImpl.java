package ua.dudka.store.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dudka.beans.Book;
import ua.dudka.beans.User;

import java.util.Collection;

/**
 * Created by RASTA on 15.03.2016.
 */
@Repository
class BookDAOImpl implements BookDAO {
    private final HibernateTemplate template;

    @Autowired
    public BookDAOImpl(final HibernateTemplate hibernateTemplate) {
        this.template = hibernateTemplate;
    }

    public Collection<Book> getBooks() {
        return template.loadAll(Book.class);
    }

    public Collection getBooksByUser(User user) {
        return template.find("select b from Book  b INNER JOIN b.users user where user.id=?", user.getId());

    }

    @Transactional
    public void addBook(Book book) {
        template.save(book);
    }

    @Transactional
    public void updateBook(Book book) {
        template.update(book);

    }

    @Transactional
    public void deleteBook(Book book) {
        template.delete(book);
    }

    public Book getBook(String bookName) {
        return (Book) template.find("from Book as b where b.name=?", bookName).get(0);
    }
}

