package fr.todd.ecommerce.service;

import fr.todd.ecommerce.exception.StockException;
import fr.todd.ecommerce.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order create(Order order);
    void update(Order order) throws StockException;
}
