package com.example.Mapping.Service;

import java.util.List;

import com.example.Mapping.Entity.Category;

public interface CategoryService {

	boolean createCategory(Category category);

	boolean updateCategory(Category category, Integer id);
	
	List<Category>getAllCategory();
	
}
