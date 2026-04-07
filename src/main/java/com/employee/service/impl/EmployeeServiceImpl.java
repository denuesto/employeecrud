package com.employee.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.dto.request.EmployeeRequest;
import com.employee.dto.response.EmployeeResponse;
import com.employee.entity.Employee;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final EmployeeMapper employeeMapper;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository,EmployeeMapper employeeMapper) {
		this.employeeRepository = employeeRepository;
		this.employeeMapper = employeeMapper;
	}

	@Override
	public List<EmployeeResponse> findAll() {
		
		return employeeMapper.toListDTO(employeeRepository.findAll());
	}

	@Override
	public EmployeeResponse findById(Long employeeId) {

		return employeeMapper.toDTO(employeeRepository.findById(employeeId).get());
	}

	@Override
	public EmployeeResponse save(EmployeeRequest employee) {
		Employee emp = employeeMapper.toEntity(employee);
		EmployeeResponse empResp = employeeMapper.toDTO( employeeRepository.saveAndFlush(emp)) ;
		return empResp;
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
	public EmployeeResponse update(Long employeeId, EmployeeRequest employee) {
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
								
				                EmployeeResponse empResponse =  employeeMapper.toDTO(employeeRepository.saveAndFlush(existingEmployee));
								return empResponse;
							})
							.orElseThrow( () -> new RuntimeException("Empleado no encontrado") );
	}
	
	@Override
	public List<EmployeeResponse> findByName(String name){
		List<EmployeeResponse> employeesResponse = employeeMapper.toListDTO(employeeRepository.findByNameJPQL(name));
		return employeesResponse;
	}

}
