package com.employee.dto.response;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
public class EmployeeResponse {

	private Long employeeId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String secondLastName;
	
	private Integer age;
	
	private String gender;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Mexico_City")
	private Date birthDate;
	
	private String position;
	
	private LocalDateTime createdAt;
	
	private Integer status;
}
