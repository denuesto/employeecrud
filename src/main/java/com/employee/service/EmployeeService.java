package com.employee.service;

import java.util.List;

import com.employee.dto.request.EmployeeRequest;
import com.employee.dto.response.EmployeeResponse;

public interface EmployeeService {
	
	List<EmployeeResponse> findAll();
	EmployeeResponse findById(Long employeeId);
	
	EmployeeResponse save(EmployeeRequest employee);
	EmployeeResponse update(Long employeeId,EmployeeRequest employee);
	boolean deleteById(Long employeeId);
	
	List<EmployeeResponse> findByName(String name);

}
