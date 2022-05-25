package fr.cda.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	Optional<Order> findByClientAndStatus(Client client, String status);
}
