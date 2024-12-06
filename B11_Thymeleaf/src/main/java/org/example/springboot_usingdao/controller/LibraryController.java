//package org.example.springboot_usingdao.controller;
//
//
//import org.example.springboot_usingdao.model.Book;
//import org.example.springboot_usingdao.model.Library;
//import org.example.springboot_usingdao.model.Student;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.example.springboot_usingdao.controller.BookController.BookList;
//import static org.example.springboot_usingdao.controller.studentController.studentList;
//
//
//@RestController
//public class LibraryController {
//
//
//    List<Library> libraryList=new ArrayList<>();
//
//    @PostMapping("/library/issueBook")
//    public String issueBook(@RequestBody Library library) {
//        boolean bookexist=false;
//        boolean studentexist=false;
//        for(Book b:BookList) {
//            if(b.getAssNo()==library.getId()){
//                bookexist=true;
//
//            }
//        }
//
//
//        for(Student s:studentList){
//            if(s.getPrn()==library.getPrn()){
//                studentexist=true;
//            }
//        }
//
//        if(bookexist && studentexist){
//            libraryList.add(library);
//            return "Book issued sucessfully";
//        }else{
//            return "Book not issued sucessfully";
//        }
//
//    }
//    @GetMapping("/library/getIssuedBooks")
//    public List<Library> getLibraryList() {
//        return libraryList;
//    }
//
//    @DeleteMapping("/library/collectBook")
//    public String CollectBook(@RequestBody Library library) {
//        Library lib=null;
//        boolean bookissued=false;
//
//        for(Library l:libraryList){
//            if(library.getId()==l.getId()) {
//                bookissued=true;
//                lib=l;
//
//            }
//        }
//        if(bookissued){
//            libraryList.remove(lib);
//            return "Book collected sucessfully";
//        }else{
//            return "Book is not issued";
//        }
//    }
//}
