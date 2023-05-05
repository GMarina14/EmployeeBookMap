package com.employeebookmap;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private final int idOfEmployee;
    private static int ID;
    private int department;
    private int salary;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //String temp =firstName+' '+lastName;
        ID++;
        idOfEmployee=ID;
       // EmployeesByFullName.add(temp);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFullName(){
        return firstName + ' '+ lastName;
    }

    public int getIdOfEmployee() {
        return idOfEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "{" +
                "First Name: '" + firstName + '\'' +
                " Last Name:'" + lastName + '\'' +
                '}';
    }
}
