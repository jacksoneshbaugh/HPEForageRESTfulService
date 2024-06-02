package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}