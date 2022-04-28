package fr.todd.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan("fr.*")
public class ECommerceApplication {

	public static void main(String[] args) {

		// TP 2
//		ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");

		// TP 3
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ECommerceApplication.class);

		SpringApplication.run(ECommerceApplication.class, args);
	}

}
