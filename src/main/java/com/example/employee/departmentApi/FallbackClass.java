package com.example.employee.departmentApi;

import org.springframework.stereotype.Component;

@Component
public class FallbackClass implements ServiceFeignClient {
    @Override
    public Department getDepartment(String departmentName) {
        return null;
    }
}
