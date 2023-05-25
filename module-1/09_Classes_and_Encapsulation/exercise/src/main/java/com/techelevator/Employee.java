package com.techelevator;

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double annualSalary;


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


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    String fullName = this.lastName + ", " + this.firstName;


    public Employee (int employeeId, String firstName, String lastName, double annualSalary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.annualSalary = annualSalary;
        getFullName =
    }

    public void raiseSalary(double percent){

    }


}
