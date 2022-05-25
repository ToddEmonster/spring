package fr.cda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cda.ecommerce.model.OrderProduct;
import fr.cda.ecommerce.model.OrderProductId;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductId> {

}
