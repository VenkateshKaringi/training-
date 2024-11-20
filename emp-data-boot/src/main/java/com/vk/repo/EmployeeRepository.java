package com.vk.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vk.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("From Employee where hireDate BETWEEN :sd AND :ed")
	List<Employee> findAllHiredBetween(@Param("sd") LocalDate s,@Param("ed") LocalDate e);
	
	@Query("From Employee where hireDate < :dt")
	List<Employee> findAllHiredBefore(@Param("dt") LocalDate d);
}
