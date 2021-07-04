package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Employee;
import com.example.springboot.exception.EmployeeException;
import com.example.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private String Employee_Not_Found = "Employee not found";

	@Autowired
	private EmployeeRepository employeeRepository;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> ListEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		return employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeException(Employee_Not_Found));
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		if (employeeRepository.findById(employeeId) == null) {
			throw new EmployeeException(Employee_Not_Found);
		}
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public Employee updateEmployee(int employeeId, Employee employee) {
		return employeeRepository.findById(employeeId).map(emp ->{
			emp.setFirst_name(employee.getFirst_name());
			emp.setSur_name(employee.getSur_name());
			emp.setLast_name(employee.getLast_name());
			emp.setAddress(employee.getAddress());
			emp.setBirthday(employee.getBirthday());
			return employeeRepository.save(emp);
		}).orElseGet(() -> {
			employee.setId(employeeId);
			return employeeRepository.save(employee);
			});
	}

	
}
