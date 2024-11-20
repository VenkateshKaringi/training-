package com.vk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.dto.ProductDto;
import com.vk.entity.Product;
import com.vk.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repo;
	
	@Override
	public void save(ProductDto p) {
		Product prdt = new Product();
		prdt.setCode(p.getCode());
		prdt.setName(p.getName());
		prdt.setCategory(p.getCategory());
		prdt.setPrice(p.getPrice());
		
		repo.save(prdt);
	}

	@Override
	public List<Product> list() {
		return repo.findAll();
	}

	@Override
	public Product getByCode(int code) {
		return repo.findById(code).get();
	}

	@Override
	public void delete(int code) {
		repo.deleteById(code);
	}

	@Override
	public List<Product> listByCategory(String cate) {
		return repo.findByCategory(cate);
	}

	@Override
	public List<Product> listByRange(double min, double max) {
		return repo.findByPriceBetween(min, max);
	}

	@Override
	public List<Product> listByPriceLowToHigh() {
		return repo.findByOrderByPriceAsc();
	}

}
