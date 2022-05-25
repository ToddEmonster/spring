package fr.cda.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Order;
import fr.cda.ecommerce.model.Product;
import fr.cda.ecommerce.service.ClientService;
import fr.cda.ecommerce.service.OrderService;
import fr.cda.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ClientService clientService;

	@GetMapping(value = "/products")
	public List<Product> getProducts(Model model) {
		System.out.println("/products : get all products");

		return productService.getAllProducts();
	}

	@Secured("ROLE_ADMIN")
	@GetMapping(value = "/orders")
	public List<Order> getOrders(Model model) {
		System.out.println("/orders : get all orders");

		return orderService.getAllOrders();
	}

	@GetMapping(value = "/clients")
	public List<Client> getClients(Model model) {
		System.out.println("/clients : get all clients");

		return clientService.getAllClients();
	}

}
