package com.training.iVoyant.controller;

import com.training.iVoyant.entity.Student;
import com.training.iVoyant.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger logger =
            LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService service) {
        this.studentService = service;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        logger.info("Fetching all students");
        return ResponseEntity.ok(studentService.getAllStudents());
    }


    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        logger.info("Creating student with email {}", student.getEmail());
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    //for partial name
    @GetMapping("/search/name")
    public List<Student> searchByNameContaining(@RequestParam String keyword) {
        return studentService.findByNameContaining(keyword);
    }

    //for full names
    @GetMapping("/search/exact-name")
    public ResponseEntity<List<Student>> findStudentByName(@RequestParam String name) {
        List<Student> student = studentService.findStudentByName(name);
        return ResponseEntity.ok(student);
    }

    //partial email search
    @GetMapping("/search/email")
    public List<Student> searchByEmail(@RequestParam String email) {
        return studentService.searchByEmail(email);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        logger.info("Updating student with id {}", id);

        student.setId(id);
        Student updatedStudent = studentService.addStudent(student);

        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        logger.info("Deleting student with id {}", id);

        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {

        logger.info("Searching students: name={}, email={}", name, email);

        if (name != null) {
            return ResponseEntity.ok(
                    studentService.findByNameContaining(name));
        }

        if (email != null) {
            return ResponseEntity.ok(
                    studentService.searchByEmail(email));
        }

        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> patchStudent(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        Logger logger = LoggerFactory.getLogger(StudentController.class);
        logger.info("Partially updating student with id {}", id);

        Student updatedStudent = studentService.patchStudent(id, updates);

        return ResponseEntity.ok(updatedStudent);
    }
}
