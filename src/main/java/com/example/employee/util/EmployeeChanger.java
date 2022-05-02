package com.example.employee.util;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EmployeeChanger {

    public Employee changeEmployee(Employee oldEmployee, EmployeeDto newEmployeeDto) {

        return oldEmployee.
                setSurname(newEmployeeDto.getSurname()).
                setName(newEmployeeDto.getName()).
                setMiddleName(newEmployeeDto.getMiddleName()).
                setGender(newEmployeeDto.getGender()).
                setBirthDay(newEmployeeDto.getBirthDay()).
                setPhone(newEmployeeDto.getPhone()).
                setEmail(newEmployeeDto.getEmail()).
                setDateOfEmployment(newEmployeeDto.getDateOfEmployment()).
                setDateOfDismissal(newEmployeeDto.getDateOfDismissal()).
                setPost(newEmployeeDto.getPost()).
                setSalary(newEmployeeDto.getSalary()).
                setDirector(newEmployeeDto.isDirector()).
                setDepartment(newEmployeeDto.getDepartment());
    }
}
