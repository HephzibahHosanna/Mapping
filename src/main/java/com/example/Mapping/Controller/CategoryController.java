package com.example.Mapping.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mapping.Entity.Category;
import com.example.Mapping.Entity.CategoryResponse;
import com.example.Mapping.Service.CategoryService;

import jakarta.validation.Valid;


@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/category")
	@RequestMapping(method=RequestMethod.POST, value="/category")
	public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody Category category) {
		boolean status=categoryService.createCategory(category);
		CategoryResponse categoryResponse;
		if (status){
			categoryResponse =new CategoryResponse(true,"Created successfully");
		}else {
			categoryResponse =new CategoryResponse(false,"Already available");

		}
		return ResponseEntity.status(HttpStatus.OK).body(categoryResponse);
	}
	
	@PutMapping("/category/{id}")
	@RequestMapping(method=RequestMethod.PUT, value="/category/{id}")
	public ResponseEntity<CategoryResponse> updateCategory(@Valid @RequestBody Category category, @PathVariable Integer id) {
        boolean status=categoryService.updateCategory(category,id);
		CategoryResponse categoryResponse;
		if (status){
			categoryResponse =new CategoryResponse(true,"Updated successfully");
		}else {
			categoryResponse =new CategoryResponse(false,"Id not found");

		}
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponse);
	}	
	
	
	 @RequestMapping("/category")
	    public List<Category> getAllCategory() {
	        return categoryService.getAllCategory();
	    } 	 
}

