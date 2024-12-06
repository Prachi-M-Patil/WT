package org.example.springboot_usingdao.controller;

import org.example.springboot_usingdao.model.Book;
import org.example.springboot_usingdao.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class bookWebController {
    @Autowired
    BookRepo bookRepo;
    static public List<Book> BookList = new ArrayList<>();

    @GetMapping("/createNewBook/method")
    public String createBook() {
        return "method";
    }

    @PostMapping("/createNewBooks")
    public String createBook(@RequestParam("assNo")int assNo,
                             @RequestParam("title")String title,
                             @RequestParam("author") String author,
                             @RequestParam("price")int price) {
        Book book = new Book();
        book.setAssNo(assNo);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);

        bookRepo.save(book);
        BookList.add(book);
        return "msg";
    }


    @GetMapping("/book-list")
    public  List<Book> getBooks() {
        return BookList;
    }

}
