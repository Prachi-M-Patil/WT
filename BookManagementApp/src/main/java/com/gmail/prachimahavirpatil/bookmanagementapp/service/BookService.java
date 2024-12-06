package com.gmail.prachimahavirpatil.bookmanagementapp.service;

import com.gmail.prachimahavirpatil.bookmanagementapp.Model.Book;
import com.gmail.prachimahavirpatil.bookmanagementapp.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


}
