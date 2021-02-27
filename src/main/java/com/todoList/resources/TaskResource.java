package com.todoList.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoList.entities.Task;
import com.todoList.services.TaskServices;

@RestController
@RequestMapping("/tasks")
public class TaskResource {

	@Autowired
	private TaskServices services;
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll(){
		List<Task> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Task> findbyId(@PathVariable Long id){
		Task task = services.findById(id);
		return ResponseEntity.ok().body(task);
	}
	@PostMapping
	public ResponseEntity<Task> insert (@RequestBody Task task){
		task = services.insert(task);
		return ResponseEntity.status(HttpStatus.CREATED).body(task);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task obj){
		obj = services.update(id,obj);
		return ResponseEntity.ok().body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
