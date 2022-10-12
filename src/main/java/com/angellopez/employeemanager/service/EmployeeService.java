package com.angellopez.employeemanager.service;

import com.angellopez.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findEmployeeById(Long id);

    Employee addEmployee(Employee employee);

    List<Employee> findAllEmployee();

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);
}
