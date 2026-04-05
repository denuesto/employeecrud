package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findById(Long employeeId);
	
	Employee save(Employee employee);
	Employee update(Long employeeId,Employee employee);
	boolean deleteById(Long employeeId);
	
	List<Employee> findByName(String name);

}
