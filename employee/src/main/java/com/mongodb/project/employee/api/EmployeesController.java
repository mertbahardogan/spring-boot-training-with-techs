package com.mongodb.project.employee.api;

import com.mongodb.project.common.results.SuccessListResponse;
import com.mongodb.project.employee.business.abstracts.EmployeeService;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class EmployeesController {

    private final EmployeeService employeeService;

    @ConstructorBinding
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity findAll() {
        SuccessListResponse sr = new SuccessListResponse();
        sr.setList(employeeService.findAll());
        return new ResponseEntity<>(sr, HttpStatus.OK);
    }

}
