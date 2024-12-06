package org.example.springboot_usingdao.controller;

import org.example.springboot_usingdao.model.Book;
import org.example.springboot_usingdao.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookRepo bookRepo;

    @PostMapping("/createBook")
    public String createBook(@RequestBody Book book) {
        bookRepo.save(book);
        return "Book created";
    }

    @GetMapping("/getBook")
    public List<Book> getBookList() {
        return bookRepo.findAll();
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestBody Book book) {
        if (bookRepo.existsById(book.getAssNo())) {
            bookRepo.deleteById(book.getAssNo());
            return "Book deleted";
        } else {
            return "Book not found";
        }
    }

    @PatchMapping("/updateBook")
    public String updateBook(@RequestBody Book book) {
        return bookRepo.findById(book.getAssNo()).map(existingBook -> {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());
            bookRepo.save(existingBook);
            return "Book updated";
        }).orElse("Book not found");
    }
}
