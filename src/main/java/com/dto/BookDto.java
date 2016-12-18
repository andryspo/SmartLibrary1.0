package com.dto;

import com.entities.Book;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by andry on 14/12/2016.
 */
public class BookDto {

    private int id;

    private String title;

    private String author;

    private int pages;

    private String genre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Book getBook() {
        Book book = new Book();
        book.setId(id);
        book.setAuthor(author);
        book.setPages(pages);
        book.setGenre(genre);
        book.setTitle(title);
        return book;
    }
}
