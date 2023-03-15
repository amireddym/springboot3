package com.mycompany.spring3.service.client;

import com.mycompany.spring3.model.Student;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/studentController")
public interface StudentClientService {

    @GetExchange
    List<Student> getAllStudents();

}
