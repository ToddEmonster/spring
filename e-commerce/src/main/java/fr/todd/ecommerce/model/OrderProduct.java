package fr.todd.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name="order_product")
public class OrderProduct {

    @EmbeddedId
    private OrderProductId id;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    @Column
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
