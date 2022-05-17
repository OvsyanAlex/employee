package com.example.employee.departmentApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "departments", url = "http://localhost:8082", fallback = FallbackClass.class)
public interface ServiceFeignClient {

    @GetMapping( "department/{departmentName}/search")
    Department getDepartment(@PathVariable String departmentName);
}
