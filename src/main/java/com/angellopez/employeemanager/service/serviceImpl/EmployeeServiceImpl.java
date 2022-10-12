package com.angellopez.employeemanager.service.serviceImpl;

import com.angellopez.employeemanager.exception.EmployeeException;
import com.angellopez.employeemanager.model.Employee;
import com.angellopez.employeemanager.repository.EmployeeRepository;
import com.angellopez.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Constructor by default
     */
    public EmployeeServiceImpl() {
        super();
    }

    /**
     * @param id Id
     * @return Employee found by id
     */
    @Override
    public Employee findEmployeeById(Long id) {
        return this.employeeRepository.findEmployeeById(id).orElseThrow(() -> new EmployeeException("User by id" + id + "was not found"));
    }

    /**
     * @param employee Employee
     * @return The new employee
     */
    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepository.save(employee);
    }

    /**
     * @return All employees
     */
    @Override
    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }

    /**
     * @param employee Employee
     * @return The employee updated
     */
    @Override
    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    /**
     * @param id Id
     */
    @Override
    public void deleteEmployee(Long id) {
        this.employeeRepository.deleteById(id);
    }
}
