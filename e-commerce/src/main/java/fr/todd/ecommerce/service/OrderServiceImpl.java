package fr.todd.ecommerce.service;

import fr.todd.ecommerce.exception.StockException;
import fr.todd.ecommerce.model.Order;
import fr.todd.ecommerce.model.OrderProduct;
import fr.todd.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private final List<Order> allOrders = new ArrayList<>();
    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Order> getAllOrders() {
        return this.allOrders;
    }

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
