package fr.todd.ecommerce.service;

import fr.todd.ecommerce.model.Client;
import fr.todd.ecommerce.repository.ClientRepository;
import fr.todd.ecommerce.security.MyClientPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe d'implémentation du UserDetailsService pour l'authentification
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private ClientRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> optionalClient = this.userRepository.findByUsername(username);

        if (!optionalClient.isPresent()) {
            throw new UsernameNotFoundException("Username not found :(");
        }
        return new MyClientPrincipal(optionalClient.get());

    }
}
