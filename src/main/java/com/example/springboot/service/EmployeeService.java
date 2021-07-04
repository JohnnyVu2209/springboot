package com.example.springboot.service;


import java.util.List;
import java.util.Optional;

import com.example.springboot.entity.Employee;
public interface EmployeeService {
	public List<Employee> ListEmployee();
	
	public Employee getEmployee(int employeeId);
	
	public Employee saveEmployee(Employee employee);
	
	public void deleteEmployee(int employeeId);
	
	public Employee updateEmployee(int employeeId,Employee employee);
	
}
