package fr.cda.ecommerce.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_order_product")
public class OrderProduct {

	@EmbeddedId
	private OrderProductId id;

	@ManyToOne
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private Order order;

	private int quantity;

	public OrderProduct() {
		super();
	}

	public OrderProduct(OrderProductId id, Order order, Product product, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.order = order;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return getProduct().getPrice() * getQuantity();
	}

}
