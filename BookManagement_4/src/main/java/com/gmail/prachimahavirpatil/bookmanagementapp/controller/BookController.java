package com.gmail.prachimahavirpatil.bookmanagementapp.controller;

import com.gmail.prachimahavirpatil.bookmanagementapp.Model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private final List<Book> bookList;

    // Initialize with hardcoded values
    public BookController() {
        this.bookList = new ArrayList<>();
        bookList.add(new Book(1, "Book One", "Author One", 250.50, 2020));
        bookList.add(new Book(2, "Book Two", "Author Two", 150.75, 2018));
        bookList.add(new Book(3, "Book Three", "Author Three", 300.00, 2022));
    }

    // Retrieve all books
    @GetMapping("/")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookList);
        return "book-list"; // Refers to book-list.html
    }

    // Retrieve a particular book by ID
    @GetMapping("/book/{id}")
    public String getBookById(@PathVariable int id, Model model) {
        Book book = bookList.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("book", book);
        return "book-details"; // Refers to book-details.html
    }

    // Form to add a new book
    @GetMapping("/addBook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book(0, "", "", 0.0, 0)); // Initialize empty Book object
        return "add-book"; // Refers to add-book.html
    }

    // Add a new book to the list
    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book) {
        // Generate unique ID for the new book
        book.setId(bookList.size() + 1);
        bookList.add(book);
        return "redirect:/"; // Redirect to the homepage to view updated list
    }
}
