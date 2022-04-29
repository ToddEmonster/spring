package fr.todd.ecommerce.service;

import fr.todd.ecommerce.exception.StockException;
import fr.todd.ecommerce.model.Order;
import fr.todd.ecommerce.model.OrderProduct;
import fr.todd.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("orders")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    private final List<Order> allOrders = new ArrayList<>();


    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    // TODO with repo
    @Override
    public Order create(Order order) {
        boolean orderIsPresent = this.allOrders
                .stream()
                .anyMatch(existingOrder -> Objects.equals(existingOrder.getId(), order.getId()));

        if (!orderIsPresent) {
            order.setStatus("En cours");
            this.allOrders.add(order);
            return order;
        }
        return null;
    }

    // TODO with repo
    @Override
    public void update(Order order) throws StockException {
        if (!Objects.equals(order.getStatus(), "Payée")) {
            List<OrderProduct> orderProducts = this.allOrders
                    .stream()
                    .filter(o -> Objects.equals(o.getId(), order.getId()))
                    .findFirst()
                    .get()
                    .getOrderProducts();

            for (OrderProduct orderProduct : orderProducts) {
                if (this.productService.isProductAvailable(orderProduct.getProduct(), orderProduct.getQuantity())) {
                    this.allOrders
                            .stream()
                            .filter(o -> Objects.equals(o.getId(), orderProduct.getOrder().getId()))
                            .findFirst()
                            .get()
                            .setStatus("Payée");
                } else {
                    throw new StockException();
                }
            }
        }
    }
}
