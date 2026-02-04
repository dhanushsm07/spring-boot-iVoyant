package com.training.iVoyant.repository;

import com.training.iVoyant.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNameContaining(String keyword);

    //JPQL (Java Persistent Query Language)
    @Query("SELECT s FROM Student s WHERE s.name = :nameFromClient")
    List<Student> findStudentsByName(@Param("nameFromClient") String name);

    //Native Query Language
    @Query(value = "SELECT * FROM students WHERE email LIKE %:email%",
            nativeQuery = true)
    List<Student> searchByEmail(@Param("email") String email);

    Student getStudentById(Long id);
}
