package com.employeebookmap.controller;
import com.employeebookmap.Employee;
import com.employeebookmap.Service.EmployeeBookService;
import com.employeebookmap.Service.EmployeeBookServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeBookController {
    private final EmployeeBookServiceImpl employeeBookServiceImpl;


    public EmployeeBookController(EmployeeBookServiceImpl employeeBookServiceImpl) {
        this.employeeBookServiceImpl = employeeBookServiceImpl;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam(required = true) String firstName,
                              @RequestParam(required = true) String lastName) {
        employeeBookServiceImpl.addNewEmployee(firstName, lastName);
        return "All good";

    }
    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam(required = true) String firstName,
                                 @RequestParam(required = true) String lastName) {

        employeeBookServiceImpl.removeEmployee(firstName, lastName);
        return "All good";
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam(required = true) String firstName,
                               @RequestParam(required = true) String lastName) {

        return firstName+ ' ' + lastName+", id " +employeeBookServiceImpl.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/printAll")
    public Collection<Employee> printEmployees() {
        return this.employeeBookServiceImpl.printAll();
    }
}
