package com.example.employee.mapping;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.model.Employee;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EmployeeMapStructMapper {
    EmployeeDto toEmployeeDto(Employee employee);
}
