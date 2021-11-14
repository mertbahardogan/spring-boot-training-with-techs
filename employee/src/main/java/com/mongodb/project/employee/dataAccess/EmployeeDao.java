package com.mongodb.project.employee.dataAccess;

import com.mongodb.project.common.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDao extends MongoRepository<Employee, String> {

    Optional<Employee> findById(String id);

    Optional<Employee> findByName(String name);

    @Query("{isManager:?true}")
    List<Employee> findAllByIsManager();
}
