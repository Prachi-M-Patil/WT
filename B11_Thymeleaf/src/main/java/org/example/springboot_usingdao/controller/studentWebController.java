package org.example.springboot_usingdao.controller;


import org.example.springboot_usingdao.model.Student;
import org.example.springboot_usingdao.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class studentWebController {

    private final StudentRepo studentRepo;

    public studentWebController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping("createStudent/signUp")
    public String createStudent() {

        return "signUp";
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestParam("name") String name,
                             @RequestParam("prn") int prn,
                             @RequestParam("age") int age
                            ) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setPrn(prn);

        studentRepo.save(student);

        return "message";
    }


    @GetMapping("/studentList")
    public List<Student> studentList(Model model) {
        List<Student> studentList =studentRepo.findAll();
        model.addAttribute("studentList", studentList);
        return studentList;
    }


}
