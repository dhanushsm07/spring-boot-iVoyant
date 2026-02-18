package com.training.iVoyant.service;

import com.training.iVoyant.entity.Student;
import com.training.iVoyant.exceptions.StudentNotFoundException;
import com.training.iVoyant.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }


    @Override
    public Student addStudent(Student student) {
        repository.save(student);
        return student;
    }


    @Override
    public List<Student> findByNameContaining(String keyword) {
        return repository.findByNameContaining(keyword);
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return repository.findStudentsByName(name);
    }

    @Override
    public List<Student> searchByEmail(String email) {
        return repository.searchByEmail(email);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = repository.getStudentById(id);
        repository.delete(student);
    }

    @Override
    public Student patchStudent(Long id, Map<String, Object> updates) {
        return null;
    }

}
