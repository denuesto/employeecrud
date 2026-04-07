package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{
	
	static final String QUERY_FIND_BY_NAME = """ 
			SELECT e FROM Employee e 
			WHERE firstName like %:name% OR  middleName like %:name% 
			OR  lastName like %:name%  OR  secondLastName like %:name% 
			""";
	
	@Query(value = QUERY_FIND_BY_NAME)
	List<Employee> findByNameJPQL(@Param("name") String name);
}
