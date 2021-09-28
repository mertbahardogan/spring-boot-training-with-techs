package com.mongodb.project.employee.dataAccess;

import com.mongodb.project.common.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends MongoRepository<Employee,String> {

    List<Employee> findAll();
}
