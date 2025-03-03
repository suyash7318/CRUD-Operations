package com.productcruds.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.productcruds.Entity.Category;
import com.productcruds.Repository.CategoryRepository;

@Service
public class CategoryService
{	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public Page<Category> getallCategory(Pageable pageable)
	{
		return categoryRepo.findAll(pageable);
	}
	
	public Optional<Category> getCategoryById(Integer id)
	{
		return categoryRepo.findById(id);
	}
	
	public void deleteCategry(Integer id)
	{
		categoryRepo.deleteById(id);
	}
	
	public void saveCategory(Category category)
	{
		categoryRepo.save(category);
	}
}
