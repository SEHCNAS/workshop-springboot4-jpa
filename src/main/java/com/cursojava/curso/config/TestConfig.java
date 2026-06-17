package com.cursojava.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.curso.entities.Category;
import com.cursojava.curso.entities.Order;
import com.cursojava.curso.entities.OrderItem;
import com.cursojava.curso.entities.Product;
import com.cursojava.curso.entities.User;
import com.cursojava.curso.entities.enums.OrderStatus;
import com.cursojava.curso.repositories.CategoryRepository;
import com.cursojava.curso.repositories.OrderItemRepository;
import com.cursojava.curso.repositories.OrderRepository;
import com.cursojava.curso.repositories.ProductRepository;
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
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;

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
		
		Product p1 = new Product(null, "The Lord of the rings", "Lorem ipsum dolor sit, consectetur", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Lorem ipsum dolor sit, consectetur", 2190.0, "");
		Product p3 = new Product(null, "Macbook PRO", "Lorem ipsum dolor sit, consectetur", 1250.0, "");
		Product p4 = new Product(null, "PC gamer", "Lorem ipsum dolor sit, consectetur", 1200.0, "");
		Product p5 = new Product(null, "Rails for dummies", "Lorem ipsum dolor sit, consectetur", 100.99, "");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p2.getCategories().add(c3);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p4.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
	}
	
	
}