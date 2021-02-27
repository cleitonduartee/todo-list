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

import com.todoList.entities.Category;
import com.todoList.services.CategoryServices;

@RestController
@RequestMapping("/categories")
public class Categoryresource {

	@Autowired
	private CategoryServices services;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category cat = services.findById(id);
		return ResponseEntity.ok().body(cat);
	}
	@PostMapping
	public ResponseEntity<Category> insert (@RequestBody Category cat){
		cat = services.insert(cat);
		return ResponseEntity.status(HttpStatus.CREATED).body(cat);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Category> update(@PathVariable Long id,@RequestBody Category cat){
		cat = services.update(id, cat);
		return ResponseEntity.ok().body(cat);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
}
