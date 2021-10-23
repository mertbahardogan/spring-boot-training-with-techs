package com.mongodb.project;

import com.mongodb.project.employee.dataAccess.EmployeeDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = EmployeeDao.class)
@Configuration
public class EmployeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis( RequestHandlerSelectors.basePackage( "com.mongodb.project"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring Boot Simple REST API",
                "Spring Boot Simple REST API Swagger Documentation",
                "Version 1",
                "urn:tos",
                new Contact("Admin", "www.mertbahardogan.com", "info@mertbahardogan.com"),
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }
}
