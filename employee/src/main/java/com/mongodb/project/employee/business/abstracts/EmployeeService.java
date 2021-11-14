package com.mongodb.project.employee.business.abstracts;

import com.mongodb.project.common.dtos.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//TODO: default metodu kullan. java8
@Service
public interface EmployeeService {

    List<EmployeeDTO> findAll();

    EmployeeDTO findById(String id);

    Optional<EmployeeDTO> findByName(String id);

    EmployeeDTO create(EmployeeDTO employeeDTO);

    EmployeeDTO update(EmployeeDTO employeeDTO,String id);

    boolean delete(String id);

    List<EmployeeDTO> findAllByIsManager();


    default void calculateSalary(){
        System.out.println("Calculate Salary default interface method.");
    }
}

