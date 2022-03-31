package com.mongodb.project.employee.api;

import com.mongodb.project.common.aspects.Log;
import com.mongodb.project.common.aspects.Restrict;
import com.mongodb.project.common.dtos.EmployeeDTO;
import com.mongodb.project.common.exceptions.EmployeeNotCreatedException;
import com.mongodb.project.common.exceptions.EmployeeNotFoundException;
import com.mongodb.project.common.exceptions.MethodRequestNotValidException;
import com.mongodb.project.employee.business.abstracts.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/employees")
@Api(value = "Employees API Documentation")
public class EmployeesController {

    private final EmployeeService employeeService;

    @PostConstruct
    public void init() {
        employeeService.create(new EmployeeDTO( "name", "surname",1,1,true));
    }

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Log
    @Restrict
    @GetMapping()
    @ApiOperation(value="All employees return.")
    public ResponseEntity findAll() {
        return new ResponseEntity<>(this.employeeService.findAll(), HttpStatus.OK);
    }

    @Log
    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable(value = "id") String id) throws EmployeeNotFoundException {
        EmployeeDTO employee = this.employeeService.findById(id);
        if (employee == null) {
            throw EmployeeNotFoundException.createWith(id);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Log
    @PostMapping()
    public ResponseEntity create(@Valid @RequestBody @ApiParam("Create employeeDTO parameters needs.") EmployeeDTO employeeDTO, BindingResult bindingResult) throws Exception {
        Optional<EmployeeDTO> employee = this.employeeService.findByName(employeeDTO.getName());
        if (bindingResult.hasErrors()) {
            throw MethodRequestNotValidException.createWith(bindingResult.getFieldErrors());
        }
        if (!employee.isEmpty()) {
            throw EmployeeNotCreatedException.createWith(employeeDTO.getName());
        }
        return new ResponseEntity<>(this.employeeService.create(employeeDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable(value = "id") String id, BindingResult bindingResult) throws Exception {
        Optional<EmployeeDTO> employee = this.employeeService.findByName(employeeDTO.getName());
        if (employee.isEmpty()) {
            throw EmployeeNotFoundException.createWith(employeeDTO.getName());
        }
        if (bindingResult.hasErrors()) {
            throw MethodRequestNotValidException.createWith(bindingResult.getFieldErrors());
        }
        return new ResponseEntity<>(this.employeeService.update(employeeDTO, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(this.employeeService.delete(id), HttpStatus.OK);
    }

    @GetMapping("managers")
    public ResponseEntity findAllByIsManager() {
        return new ResponseEntity<>(this.employeeService.findAllByIsManager(), HttpStatus.OK);
    }
}
