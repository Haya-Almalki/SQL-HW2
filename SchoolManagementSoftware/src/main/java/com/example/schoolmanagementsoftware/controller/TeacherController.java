package com.example.schoolmanagementsoftware.controller;

import com.example.schoolmanagementsoftware.dto.ApiResponse;
import com.example.schoolmanagementsoftware.model.Teacher;
import com.example.schoolmanagementsoftware.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping
    public ResponseEntity<List>getTeachers(){
        List<Teacher> teacher=teacherService.getTeachers();
        return ResponseEntity.status(200).body(teacher);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body(new ApiResponse("new teacher added",201));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse>updateTeacher(@RequestBody Teacher teacher,@PathVariable Integer id){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(201).body(new ApiResponse("teacher updated",201));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(201).body(new ApiResponse("teacher deleted",201));
    }
    @GetMapping("getById/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer id){
        Teacher teacher=teacherService.getTeacherById(id);
        return ResponseEntity.status(200).body(teacher);
    }
    @GetMapping("getBySalary/{salary}")
    public ResponseEntity<List> getTeachersBySalary(@PathVariable Integer salary){
        List<Teacher> teachers=teacherService.getTeacherBySalary(salary);
        return ResponseEntity.status(200).body(teachers);
    }
}
