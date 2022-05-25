package fr.cda.ecommerce.service;

import java.util.List;

import fr.cda.ecommerce.exception.StockException;
import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Order;
import fr.cda.ecommerce.model.Product;

public interface OrderService {
	public List<Order> getAllOrders();

	public Order getCurrentOrder(Client client);
	
	public Order create(Order order);
	
	public void addProduct(Order order, Product product, int quantity);

	public void update(Order order) throws StockException;
}
