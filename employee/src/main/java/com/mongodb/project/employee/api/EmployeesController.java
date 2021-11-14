package com.mongodb.project.employee.api;

import com.mongodb.project.common.dtos.EmployeeDTO;
import com.mongodb.project.common.exceptions.EmployeeNotCreatedException;
import com.mongodb.project.common.exceptions.EmployeeNotFoundException;
import com.mongodb.project.employee.business.abstracts.EmployeeService;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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
        return new ResponseEntity<>(this.employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable(value = "id") String id) throws EmployeeNotFoundException {
        EmployeeDTO employee = this.employeeService.findById(id);
        if(employee==null){
            throw EmployeeNotFoundException.createWith(id);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody EmployeeDTO employeeDTO) throws EmployeeNotCreatedException {
        Optional<EmployeeDTO> employee = this.employeeService.findByName(employeeDTO.getName());
        if(!employee.isEmpty()){
            throw EmployeeNotCreatedException.createWith(employeeDTO.getName());
        }
        return new ResponseEntity<>(this.employeeService.create(employeeDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@RequestBody EmployeeDTO employeeDTO, @PathVariable(value = "id") String id) {
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
