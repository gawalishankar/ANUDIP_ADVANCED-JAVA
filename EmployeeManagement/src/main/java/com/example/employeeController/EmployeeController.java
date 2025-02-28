package com.example.employeeController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.example.EmployeeEntity.Employee;

@RestController
@RequestMapping("/empData")
@CrossOrigin("*")
public class EmployeeController {
	
	 private Map<Long, Employee> employeeEntry = new HashMap<>();
	 
	// Health check
    @GetMapping("/abc")
    public String healthCheck() {
        return "Employee Management API is running!";
    }
	 
	// Get all employees
    @GetMapping("/get")
    public List<Employee> getAll() {
        return new ArrayList<>(employeeEntry.values());
    }
	    
	// Add Employee
    @PostMapping("/add")
    public String createEntry(@RequestBody Employee myEntry) {
        if (myEntry.getId() == null) {
            return "Error: ID cannot be null!";
        }
        employeeEntry.put(myEntry.getId(), myEntry);
        return "Employee added successfully!";
    }
	    
	// Get Employee by ID
    @GetMapping("/id/{myId}")
    public Employee getEmployeeById(@PathVariable Long myId) {
        return employeeEntry.getOrDefault(myId, null);
    }

	// Delete Employee
    @DeleteMapping("/id/{myId}")
    public String deleteEmployeeById(@PathVariable Long myId) {
        if (employeeEntry.containsKey(myId)) {
            employeeEntry.remove(myId);
            return "Employee deleted successfully!";
        }
        return "Error: Employee not found!";
    }

	// Update Employee
    @PutMapping("/id/{id}")
    public String updateEmployeeById(@PathVariable Long id, @RequestBody Employee myEntry) {
        if (!employeeEntry.containsKey(id)) {
            return "Error: Employee not found!";
        }
        employeeEntry.put(id, myEntry);
        return "Employee updated successfully!";
    }
}
