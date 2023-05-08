package com.example.Mapping.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mapping.Entity.Category;
import com.example.Mapping.Repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public boolean createCategory(Category category) {
		Optional<Category>categoryDb = this.categoryRepository.findByName(category.getName());
		
		if(categoryDb.isPresent()) {
			return false;
		}else {
			Category category1 = new Category(category.getName());
			category.setName(category1.getName());
			categoryRepository.save(category);
			return true;
		}
			
	}
	
	@Override
	public boolean updateCategory(Category category,Integer id) {
		Optional<Category> categoryDb = this.categoryRepository.findById(id.longValue());

		if(categoryDb.isPresent()) {
			Category categoryUpdate = categoryDb.get();
			categoryUpdate.setId(id);
			categoryUpdate.setName(category.getName());
			categoryRepository.save(categoryUpdate);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Category> getAllCategory() {
		return this.categoryRepository.findAll();
	}

}

