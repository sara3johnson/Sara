package org.example;


public class EmployeeDAO {
private static Employees list = new Employees();
    // Creating a few employees
    // and adding them to the list
 static {
     list.getEmployeeList().add(
             new Employee(1,"Sara","Johnson","sarajohnson.m@gmail.com","Manager")
             );

     list.getEmployeeList().add(
             new Employee(2,"Brooke","Wilson", "brooke.wilson@gmail.com","Manager" )

     );

     list.getEmployeeList().add(
             new Employee(3,"Aaron", "Chancellor","a.chancellor@gmail.com", "Stock Associate")
     );

}
    // Method to return the list

    public Employees getAllEmployees()
    {
        return list;
    }
    // Method to add an employee
    // to the employees list
    public void addEmployee(Employee employee){
     list.getEmployeeList().add(employee);
    }






















}
