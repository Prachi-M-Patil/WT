package com.example.withoutdao.controller;


import com.example.withoutdao.model.Book;
import com.example.withoutdao.model.IssueRecord;
import com.example.withoutdao.model.Librarian;
import com.example.withoutdao.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {
    Librarian librarian ;
    List<IssueRecord> booksIssued = new ArrayList<>();
    @PostMapping
    @ResponseBody
    public boolean createLibrarian(Librarian librarian) {
        this.librarian = librarian;
        return true;
    }
    @GetMapping
    @ResponseBody
    public Librarian showLibrarian() {
        return librarian;
    }
    @PostMapping("/issue")
    @ResponseBody
    public boolean issueBook(@RequestBody IssueRecord issueRecord) {
        List<Student> students= StudentController.students;
        List<Book> books= BookController.books;
        boolean studentFound= false;
        boolean bookFound= false;
        for(Student student : students) {
            if (student.getPrn() == issueRecord.getPrn()) {
                studentFound = true;
                break;
            }
        }
        for(Book book : books) {
            if(book.getAccessionNumber()== issueRecord.getAcc_no()){
                bookFound = true;
                break;
            }
        }
        if(studentFound && bookFound) {
            booksIssued.add(issueRecord);
            return true;
        }

        return false;
    }
    @GetMapping("/issuedbooks")
    @ResponseBody
    public List<IssueRecord> getBooksIssued() {
        return booksIssued;
    }

}
