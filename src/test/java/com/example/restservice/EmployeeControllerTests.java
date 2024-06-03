package com.example.restservice;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private EmployeeManager employeeManager;

    private Employees employees;

    @BeforeEach
    public void setUp() {
        employees = new Employees();
        Employee martin = new Employee("0", "Martin", "Luther", "Reformist and Theologian", "martin.luther@company.com");
        Employee bob = new Employee("1", "Bob", "Smith", "CEO", "bob.smith@company.com");
        employees.setEmployees(Arrays.asList(martin, bob));
    }

    @Test
    public void test_getEmployees() throws Exception {
        when(employeeManager.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employees")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"employees\": [" +
                        "  {" +
                        "    \"id\": \"0\"," +
                        "    \"firstName\": \"Martin\"," +
                        "    \"lastName\": \"Luther\"," +
                        "    \"title\": \"Reformist and Theologian\"," +
                        "    \"email\": \"martin.luther@company.com\"" +
                        "  }," +
                        "  {" +
                        "    \"id\": \"1\"," +
                        "    \"firstName\": \"Bob\"," +
                        "    \"lastName\": \"Smith\"," +
                        "    \"title\": \"CEO\"," +
                        "    \"email\": \"bob.smith@company.com\"" +
                        "  }" +
                        "]}"));

        verify(employeeManager, times(1)).getAllEmployees();
    }

    @Test
    public void test_createEmployee() throws Exception {
        Employee newEmployee = new Employee("3", "Alice", "Johnson", "HR Director", "alice.johnson@company.com");

        when(employeeManager.getAllEmployees()).thenReturn(employees);
        doNothing().when(employeeManager).addEmployee(any(Employee.class));

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{"
                                + "\"id\": \"3\","
                                + "\"firstName\": \"Alice\","
                                + "\"lastName\": \"Johnson\","
                                + "\"title\": \"HR Director\","
                                + "\"email\": \"alice.johnson@company.com\""
                                + "}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "http://localhost/employees/3"));

        verify(employeeManager, times(1)).addEmployee(any(Employee.class));
    }

    @Test
    public void testCreateEmployeeDuplicate() throws Exception {
        Employee duplicateEmployee = new Employee("1", "Alice", "Johnson", "HR Director", "alice.johnson@company.com");


        when(employeeManager.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{"
                                + "\"id\": \"1\","
                                + "\"firstName\": \"Alice\","
                                + "\"lastName\": \"Johnson\","
                                + "\"title\": \"HR Director\","
                                + "\"email\": \"alice.johnson@company.com\""
                                + "}"))
                .andExpect(status().isBadRequest());

        verify(employeeManager, never()).addEmployee(any(Employee.class));
    }

}
