package com.example.withoutdao.controller;

import com.example.withoutdao.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    static List<Student> students= new ArrayList<>();
    @PostMapping
    @ResponseBody
    public boolean createStudent(@RequestBody Student student) {
        students.add(student);
        return true;
    }

    @GetMapping
    @ResponseBody
    public List<Student> getStudents() {
        return students;
    }
}

