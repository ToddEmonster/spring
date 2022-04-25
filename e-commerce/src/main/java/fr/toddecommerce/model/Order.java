package fr.toddecommerce.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Entité représentant les commandes des clients
 */
public class Order {

    private Long id;
    private LocalDate dateCreated;
    private String status;
    private Client client;
    private List<OrderProduct> orderProducts;

    public Order() {
        super();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getTotalOrderPrice() {
        return this.orderProducts
                .stream()
                .map(OrderProduct::getTotalPrice)
                .reduce(0.0, Double::sum);
    }

    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }

    public int getTotalNumberOfProducts() {
        return this.orderProducts
                .stream()
                .map(OrderProduct::getQuantity)
                .reduce(0, Integer::sum);
    }

    public void addProduct(Product product, int quantity) {
        OrderProduct newOrderProduct = new OrderProduct(this, product, quantity);
        this.orderProducts.add(newOrderProduct);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", status='" + status + '\'' +
                ", client=" + client +
                ", orderProducts=" + orderProducts +
                '}';
    }
}
