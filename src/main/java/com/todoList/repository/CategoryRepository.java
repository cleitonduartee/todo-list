package com.todoList.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.todoList.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
