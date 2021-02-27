package com.todoList.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.todoList.entities.Category;
import com.todoList.repository.CategoryRepository;
import com.todoList.services.Exceptions.DataBaseException;
import com.todoList.services.Exceptions.ResourceNotFoundException;

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
		return cat.orElseThrow(()-> new ResourceNotFoundException("Resource not found. Id "+id));
	}
	
	public Category insert(Category cat) {
		return repository.save(cat);
	}
	
	public void delete(Long id) {
		 try {
			 repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found. Id "+id);
			
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage()) ;
		}
	}
	
	public Category update(Long id, Category obj) {
		try {
			Category cat = repository.getOne(id);
			updateData(cat, obj);
			
			return repository.save(cat);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Resource not found. Id "+id);
		}
	}
	public void updateData(Category category, Category obj) {
		category.setName(obj.getName());
	}
}
