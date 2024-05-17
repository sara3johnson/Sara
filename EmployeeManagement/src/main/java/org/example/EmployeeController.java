package org.example;
// Import the above-defined classes
// to use the properties of those
// classes
import org.example.Employee;
import org.example.Employees;
import org.example.EmployeeDAO;

// Create the REST controller
@RestController
@RequestMapping(path = "/employees")

public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    // Implementing a GET method
    // to get the list of all
    // the employees
    @GetMapping(
            path = "/",
            produces = "application/json")

    public Employees getEmployees()
    {

        return employeeDao
                .getAllEmployees();
    }
















    }













