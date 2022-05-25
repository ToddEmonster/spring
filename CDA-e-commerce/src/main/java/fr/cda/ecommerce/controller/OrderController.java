package fr.cda.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.cda.ecommerce.exception.StockException;
import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Order;
import fr.cda.ecommerce.model.OrderProduct;
import fr.cda.ecommerce.security.MyClientPrincipal;
import fr.cda.ecommerce.service.ClientService;
import fr.cda.ecommerce.service.OrderService;
import fr.cda.ecommerce.service.ProductService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ClientService clientService;

	@GetMapping(value = "/current")
	public String getCurrentoOrder(Model model) {
		System.out.println("/orders/current : get current order");

		MyClientPrincipal clientPrincipal = (MyClientPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Order order = orderService.getCurrentOrder(clientPrincipal.getClient());
		model.addAttribute("order", order);

		return "order";
	}

	@GetMapping(value = "/products/{productId}")
	public String getAddProduct(Model model, @PathVariable("productId") Long id) {
		System.out.println("/orders/products/" + id + " : add product");

		MyClientPrincipal clientPrincipal = (MyClientPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Order order = orderService.getCurrentOrder(clientPrincipal.getClient());
		orderService.addProduct(order, productService.getProductById(id), 1);
		model.addAttribute("order", order);

		return "order";
	}

	@GetMapping(value = "/current/update")
	public String update(Model model) {
		System.out.println("/orders/current : get current order");
		MyClientPrincipal clientPrincipal = (MyClientPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Order order = orderService.getCurrentOrder(clientPrincipal.getClient());

		try {
			orderService.update(order);
		} catch (StockException e) {
			e.printStackTrace();
		}

		return "home";
	}
}
