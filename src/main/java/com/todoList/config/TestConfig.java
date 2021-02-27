package com.todoList.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.todoList.entities.Category;
import com.todoList.entities.Task;
import com.todoList.entities.User;
import com.todoList.repository.CategoryRepository;
import com.todoList.repository.TaskRepository;
import com.todoList.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null,"Cleiton Duarte", "cleiton@teste.com");
		User u2 = new User(null,"José Aparecido", "jose_ap@teste.com");
		User u3 = new User(null,"Pedro Gomes", "pg@teste.com");
		
		Category cat1 = new Category(null, "Limpeza");
		Category cat2 = new Category(null, "Estudar");
		
		Task t1 = new Task(null, "Estudar Prova História", cat2, u3);
		Task t2 = new Task(null, "Estudar Prova Matemática", cat2, u1);
		Task t3 = new Task(null, "Limpar casa na sexta-feira", cat1, u3);
		Task t4 = new Task(null, "Lavar o Carro", cat1, u2);
		Task t5 = new Task(null, "Estudar Concurso", cat2, u2);
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		taskRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5));
		
	}

}
