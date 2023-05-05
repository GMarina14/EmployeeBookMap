package com.employeebookmap.Service;


import com.employeebookmap.Employee;

import java.util.HashMap;
import java.util.Map;

public interface EmployeeBookService {
    Map<Integer, Employee> employees = new HashMap<>(Map.of());

    public void addNewEmployee(String firstName, String lastName);

    public void removeEmployee(String firstName, String lastName);

    public int findEmployee(String firstName, String lastName);
}
