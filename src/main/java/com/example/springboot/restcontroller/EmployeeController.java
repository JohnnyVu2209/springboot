package com.example.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Employee;
import com.example.springboot.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> ListAllEmployee() {
		return new ResponseEntity<List<Employee>>(employeeService.ListEmployee(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> GetEmployee(@PathVariable int id) {
		return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> SaveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public void DeleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}

}
