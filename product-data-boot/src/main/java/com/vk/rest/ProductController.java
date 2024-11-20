package com.vk.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vk.dto.ProductDto;
import com.vk.entity.Product;
import com.vk.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping(value ="/save" , consumes = "application/json")
	public ResponseEntity<String> save(@RequestBody @Valid ProductDto p){
		service.save(p);
		return new ResponseEntity<String>("Product added.", HttpStatus.OK);
	}
	
	@GetMapping(value = "/list" , produces = "application/json")
	public ResponseEntity<List<Product>> allList(){
		return new ResponseEntity<List<Product>>(service.list() , HttpStatus.CREATED);
	}
//	public List<Product> allList(){
//	return service.list();
//	}
	
	@GetMapping(value ="/bycode/{code}" , produces ="application/json")
	public ResponseEntity<Product> findByCode(@PathVariable int code){
		return new ResponseEntity<Product>(service.getByCode(code) , HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/del/{code}" , produces = "application/json")
	public ResponseEntity<String> deletingByCode(@PathVariable int code){
		service.delete(code);
		return new ResponseEntity<String>("Product Deleted" , HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/category/{cat}")
	public ResponseEntity<List<Product>> listBycatgeory(@PathVariable String cat){
		return new ResponseEntity<List<Product>>(service.listByCategory(cat) , HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/range")
	public ResponseEntity<List<Product>> getByPriceRange(@RequestParam double min, @RequestParam double max){
		return new ResponseEntity<List<Product>>(service.listByRange(min, max) , HttpStatus.CREATED);
	}
	
	@GetMapping(value ="/asc")
	public ResponseEntity<List<Product>> listByDesc(){
		return new ResponseEntity<List<Product>>(service.listByPriceLowToHigh() , HttpStatus.CREATED);
	}
	
	
		
}
