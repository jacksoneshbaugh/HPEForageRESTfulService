package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * A controller with domain over all things related to employees.
 *
 * @author Jackson Eshbaugh
 * @version 06/02/2024
 */
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    /**
     * Fetches a list of all employees present in the {@link Employees} list.
     * @return a list of all employees, in JSON form.
     */
    @GetMapping(path = {"", "/"}, produces = "application/json")
    public Employees getEmployees() {
        return employeeManager.getAllEmployees();
    }

    /**
     * Takes JSON data for a new employee, then adds the employee to the list.
     * @param employee the employee to be added to the list
     * @return a response indicating success or failure.
     */
    @PostMapping(path = {"", "/"}, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {

        if(employeeManager.getAllEmployees().getEmployees().contains(employee))
            return ResponseEntity.badRequest().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();

        employeeManager.addEmployee(employee);
        return ResponseEntity.created(location).build();
    }

}