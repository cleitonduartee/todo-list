package com.todoList.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoList.entities.Category;
import com.todoList.repository.CategoryRepository;

@Service
public class CategoryServices {
	
	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll(){
		List<Category> list = repository.findAll();
		return list;
	}
	
	public Category findById(Long id) {
		Optional<Category> cat = repository.findById(id);
		return cat.get();
	}
	
	public Category insert(Category cat) {
		return repository.save(cat);
	}
	
	public void delete(Long id) {
		 repository.deleteById(id);
	}
	
	public Category update(Long id, Category obj) {
		Category cat = repository.getOne(id);
		updateData(cat, obj);
		
		return repository.save(cat);
	}
	public void updateData(Category category, Category obj) {
		category.setName(obj.getName());
	}
}
