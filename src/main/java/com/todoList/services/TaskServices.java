package com.todoList.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.todoList.entities.Task;
import com.todoList.repository.TaskRepository;
import com.todoList.services.Exceptions.ResourceNotFoundException;



@Service
public class TaskServices {

	@Autowired
	private TaskRepository repository;
	
	public List<Task> findAll(){
		List<Task> tasks = repository.findAll();
		return tasks;
	}
	
	public Task findById(Long id) {
		Optional<Task> task = repository.findById(id);
		return task.orElseThrow(()->new ResourceNotFoundException("Resource not found. Id "+id));
	}
	
	public Task insert (Task task) {
		task = repository.save(task);
		return task;
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found. Id "+id); 
		}
	}
	public Task update(Long id, Task obj) {
		try {
			Task task = repository.getOne(id);
			updateData(task, obj);
			
			return repository.save(task);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Resource not found. Id "+id); 
		}
	}
	public void updateData(Task task, Task obj) {
		task.setCategory(obj.getCategory());
		task.setDescription(obj.getDescription());
		task.setUser(obj.getUser());
	}
	
	
}
