package com.example.employee.util;

import com.example.employee.model.Employee;

public interface CustomRepositoryCriteriaApi {
    Employee getById(Long employeeId);
}
