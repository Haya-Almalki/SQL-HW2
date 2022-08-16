package com.example.schoolmanagementsoftware.controller;

import com.example.schoolmanagementsoftware.dto.ApiResponse;
import com.example.schoolmanagementsoftware.model.Student;
import com.example.schoolmanagementsoftware.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public ResponseEntity<List> getStudents(){
        List<Student> students=studentService.getStudent();
        return ResponseEntity.status(200).body(students);
    }
    @PostMapping
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(201).body(new ApiResponse("new student added",201));
    }
    @PutMapping("/{id}")
    public ResponseEntity updateStudent(@RequestBody Student student,@PathVariable Integer id){
        studentService.updateStudent(student,id);
        return ResponseEntity.status(201).body(new ApiResponse("student updated",201));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(201).body(new ApiResponse("student deleted",201));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        Student student=studentService.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }

    @GetMapping("/name")
    public ResponseEntity<Student> getStudentByName(@RequestParam String name){
        Student student=studentService.getStudentByName(name);
        return ResponseEntity.status(200).body(student);
    }

    @GetMapping("/major")
    public ResponseEntity getStudentMajor(@RequestParam String major){
        List<Student> students=studentService.getStudentByMajor(major);
        return ResponseEntity.status(200).body(students);
    }
    @GetMapping("/age")
    public ResponseEntity getStudentByAge(@RequestParam Integer age){
        List<Student> students=studentService.getStudentByAge(age);
        return ResponseEntity.status(200).body(students);
    }
}