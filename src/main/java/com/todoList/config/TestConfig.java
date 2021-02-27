package com.todoList.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.todoList.entities.User;
import com.todoList.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null,"Cleiton Duarte", "cleiton@teste.com");
		User u2 = new User(null,"José Aparecido", "jose_ap@teste.com");
		User u3 = new User(null,"Pedro Gomes", "pg@teste.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
	}

}
