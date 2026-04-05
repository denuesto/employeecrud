package com.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAll(){
		return ResponseEntity.ok(employeeService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable("id") Long employeeId) {
		return ResponseEntity.ok(employeeService.findById(employeeId));
	}
	
	@PostMapping
	public ResponseEntity<Employee> save(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.save(employee));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> update(@PathVariable("id") Long employeeId, @RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.update(employeeId, employee));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long employeeId){
		return ResponseEntity.ok(employeeService.deleteById(employeeId));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Employee>> findByName(@RequestParam("name") String name) {
		return ResponseEntity.ok(employeeService.findByName(name));
	}

}
