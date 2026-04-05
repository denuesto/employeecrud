package com.employee.entity;


import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="empleados")
@Data
@DynamicInsert
public class Employee {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empleado")
	private Long employeeId;
	
	@Column( name = "primer_nombre")
	private String firstName;
	
	@Column( name = "segundo_nombre")
	private String middleName;
	
	@Column( name = "apellido_paterno")
	private String lastName;
	
	@Column( name = "apellido_materno")
	private String secondLastName;
	
	@Column(name = "edad")
	private Integer age;
	
	@Column(name = "sexo")
	private String gender;
	
	@Column(name = "fecha_nacimiento")
	private Date birthDate;
	
	@Column(name = "puesto")
	private String position;
	
	@Generated(event = EventType.INSERT)
	@Column(name = "fecha_alta", insertable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@Generated(event = EventType.INSERT)
	@Column(name = "estatus", insertable = false)
	private Integer status;

}
