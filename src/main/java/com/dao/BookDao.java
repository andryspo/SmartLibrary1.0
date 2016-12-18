package com.dao;

import com.entities.Book;

import java.util.List;

/**
 * Created by andry on 08/12/2016.
 */
public interface BookDao {
    List<Book> list();

    void delete(Book book);

    void saveOrUpdate(Book book);

    Book getBooks(int id);
}
