package com.employee.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.employee.dto.request.EmployeeRequest;
import com.employee.dto.response.EmployeeResponse;
import com.employee.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	
	public EmployeeResponse toDTO(Employee employee);
	public List<EmployeeResponse> toListDTO(List<Employee> employees);
	public Employee toEntity(EmployeeRequest employeeRequest);

}
