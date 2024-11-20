package com.vk.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vk.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
		
	List<Product> findByCategory(String cate);
	
//	@Query("From Product where price BETWEEN :min AND :max")
//	List<Product> listByRange(double min , double max);
	
	List<Product> findByPriceBetween(double min , double max);
	
//	@Query("From Product ORDER BY price ASC")
	List<Product> findByOrderByPriceAsc(); 
	//with the help of dataJPa automatic query should be creat and search it is for 2 asc and desc
}
