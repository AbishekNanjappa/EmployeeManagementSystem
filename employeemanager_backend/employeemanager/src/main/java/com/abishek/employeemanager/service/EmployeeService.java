package com.abishek.employeemanager.service;

import com.abishek.employeemanager.model.Employee;
import java.util.*;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> findAll();
    Employee findById(long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(long id);
}
