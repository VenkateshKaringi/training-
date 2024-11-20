package com.vk.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vk.entity.Employee;
import com.vk.repo.EmployeeRepository;
import com.vk.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class TestEmployeeService {
	@Mock
	private EmployeeRepository repo;
	@InjectMocks
	private EmployeeService service;
	
	@Test
	public void testSave(Employee e) {
		
	}

}
