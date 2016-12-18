package com.service.impl;

import com.dao.BookDao;
import com.entities.Book;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andry on 08/12/2016.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    public List<Book> list() {
        return bookDao.list();
    }

    public void delete(Book book) {
        bookDao.delete(book);
    }

    public void saveOrUpdate(Book book) {
        bookDao.saveOrUpdate(book);
    }

    public Book getBooks(int id){
        return bookDao.getBooks(id);
    }
}
