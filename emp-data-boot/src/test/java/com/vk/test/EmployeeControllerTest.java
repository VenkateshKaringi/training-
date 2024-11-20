package com.vk.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.vk.entity.Employee;
import com.vk.repo.EmployeeRepository;
import com.vk.rest.EmployeeController;
import com.vk.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private EmployeeRepository repo;
	@InjectMocks
	private EmployeeService service;
	
	private Employee employee;
	
	
	 @Test
	    public void testListEmployee() throws Exception {

	       Employee ee = new Employee(991, "Fi", "business", 5000, LocalDate.of(2024, 11, 11));
	       Employee ee1 = new Employee(981, "hi", "business", 6000, LocalDate.of(2024, 12, 11));
	       

	    }
	

}
