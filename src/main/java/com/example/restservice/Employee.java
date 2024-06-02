package com.example.restservice;

/**
 * An entity representing an employee's record in the GreenLake database.
 *
 * @author Jackson Eshbaugh
 * @version 06/02/2024
 */
public class Employee {

    private Integer id;
    private String firstName, lastName, title, email;

    public Employee() {}

    /**
     * Initialize a new Employee entity.
     *
     * @param id the employee's id (`employee_id`)
     * @param firstName the employee's first name (`first_name`)
     * @param lastName the employee's last name (`last_name`)
     * @param title the employee's title (`title`)
     * @param email the employee's email (`email`)
     */
    public Employee(Integer id, String firstName, String lastName, String title, String email) {
        super();

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
    }

    /**
     * Gets the employee's ID.
     * @return the employee's ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets the employee's first name.
     * @return the employee's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the employee's last name.
     * @return the employee's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the employee's title.
     * @return the employee's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the employee's email.
     * @return the employee's email
     */
    public String getEmail() {
        return email;
    }
}