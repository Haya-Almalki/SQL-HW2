package com.example.schoolmanagementsoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @Data @NoArgsConstructor
@Entity
public class Teacher {
    // ID , name , salary ( all should not be empty)
    @NotNull(message = "id must not be empty")
    @Id
    private Integer id;
    @NotEmpty(message = "name must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotNull(message = "salary must not be empty")
    private Integer salary;
}
