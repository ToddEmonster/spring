package fr.todd.ecommerce.repository;

import fr.todd.ecommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository lié aux rôles d'utilisateur
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String roleName);
}
