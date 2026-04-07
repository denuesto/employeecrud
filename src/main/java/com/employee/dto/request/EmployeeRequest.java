package com.employee.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeRequest {

	@NotBlank(message = "el campo firstName es obligatorio")
	@Size(min = 2, max = 50, message = "El maximo permitido es 50 caracteres")
	private String firstName;
	
	private String middleName;
	
	@NotBlank(message = "el campo lastName es obligatorio")
	@Size(min = 2, max = 50, message = "El maximo permitido es 50 caracteres")
	private String lastName;
	
	private String secondLastName;
	
	@Min(value = 1, message = "el valor minimo es 1")
	@Max(value = 99, message = "el valor maximo es 99")
	private Integer age;
	
	@NotBlank(message = "el campo gender es obligatorio")
	@Pattern(regexp = "^[MFXmfx]$", message = "el campo gender solo acepta los valores: M, F, X")
	private String gender;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Mexico_City")
	@NotNull(message = "el campo birthDate es obligatorio")
	private Date birthDate;
	
	private String position;
	
	private Integer status;
}
