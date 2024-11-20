package com.vk.service;

import java.time.LocalDate;
import java.util.List;

import com.vk.entity.Employee;
import com.vk.util.EmployeeNotFoundException;

import jakarta.validation.Valid;

public interface EmployeeService {
	
	public void save(Employee e);
	
	public Employee fetch(int id) throws EmployeeNotFoundException;
	
	public List<Employee> list();
	
	public void remove(int id);
	
	public List<Employee> fetchAllJoinedUntil(LocalDate d);
	
	public List<Employee> fetchAllJoinedBetween(LocalDate s,LocalDate e);
	
	public Employee saveEmployee(@Valid Employee e);
}
