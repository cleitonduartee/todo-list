package com.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoList.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
