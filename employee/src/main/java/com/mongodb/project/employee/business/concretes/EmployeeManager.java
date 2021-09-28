package com.mongodb.project.employee.business.concretes;

import com.mongodb.project.common.entities.Employee;
import com.mongodb.project.employee.business.abstracts.EmployeeService;
import com.mongodb.project.employee.dataAccess.EmployeeDao;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private final EmployeeDao employeeDao;

    @ConstructorBinding
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
