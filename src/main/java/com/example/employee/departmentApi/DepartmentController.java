package com.example.employee.departmentApi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value = "/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentApi departmentApi;

    @GetMapping(
            "/department/{departmentName}/search")
    public Department getDepartment(@PathVariable String departmentName) {
        return departmentApi.getDepartment(departmentName);
    }
}
