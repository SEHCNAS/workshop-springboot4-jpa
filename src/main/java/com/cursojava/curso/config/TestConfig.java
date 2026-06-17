package com.cursojava.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.curso.entities.Category;
import com.cursojava.curso.entities.Order;
import com.cursojava.curso.entities.User;
import com.cursojava.curso.entities.enums.OrderStatus;
import com.cursojava.curso.repositories.CategoryRepository;
import com.cursojava.curso.repositories.OrderRepository;
import com.cursojava.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Marrom", "Maria@Marrom.com", "99999999", "12345");
		User u2 = new User(null, "Alex Azul", "Alex@Azul.com", "9999999", "1234");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-06-21T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-06-22T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}
	
	
}