package com.vk.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vk.entity.Product;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public ResponseEntity<Object> handleMethodArgumentsNotValid(MethodArgumentNotValidException e , BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity<>("Not valid" , HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<Object>(e.getMessage() , HttpStatus.BAD_REQUEST);
	}
	
}
