package com.employee.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Long employeeId) {

		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.saveAndFlush(employee);
	}

	@Override
	public boolean deleteById(Long employeeId) {
		if (employeeRepository.existsById(employeeId)) {
			employeeRepository.deleteById(employeeId);
			return true;
		}
		return false;
	}
	
	@Override
	public Employee update(Long employeeId, Employee employee) {
		return  employeeRepository.findById(employeeId)
							.map(existingEmployee -> {
								
								if (employee.getFirstName() != null) {
				                    existingEmployee.setFirstName(employee.getFirstName());
				                }
				                if (employee.getMiddleName() != null) {
				                    existingEmployee.setMiddleName(employee.getMiddleName());
				                }
				                if (employee.getLastName() != null) {
				                    existingEmployee.setLastName(employee.getLastName());
				                }
				                if (employee.getSecondLastName() != null) {
				                    existingEmployee.setSecondLastName(employee.getSecondLastName());
				                }
				                if (employee.getAge() != null) {
				                    existingEmployee.setAge(employee.getAge());
				                }
				                if (employee.getGender() != null) {
				                    existingEmployee.setGender(employee.getGender());
				                }
				                if (employee.getBirthDate() != null) {
				                    existingEmployee.setBirthDate(employee.getBirthDate());
				                }
				                if (employee.getPosition() != null) {
				                    existingEmployee.setPosition(employee.getPosition());
				                }
				                if (employee.getStatus() != null) {
				                    existingEmployee.setStatus(employee.getStatus());
				                }
								
								return employeeRepository.saveAndFlush(existingEmployee);
							})
							.orElseThrow( () -> new RuntimeException("Empleado no encontrado") );
	}
	
	@Override
	public List<Employee> findByName(String name){
		return employeeRepository.findByNameJPQL(name);
	}

}
