package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//Getting data by get mapping
	@GetMapping("getallemployees")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	//create Employee for adding new employee by post mapping
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	//updating employee data using put mapping
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updateEmployee){
		
		Employee existingEmployee =employeeService.getEmployeebyId(id);
		
		if(existingEmployee!=null) {
			existingEmployee.setName(updateEmployee.getName());
			existingEmployee.setEmail(updateEmployee.getEmail());
			
			Employee savedEmployee = employeeService.updateEmployee(existingEmployee);
			
			return ResponseEntity.ok(savedEmployee);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){
		
		
		boolean isDeleted =employeeService.deleteEmployeeById(id);
		
		if(isDeleted) {
			return ResponseEntity.noContent().build();
			
		}else {
			return ResponseEntity.notFound().build();		}
	}
	
}
