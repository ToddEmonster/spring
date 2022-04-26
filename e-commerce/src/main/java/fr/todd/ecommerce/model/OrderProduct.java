package fr.todd.ecommerce.model;

public class OrderProduct {

    private Order order;
    private Product product;
    private Integer quantity;

    public OrderProduct() {
        super();
    }

    public OrderProduct(Order order, Product product, Integer quantity) {
        super();
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotalPrice() {
        return this.quantity * this.product.getPrice();
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
