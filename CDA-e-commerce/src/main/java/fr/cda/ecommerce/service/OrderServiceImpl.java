package fr.cda.ecommerce.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cda.ecommerce.exception.StockException;
import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Order;
import fr.cda.ecommerce.model.OrderProduct;
import fr.cda.ecommerce.model.Product;
import fr.cda.ecommerce.repository.OrderProductRepository;
import fr.cda.ecommerce.repository.OrderRepository;

@Service("orders")
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	private ProductService productService;

	@Autowired
	public OrderServiceImpl(OrderProductRepository orderProductRepository, OrderRepository orderRepository,
			ProductService productService) {
		super();
		this.orderRepository = orderRepository;
		this.productService = productService;
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order create(Order order) {
		order.setStatus("En cours");
		Order orderCreated = orderRepository.save(order);
		return orderCreated;
	}

	@Override
	public void update(Order order) throws StockException {

		// On teste si la commande n'a pas été payée
		if (!order.getStatus().equals("Payée")) {

			// On regarde si les produits sont en stock suffisemment
			for (OrderProduct orderProduct : order.getOrderProducts()) {
				if (!productService.isProductAvailable(orderProduct.getProduct(), orderProduct.getQuantity())) {
					throw new StockException();
				}
			}

			// On paye
			order.setStatus("Payée");

			for (OrderProduct orderProduct : order.getOrderProducts()) {
				productService.removeProduct(orderProduct.getProduct(), orderProduct.getQuantity());
			}

			orderRepository.save(order);
		}
	}

	@Override
	public Order getCurrentOrder(Client client) {

		// Optional<Order> optionalOrder = getAllOrders().stream().filter(
		// order -> order.getClient().getId().equals(client.getId()) &&
		// order.getStatus().equals("En cours"))
		// .findFirst();

		Optional<Order> optionalOrder = orderRepository.findByClientAndStatus(client, "En cours");

		if (optionalOrder.isPresent()) {
			System.out.println("trouvé");
			return optionalOrder.get();
		} else {
			System.out.println("arf");
			Order order = new Order(null, LocalDate.now(), null, client, new ArrayList<OrderProduct>());
			order = create(order);
			return order;
		}
	}

	@Override
	public void addProduct(Order order, Product product, int quantity) {

		order.addProduct(product, quantity);
		orderRepository.save(order);
	}
}
