package com.deloitte.springmvcdemo.service.impl;

import com.deloitte.springmvcdemo.entity.Book;
import com.deloitte.springmvcdemo.repository.BookRepository;
import com.deloitte.springmvcdemo.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FilmServiceImpl {
    @Autowired
    BookRepository filmRepository;


    @Override
    public Book findBookById(Long id) {
        return FilmRepository.findFilmById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return BookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book bookById = BookRepository.findBookById(id);
        if (bookById != null) {
            bookById.setAuthor(book.getAuthor());
            bookById.setTitle(book.getTitle());
            return saveBook(book);
        }
        return null;
    }

    @Override
    public void deleteFilmById(Long id) {
        bookRepository.deleteFilmById(id);
    }
}
