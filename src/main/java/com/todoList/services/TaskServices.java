package com.todoList.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoList.entities.Task;
import com.todoList.repository.TaskRepository;



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
		return task.get();
	}
	
	public Task insert (Task task) {
		task = repository.save(task);
		return task;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	public Task update(Long id, Task obj) {
		Task task = repository.getOne(id);
		updateData(task, obj);
		
		return repository.save(task);
	}
	public void updateData(Task task, Task obj) {
		task.setCategory(obj.getCategory());
		task.setDescription(obj.getDescription());
		task.setUser(obj.getUser());
	}
	
	
}
