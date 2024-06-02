package com.example.restservice;

import org.springframework.stereotype.Repository;

/**
 * Manages the Employees. Responsible for initializing the {@link Employees} class.
 *
 * @author Jackson Eshbaugh
 * @version 06/02/2024
 */
@Repository
public class EmployeeManager {

    private static final Employees employees = new Employees();

    static {
        employees.getEmployees().add(new Employee(0, "Bob", "Smith", "CEO", "bob.smith@company.com"));
        employees.getEmployees().add(new Employee(1, "Alice", "Smith", "COO", "alice.smith@company.com"));
        employees.getEmployees().add(new Employee(2, "Tyler", "Paul", "Software Engineer", "tyler.paul@company.com"));
        employees.getEmployees().add(new Employee(3, "Martin", "Luther", "Reformist and Theologian", "martin.luther@company.com"));
    }

    public EmployeeManager() { }

    /**
     * Fetches all employees.
     * @return the {@link Employees} object containing all the employees.
     */
    public Employees getAllEmployees() {
        return employees;
    }

    /**
     * Adds an employee to the list of employees
     * @param employee the {@link Employee} to add to the list
     */
    public void addEmployee(Employee employee) {
        employees.getEmployees().add(employee);
    }
}
