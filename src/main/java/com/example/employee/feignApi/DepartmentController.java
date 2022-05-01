package com.example.employee.feignApi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value = "/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final ApiDepartment apiDepartment;

    @GetMapping(
            "/department/{departmentName}/search")
    public Department getDepartment(@PathVariable String departmentName) {
        return apiDepartment.getDepartment(departmentName);
    }
}
