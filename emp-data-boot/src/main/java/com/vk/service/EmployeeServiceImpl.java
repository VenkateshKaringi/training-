package com.vk.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.entity.Employee;
import com.vk.repo.EmployeeRepository;
import com.vk.util.EmployeeNotFoundException;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public void save(Employee e) {
		repo.save(e);
	}

	@Override
	public Employee fetch(int id) throws EmployeeNotFoundException {
		return repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("No Employee with Id: "+id));
	}
	

	@Override
	public List<Employee> list() {
		return repo.findAll();
	}

	@Override
	public void remove(int id) {
		repo.deleteById(id);
	}

	@Override
	public List<Employee> fetchAllJoinedUntil(LocalDate d) {
		
		return repo.findAllHiredBefore(d);
	}

	@Override
	public List<Employee> fetchAllJoinedBetween(LocalDate s, LocalDate e) {
		return repo.findAllHiredBetween(s, e);
	}

	@Override
	public Employee saveEmployee(@Valid Employee e) {
		return repo.save(e);
	}
	

}
