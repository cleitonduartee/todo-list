package com.todoList.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.todoList.entities.User;
import com.todoList.repository.UserRepository;
import com.todoList.services.Exceptions.DataBaseException;
import com.todoList.services.Exceptions.ResourceNotFoundException;

@Service
public class UserServices {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("resource not found. ID " + id));
	}

	public User insert(User user) {
		try {
			return repository.save(user);
		} 
		catch (ConstraintViolationException e) {
			throw new ValidationException(e.getMessage());
		}		
		catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		} 
	}

	public void delete(Long id) {
		try {			
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found. ID "+id);
		}catch (DataIntegrityViolationException e) {			
			throw new DataBaseException(e.getMessage());
		}		
	}

	public User update(Long id, User obj) {
		try {
			User user = repository.getOne(id);
			updateData(user, obj);
			return repository.save(user);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Resource not found. Id "+id) ;
		} catch (TransactionSystemException e) {
			throw new ValidationException(e.getMostSpecificCause());
		}
	}

	public void updateData(User user, User obj) {
		user.setEmail(obj.getEmail());
		user.setName(obj.getName());
	}
	

}
