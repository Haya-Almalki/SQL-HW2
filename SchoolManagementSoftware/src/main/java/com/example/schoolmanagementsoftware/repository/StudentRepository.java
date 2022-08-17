package com.example.schoolmanagementsoftware.repository;

import com.example.schoolmanagementsoftware.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id);
    Student findStudentByName(String name);
    List<Student> findStudentByMajor(String major);
    List<Student> findByAgeGreaterThanEqual(Integer age);
}
