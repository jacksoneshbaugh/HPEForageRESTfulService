package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(path = {"", "/"}, produces = "application/json")
    public String createEmployee(@RequestBody Employee employee) {

        if(employeeManager.getAllEmployees().getEmployees().contains(employee))
            return "{ \"response\": \"400\"," + "\"message\": \"Employee was not added successfully, because an employee with this ID already exists.\" }";

        employeeManager.addEmployee(employee);
        return "{ \"response\": \"201\"," + "\"message\": \"Employee was added successfully.\" }";
    }

}