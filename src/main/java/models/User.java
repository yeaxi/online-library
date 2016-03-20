package models;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RASTA on 13.03.2016.
 */
public class User {
    private static int id = (int) (Math.random() * 1000000);
    private int code = id;
    private String login;
    private String password;
    private Set<Book> books = new HashSet();

    public User(String login, String password) {
        ++id;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }

    public void removeBook(Book book) {
        Book current = new Book();
        if (hasBook(book)) {
            for (Book entry : books) {
                if (entry.getName().equals(book.getName())) {
                    current = entry;
                }
            }
            books.remove(current);
        }
    }

    public boolean hasBook(Book book) {

        return books.contains(book);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (code != user.code) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
