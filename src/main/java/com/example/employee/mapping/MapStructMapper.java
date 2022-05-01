package com.example.employee.mapping;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.model.Employee;
import org.mapstruct.Mapping;

public class MapStructMapper {
    @Mapping(target = "department", expression  = "java(employee.getDepartment().getName())")
    EmployeeDto toEmployeeDto(Employee employee);
}