package org.example;
import java.util.ArrayList;
import java.util.List;

// Class to store the list of
// all the employees in an
// Array List
public class Employees {
    private List<Employee> employeeList;

    //constructor
    public Employees(){
        this.employeeList = new ArrayList<>();
    }

    // Method to get employee list
    public List<Employee> getEmployeeList()
    {
        if (employeeList == null) {

            employeeList = new ArrayList<>();
        }
        return employeeList;
    }

    //method to set employee list
    public void setEmployeeList(List<Employee> employeeList){
        this.employeeList = employeeList;
    }




















}


