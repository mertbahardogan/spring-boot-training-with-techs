package com.mongodb.project.employee.business.concretes;

import com.mongodb.project.common.dtos.EmployeeDTO;
import com.mongodb.project.common.entities.Employee;
import com.mongodb.project.employee.business.abstracts.EmployeeService;
import com.mongodb.project.employee.dataAccess.EmployeeDao;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManager implements EmployeeService {

    private final EmployeeDao employeeDao;
    private final ModelMapper modelMapper;

    @ConstructorBinding
    public EmployeeManager(EmployeeDao employeeDao, ModelMapper modelMapper) {
        this.employeeDao = employeeDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> employees = this.employeeDao.findAll();
        Type listType = new TypeToken<List<EmployeeDTO>>() {
        }.getType();
        List<EmployeeDTO> employeeDTOList = modelMapper.map(employees, listType);
        return employeeDTOList;
    }

    @Override
    public Optional<EmployeeDTO> findById(String id) {
        Optional<Employee> employee = this.employeeDao.findById(id);
        Type listType = new TypeToken<Optional<EmployeeDTO>>() {
        }.getType();
        Optional<EmployeeDTO> employeeDTOList = modelMapper.map(employee, listType);
        return employeeDTOList;
    }

    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setCreated(LocalDate.now());
        return modelMapper.map(this.employeeDao.save(employee), EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO, String id) {
        Employee employeeValue = this.employeeDao.findById(id).get();
        employeeValue.setName(employeeDTO.getName());
        employeeValue.setLastName(employeeDTO.getLastName());
        employeeValue.setAge(employeeDTO.getAge());
        employeeValue.setSalary(employeeDTO.getSalary());
        employeeValue.setManager(employeeDTO.isManager());
        return modelMapper.map(this.employeeDao.save(employeeValue), EmployeeDTO.class);
    }

    @Override
    public boolean delete(String id) {
        try {
            this.employeeDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<EmployeeDTO> findAllByIsManager() {
        List<Employee> employees = this.employeeDao.findAllByIsManager();
        Type listType = new TypeToken<List<EmployeeDTO>>() {
        }.getType();
        List<EmployeeDTO> employeeDTOList = modelMapper.map(employees, listType);
        return employeeDTOList;
    }


}
