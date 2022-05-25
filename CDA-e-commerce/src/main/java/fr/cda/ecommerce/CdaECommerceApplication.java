package fr.cda.ecommerce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.cda.ecommerce.exception.StockException;
import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Order;
import fr.cda.ecommerce.model.OrderProduct;
import fr.cda.ecommerce.model.Product;
import fr.cda.ecommerce.service.ClientService;
import fr.cda.ecommerce.service.OrderService;
import fr.cda.ecommerce.service.ProductService;

@SpringBootApplication
public class CdaECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdaECommerceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
