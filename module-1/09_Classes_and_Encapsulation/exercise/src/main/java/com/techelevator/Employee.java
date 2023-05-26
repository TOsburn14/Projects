package com.techelevator;

public class Employee {

    //Variables
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double annualSalary;

    //Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    //Setters
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    //Constructor
    public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.annualSalary = annualSalary;
    }


    //Derived Variable
    public String getFullName(){
        return lastName + ", " + firstName;
    }


    //Method
    public void raiseSalary(double percent) {
        double raise = (this.annualSalary * percent) / 100.0;
        this.annualSalary += raise;
    }


}
