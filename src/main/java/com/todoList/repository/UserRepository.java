package com.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoList.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
