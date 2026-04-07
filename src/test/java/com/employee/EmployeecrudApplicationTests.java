package com.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.employee.controller.EmployeeController;
import com.employee.dto.request.EmployeeRequest;
import com.employee.dto.response.EmployeeResponse;
import com.employee.service.EmployeeService;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EmployeecrudApplicationTests {
	
	@Mock
	private EmployeeService employeeService;
	
	@InjectMocks
	private EmployeeController employeeController;

	@Test
	void testFindById() {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setEmployeeId(2L);
		employeeResponse.setFirstName("Juan");
		employeeResponse.setStatus(1);
		
		when(employeeService.findById(2L)).thenReturn(employeeResponse);
		
		ResponseEntity<EmployeeResponse> response = employeeController.findById(2L);
		EmployeeResponse emp = response.getBody();
		assertNotNull(emp);
		System.out.println("emp:" + emp);
		
		String firstName = Optional.ofNullable(emp).map(EmployeeResponse::getFirstName).orElse("");
		assertEquals("Juan",firstName);
	}
	
	@Test
	void testUpdate() {
		EmployeeRequest employeeRequest = new EmployeeRequest();
		employeeRequest.setLastName("MARTINEZ");
		employeeRequest.setStatus(0);
		
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setEmployeeId(3L);
		employeeResponse.setFirstName("KAREN");
		employeeResponse.setLastName("MARTINEZ");
		employeeResponse.setStatus(0);
		
		when(employeeService.update(3L, employeeRequest)).thenReturn(employeeResponse);
		
		ResponseEntity<EmployeeResponse> response = employeeController.update(3L, employeeRequest);
		EmployeeResponse emp = response.getBody();
		assertNotNull(emp);
		System.out.println("emp:" + emp);
	}

}
