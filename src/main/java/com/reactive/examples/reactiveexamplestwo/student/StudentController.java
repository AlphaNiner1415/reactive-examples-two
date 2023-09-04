package com.reactive.examples.reactiveexamplestwo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Controller class that has all resources for our API
@RestController
@RequestMapping(path = "api/v1/student") //This will attach the path var to the URL
public class StudentController {

    private final StudentService studentService;

    @Autowired //Can auto instantiate a class for you as long as it's a bean (do that by @Component annotation on that class)
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //If you have @RequestMapping above, and you don't want to add more to endpoint,
    //take out the ('/') for @GetMapping
    @GetMapping("/")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
