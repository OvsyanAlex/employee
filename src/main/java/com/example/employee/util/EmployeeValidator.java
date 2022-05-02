package com.example.employee.util;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.feignApi.Department;
import com.example.employee.feignApi.DepartmentController;
import com.example.employee.mapping.EmployeeMapping;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeValidator {
    @Autowired
    DepartmentController departmentController;
    @Autowired
    EmployeeMapping employeeMapping;
    @Autowired
    EmployeeRepository employeeRepository;


    public Boolean validateEmployee(EmployeeDto employeeDto) {
        //Получаем департамент
        Department department = departmentController.getDepartment(employeeDto.getDepartment());
        return department != null;
//        List<Department> departments = departmentRepository.findAll();
//        Department result = null;
//        Employee director = null;
//        // проверяем есть ли указанный в запросе департамент
//        for (Department department : departments) {
//            if (department.getName().equals(employeeDto.getDepartment())) {
//                result = department;
//                break;
//            }
//        }
//        if (result == null) return null;
//
//        // проверяем есть ли в департаменте директор
//        for (
//                Employee employee : result.getEmployeeList()) {
//            if (employee.isDirector()) {
//                director = employee;
//                break;
//            }
//        }
//
//        // если директор есть и новый сотрудник тоже директор - возвращаем null
//        if (director != null && employeeDto.isDirector()) {
//            return null;
//        }
//
//        // сравниваем зарплаты директора и нового сотрудника
//        if (director != null) {
//            if (director.getSalary() < employeeDto.getSalary()) {
//                return null;
//            }
//        }
//
//        // проверяем, что "Дата приема на работу" больше “Даты рождения” и “Дата увольнения” больше “Даты приема на работу”
//        if (employeeDto.getDateOfEmployment().
//
//                isBefore(employeeDto.getBirthDay()) ||
//                employeeDto.getDateOfEmployment().
//
//                        isAfter(employeeDto.getDateOfDismissal())) {
//            return null;
//        }
//        return employeeDto;
    }
}
