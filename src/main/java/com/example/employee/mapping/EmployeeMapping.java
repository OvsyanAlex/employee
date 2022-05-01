package com.example.employee.mapping;


import com.example.employee.dto.EmployeeDto;
import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapping {
//    @Autowired
//    DepartmentRepository departmentRepository;
//    @Autowired
//    DepartmentSearcher departmentSearcher;
//
//    public Employee employeeMapping(EmployeeDto employeeDto) {
//        Department department = departmentSearcher.searchDepartment(employeeDto);
//
//        return new Employee().
//                setSurname(employeeDto.getSurname()).
//                setName(employeeDto.getName()).
//                setMiddleName(employeeDto.getMiddleName()).
//                setGender(employeeDto.getGender()).
//                setBirthDay(employeeDto.getBirthDay()).
//                setPhone(employeeDto.getPhone()).
//                setEmail(employeeDto.getEmail()).
//                setDateOfEmployment(employeeDto.getDateOfEmployment()).
//                setDateOfDismissal(employeeDto.getDateOfDismissal()).
//                setPost(employeeDto.getPost()).
//                setSalary(employeeDto.getSalary()).
//                setDirector(employeeDto.isDirector()).
//                setDepartment(department);
//    }
}
