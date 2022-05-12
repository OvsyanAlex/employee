package com.example.employee.departmentApi;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department", url = "http://localhost:8082", fallback = StatisticFallbackFactory.class)

public interface ServiceFeignClient {

    @GetMapping( "department/{departmentName}/search")
    Department getDepartment(@PathVariable String departmentName);
}
