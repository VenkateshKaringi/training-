package com.vk.rest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vk.entity.Employee;
import com.vk.service.EmployeeService;
import com.vk.util.EmployeeNotFoundException;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping(value="/save" , consumes ="application/json")
	public void saveEmployee(@RequestBody Employee e)
	{
		service.save(e);
		System.out.println(e+" Employee saved");
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee ee){
		service.save(ee);
			return new ResponseEntity<>("created successfully", HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping(value="/fetch/{id}" , produces ="application/json")
	public Employee fetch(@PathVariable int id) throws EmployeeNotFoundException {
		System.out.println("id s are");
		return service.fetch(id);
	}
	
	@GetMapping(value="/list" , produces ="application/json")
	public List<Employee> listEmployee(){
		return service.list();
				//Arrays.asList(new Employee(101, "venky", "analyst", 4000.00,LocalDate.of(2024, 3, 28)),
					//		new Employee(201,"shiv","associate",5000.00,LocalDate.of(2024, 12, 12)));
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable int id) {
		 service.remove(id);
		 System.out.println("removed");
	}
	
	@GetMapping(value ="/fetchby/{dt}" , produces="application/json")
	public List<Employee> list(@PathVariable LocalDate dt){
		return service.fetchAllJoinedUntil(dt);
	}
	
	@GetMapping(value ="/fetchbydate/{sdt}/{edt}" , produces="application/json")
	public List<Employee> listEmp(@PathVariable LocalDate sdt,@PathVariable LocalDate edt){
		return service.fetchAllJoinedBetween(sdt,edt);
	}
	
	@ExceptionHandler( value = EmployeeNotFoundException.class)
	public ResponseEntity< Object> handleException (EmployeeNotFoundException ex)
	{
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	
}
