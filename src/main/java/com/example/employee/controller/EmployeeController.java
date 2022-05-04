package com.example.employee.controller;


import com.example.employee.dto.EmployeeDto;
import com.example.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
@Tag(name = "Employee controller", description = "Добавление, удаление, изменение сотрудников")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Operation(summary = "Поиск сотрудников по имени департамента")
    @GetMapping("/{departmentName}/searcher")
    public List<EmployeeDto> getEmployeesByDepartment(@PathVariable String departmentName) {
        return employeeService.getEmployeesByDepartment(departmentName);
    }

    @Operation(summary = "Создание сотрудника")
    @PostMapping("/create")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    @Operation(summary = "Поиск сотрудника по id")
    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @Operation(summary = "Информация о директоре сотрудника")
    @GetMapping("{id}/director")
    public EmployeeDto getEmployeeDirector(@PathVariable Long id) {
        return employeeService.getEmployeeDirector(id);
    }

    @Operation(summary = "Увольнение сотрудника")
    @PostMapping("/{id}/{date}/dismissal")
    public void dismissalEmployee(@PathVariable Long id, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")
            LocalDate date) {
        employeeService.dismissalEmployee(id, date);
    }

    @Operation(summary = "Поиск сотрудника по имени")
    @GetMapping("/{name}/search")
    public List<EmployeeDto> getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    @Operation(summary = "Изменение данных сотрудника")
    @PutMapping("/{id}/change")
    public void changeEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        employeeService.changeEmployee(id, employeeDto);
    }

    @Operation(summary = "Изменение департамента сотрудника")
    @PutMapping("/{id}/{departmentName}/change")
    public EmployeeDto changeDepartment(@PathVariable Long id, @PathVariable String departmentName) {
        return employeeService.changeDepartment(id, departmentName);
    }
}
