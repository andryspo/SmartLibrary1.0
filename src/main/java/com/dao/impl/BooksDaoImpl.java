package com.dao.impl;

import com.dao.BookDao;
import com.entities.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BooksDaoImpl implements BookDao {

    private final SessionFactory session;

    @Autowired
    public BooksDaoImpl(SessionFactory session) {
        this.session = session;
    }

    public List<Book> list() {
        return session.getCurrentSession().createCriteria(Book.class).list();
    }

    public Book getBooks(int id) {
        return (Book) session.getCurrentSession().get(Book.class, id);
    }

    public void delete(Book book) {
            session.getCurrentSession().delete(book);
    }

    public void saveOrUpdate(Book book) {
        session.getCurrentSession().saveOrUpdate(book);
    }
}
