package com.example.schoolmanagementsoftware.service;

import com.example.schoolmanagementsoftware.exception.ApiException;
import com.example.schoolmanagementsoftware.model.Student;
import com.example.schoolmanagementsoftware.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public void updateStudent(Student student,Integer id){
        Student old=studentRepository.getReferenceById(id);
        old.setName(student.getName());
        old.setAge(student.getAge());
        old.setMajor(student.getMajor());
        studentRepository.save(old);
    }
    public void deleteStudent(Integer id){
        Student student=studentRepository.getReferenceById(id);
        studentRepository.delete(student);
    }
    //Create endpoint that takes student id
    // and return one student (return bad request if student id is invalid)
    public Student getStudentById(Integer id){
        Student student=studentRepository.findStudentById(id);
        if(student==null){
            throw new ApiException("Invalid id!");
        }
        return student;
    }
    //Create endpoint that takes student name
    // and return one student (return bad request if student name is invalid)
    public Student getStudentByName(String name){
        Student student=studentRepository.findStudentByName(name);
        if(student ==null){
            throw new ApiException("student name is invalid");
        }
        return student;
    }
    //Create endpoint that takes student major
    // and return all students under this major (return bad request the major)
    public List<Student> getStudentByMajor(String major){
        List<Student> students=studentRepository.findStudentByMajor(major);
        return students;
    }
    //Create endpoint that takes student age
    // and return all students who have this age or above
    public List<Student>getStudentByAge(Integer age){
        List<Student> students=studentRepository.findByAgeGreaterThanEqual(age);
        return students;
    }
}
