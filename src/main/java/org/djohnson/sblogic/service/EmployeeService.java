package org.djohnson.sblogic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.djohnson.sblogic.model.Employee;
import org.springframework.stereotype.Service;
 
import com.github.javafaker.Faker;

/**
 * EmployeeService is a service that provides a list of fake employees.
 * 
 * @author DJohnson
 * @since 1.0.0
 *
 */
@Service
public class EmployeeService  {
 
    final Faker faker = new Faker();
    final Random random = new Random();
 
    /**
     * Create a list of employees, either from the database or mocked out.
     * 
     * @return a list of {@link Employee}
     */
    public List<Employee> findAll() {
        final List<Employee> employees = new ArrayList<>();
        // Creating a list of employees using the "faker" object.
        for (int count = 0; count < 21; count++) {
            employees.add(new Employee(random.nextInt(30 + 1), faker.name().fullName(), faker.job().title(), faker.job().field()));
        }
        return employees;
    }
}