package org.example.springboot_usingdao.controller;

import org.example.springboot_usingdao.model.Student;
import org.example.springboot_usingdao.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class studentController {
    @Autowired
    StudentRepo studentRepo;
     static public List<Student> studentList = new ArrayList<>();
    @PostMapping("/createStudent")
    public String createStudent(@RequestBody Student student) {
        studentRepo.save(student);
        return "Student created successfully!";
    }

    @GetMapping("/getStudent")
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }


    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestBody Student student){
        Student newStudent=null;
        boolean exist=false;
        for(Student s:studentList) {

            if (s.getPrn() == student.getPrn()) {
                exist = true;
                newStudent = s;
            }
        }
            if (exist) {
                studentList.remove(newStudent);
                return "Student deleted successfully!";
            } else {
                return "Student not deleted!";
            }



    }

    @PatchMapping("/updateStudent")
    public List<Student> updateStudent(@RequestBody Student student){
        studentList.forEach(s -> {
            if(s.getPrn() == student.getPrn()){
                s.setName(student.getName());
                s.setAge(student.getAge());

            }
        });
        return studentList;
    }

}
