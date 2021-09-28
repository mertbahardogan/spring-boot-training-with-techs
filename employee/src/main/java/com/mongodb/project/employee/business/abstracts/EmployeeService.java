package com.mongodb.project.employee.business.abstracts;

import com.mongodb.project.common.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> findAll();

    default void calculateSalary(){
        System.out.println("Calculate Salary default interface method.");
    }
}
