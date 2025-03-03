package com.productcruds.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.productcruds.Entity.Category;
import com.productcruds.Service.CategoryService;

@RestController
public class CategoryController 
{	
	@Autowired
	private CategoryService categoryservice;
	
	@GetMapping("/allcategories")
	public Page<Category> getallCategory(Pageable pageable)
	{
		return categoryservice.getallCategory(pageable);
	}
	
	@GetMapping("/category/{id}")
	public Category getCategoryById(@PathVariable Integer id)
	{
		return categoryservice.getCategoryById(id).orElseThrow();
	}
	
	@PostMapping("/savecategory")
	public void saveCategory(@RequestBody Category category)
	{
		categoryservice.saveCategory(category);
	}
	
	@DeleteMapping("/deletecategory/{id}")
	public void deleteCategory(@PathVariable Integer id)
	{
		categoryservice.deleteCategry(id);
	}
	
	@PutMapping("/updateCategory/{id}")
	public void updateCategory(@PathVariable Integer id, @RequestBody Category category)
	{
		
		Category cat =categoryservice.getCategoryById(id).orElseThrow();
		cat.setId(category.getId());
		cat.setCname(category.getCname());
		
		 categoryservice.saveCategory(cat);
	}
}
