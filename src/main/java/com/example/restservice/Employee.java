package com.example.restservice;

/**
 * An entity representing an employee's record in the GreenLake database.
 *
 * @author Jackson Eshbaugh
 * @version 06/02/2024
 */
public class Employee {

    private String employee_id, first_name, last_name, title, email;

    /**
     * Initialize a new Employee entity.
     *
     * @param employee_id the employee's id (`employee_id`)
     * @param first_name the employee's first name (`first_name`)
     * @param last_name the employee's last name (`last_name`)
     * @param title the employee's title (`title`)
     * @param email the employee's email (`email`)
     */
    public Employee(String employee_id, String first_name, String last_name, String title, String email) {
        super();

        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.title = title;
        this.email = email;
    }

    /**
     * Gets the employee's ID.
     * @return the employee's ID
     */
    public String getId() {
        return employee_id;
    }

    /**
     * Gets the employee's first name.
     * @return the employee's first name
     */
    public String getFirstName() {
        return first_name;
    }

    /**
     * Gets the employee's last name.
     * @return the employee's last name
     */
    public String getLastName() {
        return last_name;
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

    /**
     * Sets the employee's email.
     * @param email the employee's new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the employee's title.
     * @param title the employee's new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the employee's last name.
     * @param last_name the employee's new last name
     */
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Sets the employee's first name.
     * @param first_name the employee's new first name
     */
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Sets the employee's ID.
     * @param employee_id the employee's new ID
     */
    public void setId(String employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public boolean equals(Object that) {

        if(that instanceof Employee thatEmployee) {
            return thatEmployee.getId().equals(this.getId());
        }

        return false;
    }
}