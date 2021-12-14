package com.mongodb.project.employee.dataAccess;

import com.mongodb.project.common.aspects.Timed;
import com.mongodb.project.common.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDao extends MongoRepository<Employee, String> {

    @Timed
    Optional<Employee> findById(String id);

    @Timed
    Optional<Employee> findByName(String name);

    @Timed
    @Query("{isManager:?true}")
    List<Employee> findAllByIsManager();
}
