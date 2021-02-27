package com.todoList.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoList.entities.User;
import com.todoList.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User user = repository.getOne(id);
		updateData(user, obj);
		
		return repository.save(user);
		
	}
	public void updateData(User user, User obj) {
		user.setEmail(obj.getEmail());
		user.setName(obj.getName());
	}

}
