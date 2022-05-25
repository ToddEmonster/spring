package fr.todd.ecommerce.repository;

import fr.todd.ecommerce.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUsername(String username);
    boolean existsClientByUsername(String username);
    boolean existsClientByEmail(String email);
}
