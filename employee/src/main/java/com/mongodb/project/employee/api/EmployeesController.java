package com.mongodb.project.employee.api;

import com.mongodb.project.common.dtos.EmployeeDTO;
import com.mongodb.project.common.results.SuccessDataResponse;
import com.mongodb.project.common.results.SuccessResponse;
import com.mongodb.project.employee.business.abstracts.EmployeeService;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1")
public class EmployeesController {

    private final EmployeeService employeeService;

    @ConstructorBinding
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity findAll() {
        SuccessDataResponse sr = new SuccessDataResponse();
        sr.setList(this.employeeService.findAll());
        return new ResponseEntity<>(sr, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable(value = "id") String id) {
        SuccessDataResponse sr = new SuccessDataResponse();
        sr.setOptional(this.employeeService.findById(id));
        return new ResponseEntity<>(sr, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody EmployeeDTO employeeDTO) {
        SuccessResponse sr = new SuccessResponse();
        sr.setData(this.employeeService.create(employeeDTO));
        return new ResponseEntity<>(sr, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@RequestBody EmployeeDTO employeeDTO,@PathVariable(value = "id") String id) {
        SuccessResponse sr = new SuccessResponse();
        sr.setData(this.employeeService.update(employeeDTO,id));
        return new ResponseEntity<>(sr, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id) {
        SuccessResponse sr = new SuccessResponse();
        sr.setData(this.employeeService.delete(id));
        return new ResponseEntity<>(sr, HttpStatus.OK);
    }

    @GetMapping("managers")
    public ResponseEntity findAllByIsManager() {
        SuccessDataResponse sr = new SuccessDataResponse();
        sr.setList(this.employeeService.findAllByIsManager());
        return new ResponseEntity<>(sr, HttpStatus.OK);
    }
}
