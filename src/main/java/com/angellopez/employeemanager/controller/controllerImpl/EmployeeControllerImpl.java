package com.angellopez.employeemanager.controller.controllerImpl;

import com.angellopez.employeemanager.controller.EmployeeController;
import com.angellopez.employeemanager.model.Employee;
import com.angellopez.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeControllerImpl() {
        super();
    }

    /**
     * @param employee Employee
     * @return Employee created
     */
    @PostMapping(path = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(this.employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    /**
     * @return A list with all employees
     */
    @GetMapping(path = "/employees")
    @Override
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(this.employeeService.findAllEmployee(), HttpStatus.OK);
    }

    /**
     * @param id Id
     * @return Employee with the same id
     */
    @GetMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.employeeService.findEmployeeById(id), HttpStatus.OK);
    }

    /**
     * @param employee Employee
     * @return Employee updated
     */
    @PutMapping(path = "/employees")
    @Override
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(this.employeeService.updateEmployee(employee), HttpStatus.CREATED);
    }

    /**
     * @param id Id
     */
    @DeleteMapping(path = "/employees/{id}")
    @Override
    public void deleteEmployee(@PathVariable("id") Long id) {
        this.employeeService.deleteEmployee(id);
    }
}
