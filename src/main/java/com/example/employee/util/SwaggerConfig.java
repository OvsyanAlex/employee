package com.example.employee.util;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Company Swagger Api")
                                .version("1.0.0")
                                .contact(new Contact()
                                        .email("aleksei_ovsiannikov1@epam.com")
                                        .name("Aleksei Ovsiannikov"))
                );
    }
}
