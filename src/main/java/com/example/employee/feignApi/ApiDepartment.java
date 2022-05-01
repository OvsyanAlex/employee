package com.example.employee.feignApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department", url = "http://localhost:8082")
public interface ApiDepartment {

    @GetMapping( "department/{departmentName}/search")
    Department getDepartment(@PathVariable String departmentName);


}
