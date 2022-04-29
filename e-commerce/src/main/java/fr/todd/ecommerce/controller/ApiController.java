package fr.todd.ecommerce.controller;

import fr.todd.ecommerce.exception.ResourceNotFoundException;
import fr.todd.ecommerce.model.Client;
import fr.todd.ecommerce.model.Order;
import fr.todd.ecommerce.model.Product;
import fr.todd.ecommerce.service.ClientService;
import fr.todd.ecommerce.service.OrderService;
import fr.todd.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/clients")
    public List<Client> getClients(Model model,
            @RequestParam(name="username", required=false) String searchedUsername) {
        System.out.println("/clients : get clients with or without username search");

        if (searchedUsername != null) {
            try {
                return this.clientService.getClientByUsername(searchedUsername);
            } catch (ResourceNotFoundException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

        return clientService.getAllClients();
    }

    @GetMapping(value = { "/products"})
    public List<Product> getProducts(Model model) {
        System.out.println("/products : get all products");
        return productService.getAllProducts();
    }

    @GetMapping(value = { "/orders"})
    public List<Order> getOrders(Model model) {
        System.out.println("/products : get all orders");
        return orderService.getAllOrders();
    }
}
