package com.todoList.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.todoList.entities.Category;
import com.todoList.entities.User;
import com.todoList.repository.CategoryRepository;
import com.todoList.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null,"Cleiton Duarte", "cleiton@teste.com");
		User u2 = new User(null,"José Aparecido", "jose_ap@teste.com");
		User u3 = new User(null,"Pedro Gomes", "pg@teste.com");
		
		Category cat1 = new Category(null, "Limpeza");
		Category cat2 = new Category(null, "Estudar");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		
	}

}
