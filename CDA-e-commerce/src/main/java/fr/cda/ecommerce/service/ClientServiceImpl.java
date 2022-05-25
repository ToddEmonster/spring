package fr.cda.ecommerce.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.cda.ecommerce.dto.UserDto;
import fr.cda.ecommerce.exception.UserAlreadyExistException;
import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Role;
import fr.cda.ecommerce.repository.ClientRepository;
import fr.cda.ecommerce.security.MyClientPrincipal;

@Service("clients")
public class ClientServiceImpl implements ClientService, UserDetailsService {

	private final ClientRepository clientRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client getClientById(Long clientId) {
		return clientRepository.getReferenceById(clientId);
	}

	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client registerNewUserAccount(UserDto userDto) {

		if (clientRepository.findByUsername(userDto.getUsername()).isPresent()) {
			throw new UserAlreadyExistException(
					"Compte client déjà existant pour le username : " + userDto.getUsername());
		}

		Client user = new Client(null, userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()));
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role(2l, "ROLE_CLIENT"));
		user.setRoles(roles);

		return save(user);
	}

	private boolean emailExist(String email) {
		return clientRepository.findByUsername(email).isPresent();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Client> optionalClient = clientRepository.findByUsername(username);

		System.out.println("-----------> " + optionalClient);

		if (!optionalClient.isPresent()) {
			throw new UsernameNotFoundException(username);
		}
		return new MyClientPrincipal(optionalClient.get());
	}
}
