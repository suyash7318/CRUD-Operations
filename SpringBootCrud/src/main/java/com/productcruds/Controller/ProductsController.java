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

import com.productcruds.Entity.Category;
import com.productcruds.Entity.Products;
import com.productcruds.Service.CategoryService;
import com.productcruds.Service.ProductService;

@RestController
public class ProductsController
{	
	@Autowired
	private ProductService productservice;
	
	@Autowired
	private CategoryService catservice;
	
	@GetMapping("/allproducts")
	public Page<Products> getallProducts(Pageable page)
	{
		return productservice.getallProducts(page);
	}
	
	@GetMapping("/product/{id}")
	public Products getproductById ( @PathVariable Integer id)
	{
		return productservice.getProductByid(id).orElseThrow();
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public void deleteproduct(@PathVariable Integer id)
	{
		productservice.deleteProduct(id);
	}
	
	@PostMapping("/saveproduct/{id}")
	public void saveproduct(@RequestBody Products product,@PathVariable Integer id)
	{	
		Category cat = catservice.getCategoryById(id).orElseThrow();
		product.setCid(cat.getId());
		product.setCname(cat.getCname());
		productservice.saveProduct(product,id);
	}
	
	@PutMapping("/updateproduct/{id}")
	public void updateProduct(@PathVariable Integer id , @RequestBody Products prod)
	{
		Products product = productservice.getProductByid(id).orElseThrow();
		product.setId(prod.getId());
		product.setName(prod.getName());
		product.setPrice(prod.getPrice());
		product.setCategory(prod.getCategory());
		
		productservice.saveProduct(product,id);
	}
}
