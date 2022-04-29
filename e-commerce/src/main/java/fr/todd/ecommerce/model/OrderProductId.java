package fr.todd.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderProductId implements Serializable {

    @Column(name = "product_id")
    private Long order;

    @Column(name = "order_id")
    private Long product;

    public void setOrder(Long order) {
        this.order = order;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Long getOrder() {
        return order;
    }

    public Long getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductId that = (OrderProductId) o;
        return order.equals(that.order) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }

    @Override
    public String toString() {
        return "OrderProductId{" +
                "order=" + order +
                ", product=" + product +
                '}';
    }
}
