//B27
package org.example.library.controller;

import jakarta.servlet.http.HttpSession;
import org.example.library.model.Book;
import org.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getBooks(HttpSession session, Model model) {
        if (!isSessionValid(session)) {
            return "redirect:/login";
        }
        String role = (String) session.getAttribute("role");
        if ("Librarian".equals(role) || "student".equals(role)) {
            List<org.example.library.model.Book> books = bookService.getAllBooks();
            model.addAttribute("books", books);
            return "viewBooks";
        }
        return "redirect:/welcome";
    }

    @PostMapping
    public String addBook(@RequestBody final Book book, HttpSession session, Model model) {
        if (!isSessionValid(session)) {
            return "redirect:/login";
        }
        String role = (String) session.getAttribute("role");
        if ("Librarian".equals(role) || "student".equals(role)) {
            return "redirect:/welcome";
        }
        bookService.addBook(book);
        model.addAttribute("message", "Book added successfully");
        return "addBook";

    }


    private boolean isSessionValid(HttpSession session) {
        return session.getAttribute("email") != null;
    }
}