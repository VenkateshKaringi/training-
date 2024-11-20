package com.vk.service;

import java.util.List;

import com.vk.dto.ProductDto;
import com.vk.entity.Product;

public interface ProductService {
	
	void save (ProductDto p);
	
	List<Product> list();
	
	Product getByCode(int code);
	
	void delete(int code);
	
	List<Product> listByCategory(String cate);
	
	List<Product> listByRange(double min , double max);
	
	List<Product> listByPriceLowToHigh();
	
	

}
