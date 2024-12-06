package com.example.withoutdao.controller;

import com.example.withoutdao.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    static List<Book> books= new ArrayList<Book>();
    @PostMapping("/createBook")
    @ResponseBody
    public Boolean createBook( @RequestBody Book book){
        books.add(book);
        return true;
    }
    @GetMapping("/getBooks")
    @ResponseBody
    public List<Book> getBooks(){
        return books;
    }


}
