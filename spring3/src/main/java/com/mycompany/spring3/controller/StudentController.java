package com.mycompany.spring3.controller;

import com.mycompany.spring3.model.Student;
import com.mycompany.spring3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentController")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {

        return studentService.getStudentById(id);
    }
}
