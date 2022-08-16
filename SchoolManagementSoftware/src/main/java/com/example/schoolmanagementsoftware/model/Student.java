package com.example.schoolmanagementsoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @Data @NoArgsConstructor
@Entity
public class Student {
    // ID , name , age , major ( all should not be empty ) ( major enum { CS , MATH , Engineer )
    @NotNull(message = "id must be not empty")
    @Id
    private Integer id;
    @NotEmpty(message = "name must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotNull(message = "age must be not empty")
    private Integer age;
    @NotEmpty(message = "major must be not empty")
    @Column(columnDefinition = "varchar(10) check (major='CS' or major='MATH' or major='Engineer')")
    private String major;
}
