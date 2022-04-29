package fr.todd.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication()
@ComponentScan("fr.*")
public class ECommerceApplication {

	public static void main(String[] args) {

		// TP 2
//		ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");

		// TP 3
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ECommerceApplication.class);

		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
