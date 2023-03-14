package com.mycompany.spring3.service;

import com.mycompany.spring3.model.Student;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>();

    @Autowired
    private ObservationRegistry observationRegistry;
    public Student addStudent(Student student) {

        students.add(student);
        return Observation.createNotStarted("addStudent", observationRegistry)
                .observe(()-> student);
    }

    public List<Student> getAllStudents() {

        return Observation.createNotStarted("getAllStudents", observationRegistry)
                .observe(()-> students);
    }


    public Student getStudentById(String id) {

        return Observation.createNotStarted("addStudent", observationRegistry)
                .observe(()-> students.stream().filter(student -> student.id().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Student is not available")));
    }
}
