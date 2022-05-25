package fr.cda.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cda.ecommerce.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	Optional<Client> findByUsername(String username);
}
