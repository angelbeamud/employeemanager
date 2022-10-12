package com.angellopez.employeemanager.controller;

import com.angellopez.employeemanager.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeController {

    ResponseEntity<Employee> createEmployee(Employee employee);

    ResponseEntity<List<Employee>> getEmployees();

    ResponseEntity<Employee> getEmployeeById(Long id);

    ResponseEntity<Employee> updateEmployee(Employee employee);

    void deleteEmployee(Long id);


}
