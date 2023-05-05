package com.employeebookmap.Service;

import com.employeebookmap.*;
import com.employeebookmap.EmployeeExceptions.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {

    //Map<Integer, Employee> employeeBook = new HashMap<>();
    // Set<Map.Entry<Integer, Employee>> entrySet = employeeBook.entrySet();
    Map<String, Employee> employeeBookTwo = new HashMap<>();


    @Override
    public void addNewEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException {
        String str = firstName + ' ' + lastName;
        if (employeeBookTwo.containsKey(str)) {
            throw new EmployeeAlreadyAddedException("An employee with the same full name already was added");
        } else {
            Employee employee = new Employee(firstName, lastName);
            employeeBookTwo.put(str, employee);
            System.out.println(employee.getFullName());
        }
    }

    @Override
    public void removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        String str = firstName + ' ' + lastName;
        if (!employeeBookTwo.containsKey(str)) {
            throw new EmployeeNotFoundException("Employee not found");

        } else {
            employeeBookTwo.remove(str);
            System.out.println(str + " is fired");
        }
    }

    @Override
    public int findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        String str = firstName + ' ' + lastName;
        if (employeeBookTwo.containsKey(str)) {
            System.out.println("Employee is found");
            return employeeBookTwo.get(str).getIdOfEmployee();
        } else {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }

    public Collection<Employee> printAll() {
        return Collections.unmodifiableMap(employeeBookTwo).values();
    }
}
