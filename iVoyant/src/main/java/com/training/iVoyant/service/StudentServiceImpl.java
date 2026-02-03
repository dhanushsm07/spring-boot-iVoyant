package com.training.iVoyant.service;

import com.training.iVoyant.entity.Student;
import com.training.iVoyant.exceptions.StudentNotFoundException;
import com.training.iVoyant.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public void addStudent(Student student) {
        repository.save(student);
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


}
