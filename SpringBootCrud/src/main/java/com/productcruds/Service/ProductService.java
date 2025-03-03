package com.productcruds.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.productcruds.Entity.Category;
import com.productcruds.Entity.Products;

import com.productcruds.Repository.ProductRepository;

@Service
public class ProductService 
{		
		@Autowired
		private ProductRepository productRepo;
		@Autowired
		private CategoryService categoryService;
		public Page<Products> getallProducts(Pageable page)
		{
			return productRepo.findAll(page);
		}
		
		public Optional<Products> getProductByid(Integer id)
		{
			return productRepo.findById(id);
		}
		
		public void deleteProduct(Integer id)
		{
			productRepo.deleteById(id);
			
		}
		
		public void saveProduct(Products product,Integer id)
		{
			Category category = categoryService.getCategoryById(id).orElseThrow();
			product.setCategory(category);
			productRepo.save(product);
		}
}
