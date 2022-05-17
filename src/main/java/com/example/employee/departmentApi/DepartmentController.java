package com.example.employee.departmentApi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final ServiceFeignClient serviceFeignClient;

    @GetMapping("/department/{departmentName}/search")
    public Department getDepartment(@PathVariable String departmentName) {
        return serviceFeignClient.getDepartment(departmentName);
    }
}
