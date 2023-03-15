package com.mycompany.spring3.controller.client;

import com.mycompany.spring3.model.Student;
import com.mycompany.spring3.service.client.StudentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client/studentController")
public class StudentClientController {

    @Autowired
    private StudentClientService studentClientService;

    @GetMapping
    List<Student> getAllStudents() {
        return studentClientService.getAllStudents();
    }
}
