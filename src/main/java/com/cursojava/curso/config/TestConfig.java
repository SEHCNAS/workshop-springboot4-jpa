package com.cursojava.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.curso.entities.User;
import com.cursojava.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Marrom", "Maria@Marrom.com", "99999999", "12345");
		User u2 = new User(null, "Alex Azul", "Alex@Azul.com", "9999999", "1234");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}