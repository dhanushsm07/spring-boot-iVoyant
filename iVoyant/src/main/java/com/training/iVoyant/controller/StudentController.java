package com.training.iVoyant.controller;

import com.training.iVoyant.entity.Student;
import com.training.iVoyant.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger logger =
            LoggerFactory.getLogger(StudentController.class);

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return service.getAllStudents();
    }


    @PostMapping
    public String addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return "Student added successfully";
    }

    //for partial name
    @GetMapping("/search/name")
    public List<Student> searchByNameContaining(@RequestParam String keyword) {
        return service.findByNameContaining(keyword);
    }

    //for full names
    @GetMapping("/search/exact-name")
    public List<Student> findStudentByName(@RequestParam String name) {
        return service.findStudentByName(name);
    }

    //partial email search
    @GetMapping("/search/email")
    public List<Student> searchByEmail(@RequestParam String email) {
        return service.searchByEmail(email);
    }
}
