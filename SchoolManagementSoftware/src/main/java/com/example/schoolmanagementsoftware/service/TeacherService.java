package com.example.schoolmanagementsoftware.service;

import com.example.schoolmanagementsoftware.exception.ApiException;
import com.example.schoolmanagementsoftware.model.Teacher;
import com.example.schoolmanagementsoftware.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Teacher teacher, Integer id){
        Teacher old=teacherRepository.getReferenceById(id);
        old.setName(teacher.getName());
        old.setSalary(teacher.getSalary());
        teacherRepository.save(old);
    }
    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.getReferenceById(id);
        teacherRepository.delete(teacher);
    }
    //Create endpoint that takes teacher id
    // and return one teacher (return bad request if teacher id is invalid

    public Teacher getTeacherById(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if (teacher==null) {
            throw new ApiException("Wrong Id");
        }
            return teacher;
    }
    //Create endpoint that takes teacher salary
    // and return all teachers who have this salary or above
    public List<Teacher> getTeacherBySalary(Integer salary){
        List <Teacher>teachers=teacherRepository.findBySalaryGreaterThanEqual(salary);
        return teachers;
    }

}
