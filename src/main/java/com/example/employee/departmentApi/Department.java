package com.example.employee.departmentApi;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Department {
    private String name;
    private LocalDate dateOfCreation;
    private String parentDepartment;
}
