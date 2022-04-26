package fr.todd.ecommerce;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
//		SpringApplication.run(fr.todd.ecommerce.ECommerceApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
	}

}
