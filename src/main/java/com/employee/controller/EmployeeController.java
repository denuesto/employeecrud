package com.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.request.EmployeeRequest;
import com.employee.dto.response.EmployeeResponse;
import com.employee.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/employees")
@Validated
@Tag(name = "Employee Controller", description = "API para la gestión de empleados (CRUD)")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@Operation(summary = "Obtener todos los empleados", description = "Regresa una lista de todos los empleados registrados.")
	@GetMapping
	public ResponseEntity<List<EmployeeResponse>> findAll(){
		return ResponseEntity.ok(employeeService.findAll());
	}
	
	@Operation(summary = "Buscar empleado por ID", description = "Envía un ID para buscar un empleado específico.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Empleado encontrado"),
		@ApiResponse(responseCode = "404", description = "Empleado no encontrado")
	})
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponse> findById(@PathVariable("id") 
													@Min(value = 1, message = "el valor minimo es 1")
													Long employeeId) {
		log.debug("Buscando empleado con ID: {}", employeeId);
		return ResponseEntity.ok(employeeService.findById(employeeId));
	}
	
	@Operation(summary = "Registrar nuevo empleado", description = "Crea un nuevo registro de empleado en la base de datos.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Empleado creado exitosamente"),
		@ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
	})
	@PostMapping
	public ResponseEntity<EmployeeResponse> save(@Valid @RequestBody EmployeeRequest employee){
		log.info("Iniciando crear empleado: {} {}", employee.getFirstName(), employee.getLastName());
		EmployeeResponse response = employeeService.save(employee);
        
        log.info("Empleado creado exitosamente con ID: {}", response.getEmployeeId());
        return ResponseEntity.ok(response);
	}
	
	@Operation(summary = "Actualizar empleado", description = "Actualiza la información de un empleado existente basado en su ID.")
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponse> update(@PathVariable("id") 
													@Min(value = 1, message = "el valor minimo es 1")
													Long employeeId, 
													@RequestBody EmployeeRequest employee){
		return ResponseEntity.ok(employeeService.update(employeeId, employee));
	}
	
	@Operation(summary = "Eliminar empleado", description = "Elimina de forma lógica o física un empleado por su ID.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteById(@PathVariable("id") 
											  @Min(value = 1, message = "el valor minimo es 1")
											  Long employeeId){
		return ResponseEntity.ok(employeeService.deleteById(employeeId));
	}
	
	@Operation(summary = "Buscar empleados por nombre", description = "Busca coincidencias en nombre o apellidos.")
	@GetMapping("/search")
	public ResponseEntity<List<EmployeeResponse>> findByName(@RequestParam("name") 
															@Size(min = 2, max = 50, message = "El mínimo permitido son 2 caracteres")
															String name) {
		return ResponseEntity.ok(employeeService.findByName(name));
	}

}
