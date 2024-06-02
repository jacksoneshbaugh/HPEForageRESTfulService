package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides a list of all employees.
 *
 * @author Jackson Eshbaugh
 * @version 06/02/2024
 */
public class Employees {

    private List<Employee> employees;

    public Employees() { }

    /**
     * Fetch the list of employees.
     * @return the list of all employees.
     */
    public List<Employee> getEmployees() {
        if(employees == null) employees = new ArrayList<>();

        return employees;
    }

    /**
     * Set the list of employees to a given {@link List}.
     * @param employees the list to set the list of employees to.
     */
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
