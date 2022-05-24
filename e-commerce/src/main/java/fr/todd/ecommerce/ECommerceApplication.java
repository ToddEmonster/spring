package fr.todd.ecommerce;

import fr.todd.ecommerce.model.Client;
import fr.todd.ecommerce.service.ClientService;
import org.springframework.boot.CommandLineRunner;
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

	@Bean
	public CommandLineRunner runner(ClientService clientService) {
		return args -> {
			/*
			// Pour encoder tous les password actuellement stockés en BDD
			for (Client client : clientService.getAllClients()) {

				client.setPassword(passwordEncoder().encode(client.getPassword()));
				clientService.save(client);
			}
			*/
		};
	}
}
