package com.training.iVoyant.service;

import com.training.iVoyant.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> getAllStudents();
    Student addStudent(Student student);
    List<Student> findByNameContaining(String keyword);
    List<Student> findStudentByName(String name);
    List<Student> searchByEmail(String email);

    void deleteStudent(Long id);

    Student patchStudent(Long id, Map<String, Object> updates);
}
