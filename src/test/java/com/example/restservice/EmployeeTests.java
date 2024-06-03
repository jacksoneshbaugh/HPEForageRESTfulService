package com.example.restservice;

import org.junit.jupiter.api.Test;

public class EmployeeTests {

    @Test
    public void test_equals() {

        Employee employee = new Employee("0", "Jack", "Black", "CFO", "jack.black@enterprise.com");
        Employee employee2 = new Employee("0", "Jack", "Black", "CFO", "jack.black@enterprise.com");
        Employee employee3 = new Employee("0", "Jackd", "Blackf", "CFdsO", "jack.bdfslack@enterprise.com");
        Employee employee4 = new Employee("1", "Jack", "Black", "CFO", "jack.black@enterprise.com");
        Employee employee5 = new Employee("1", "Jackds", "Blacfk", "CFfsO", "jack.blacsdfk@enterprise.com");

        assert employee.equals(employee2);
        assert employee.equals(employee3);
        assert !employee.equals(employee4);
        assert !employee.equals(employee5);

    }

}
