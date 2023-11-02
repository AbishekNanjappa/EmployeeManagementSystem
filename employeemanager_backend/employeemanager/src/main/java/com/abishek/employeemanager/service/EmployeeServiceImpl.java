package com.abishek.employeemanager.service;

import com.abishek.employeemanager.dao.EmployeeRepository;
import com.abishek.employeemanager.exception.UserNotFoundException;
import com.abishek.employeemanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee findById(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee employee = null;
        if(employeeOptional.isPresent() == true) {
            employee = employeeOptional.get();
        }
        else {
            throw new UserNotFoundException("User with id = " + id + ", not found!!!");
        }
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
