package com.example.schoolmanagementsoftware.repository;

import com.example.schoolmanagementsoftware.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);
    List<Teacher> findBySalaryGreaterThanEqual(Integer salary);

}
