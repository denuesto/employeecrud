create database evaluacion;

use evaluacion;

drop table evaluacion.empleados;

create table evaluacion.empleados
(
	id_empleado int not null primary key auto_increment,
	primer_nombre varchar(50) not null,
	segundo_nombre varchar(50),
	apellido_paterno varchar(50) not null,
	apellido_materno varchar(50),
	edad int,
	sexo char(1) not null,
	fecha_nacimiento date not null,
	puesto varchar(50),
	fecha_alta timestamp default current_timestamp,
	estatus boolean not null default 1,
	check (sexo in ('M','F','X'))
	
);

select * from evaluacion.empleados;

insert into evaluacion.empleados 
(primer_nombre,segundo_nombre, apellido_paterno,apellido_materno,edad,sexo,fecha_nacimiento,puesto)
values 
('JOSE', 'JUAN', 'RAMIREZ','SANCHEZ',31,'M','1995-02-03','GERENTE DE ALMACEN'),
('KAREN', 'SOFIA', 'VALLE','ALVARADO',29,'F','1997-01-03','COORDINADORA RECURSOS HUMANOS'),
('MARIBEL', 'MARLENE', 'LOPEZ','BELTRAN',50,'F','1976-03-24','DIRECTORA RECURSOS HUMANOS'),
('PEDRO', 'MARIO', 'GUERRERO','FARFAN',42,'M','1983-11-17','INGENIERO DE SOFTWARE'),
('FABIOLA', 'ALEJANDRA', 'HERRERA','MARTINEZ',39,'F','1986-12-11','SUPERVISOR DE AREA');




