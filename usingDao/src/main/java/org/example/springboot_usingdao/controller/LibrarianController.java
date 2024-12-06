package org.example.springboot_usingdao.controller;


import org.example.springboot_usingdao.model.Book;
import org.example.springboot_usingdao.model.Librarian;
import org.example.springboot_usingdao.model.Library;
import org.example.springboot_usingdao.model.Student;
import org.example.springboot_usingdao.repository.BookRepo;
import org.example.springboot_usingdao.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class LibrarianController {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    StudentRepo studentRepo;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody Library library) {
        if (studentRepo.findById(library.getPrn()).isPresent() && bookRepo.findById(library.getId()).isPresent()) {
            Book book = bookRepo.findById(library.getId()).orElse(null);


            if (book.getStudent() == null) {
                assert book != null;
                book.setStudent(studentRepo.findById(library.getPrn()).orElse(null));

                bookRepo.save(book);
            }else if(book.getStudent().getPrn() == library.getPrn()){
                return "This book is already issued to this student";
            }

            else {
                return "This book is assigned to another student";
            }


        } else {
            return "Either student or book is not present";
        }

        return "Librarian created";
    }


    @DeleteMapping("/collectBook")
    public String collectBook(@RequestBody Library library) {
        if (studentRepo.findById(library.getPrn()).isPresent() && bookRepo.findById(library.getId()).isPresent()) {

            Book book = bookRepo.findById(library.getId()).orElse(null);
            if (book.getStudent().getPrn() == library.getPrn()) {
                assert book != null;
                book.setStudent(null);
                bookRepo.save(book);
            } else {
                return "Book is issued to another student";
            }
        } else {
            return "Either student or book is not present";
        }
        return "Book collected";
    }


}

