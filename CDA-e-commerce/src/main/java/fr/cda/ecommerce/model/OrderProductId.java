package fr.cda.ecommerce.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderProductId implements Serializable {

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "order_id")
	private Long orderId;

	public OrderProductId() {
		super();
	}

	public OrderProductId(Long productId, Long orderId) {
		this.productId = productId;
		this.orderId = orderId;
	}

}
