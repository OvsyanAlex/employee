package com.example.employee.util;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EmployeeChanger {
//    @Autowired
//    DepartmentRepository departmentRepository;
//
//    public Employee changeEmployee(Employee oldEmployee, EmployeeDto newEmployeeDto) {
//        // определяем департамент который нужно засетить
//        List<Department> departments = departmentRepository.findAll();
//        Department result = null;
//        for (Department department : departments) {
//            if (department.getName().equals(newEmployeeDto.getDepartment())) {
//                result = department;
//                break;
//            }
//        }
//        return oldEmployee.
//                setSurname(newEmployeeDto.getSurname()).
//                setName(newEmployeeDto.getName()).
//                setMiddleName(newEmployeeDto.getMiddleName()).
//                setGender(newEmployeeDto.getGender()).
//                setBirthDay(newEmployeeDto.getBirthDay()).
//                setPhone(newEmployeeDto.getPhone()).
//                setEmail(newEmployeeDto.getEmail()).
//                setDateOfEmployment(newEmployeeDto.getDateOfEmployment()).
//                setDateOfDismissal(newEmployeeDto.getDateOfDismissal()).
//                setPost(newEmployeeDto.getPost()).
//                setSalary(newEmployeeDto.getSalary()).
//                setDirector(newEmployeeDto.isDirector()).
//                setDepartment(result);
//    }
}
