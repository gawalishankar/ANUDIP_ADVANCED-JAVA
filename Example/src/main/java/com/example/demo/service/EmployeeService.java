package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service  //serve as a service class
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//getting data 
	public List<Employee>  getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	//saving data
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//updating data
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//Get Employee Id
	public Employee getEmployeebyId(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	//Deleting Employee by Id
	public boolean deleteEmployeeById(Long id) {
		if(employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
}
