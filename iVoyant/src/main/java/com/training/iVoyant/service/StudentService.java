package com.training.iVoyant.service;

import com.training.iVoyant.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void addStudent(Student student);
    List<Student> findByNameContaining(String keyword);
    List<Student> findStudentByName(String name);
    List<Student> searchByEmail(String email);
}
