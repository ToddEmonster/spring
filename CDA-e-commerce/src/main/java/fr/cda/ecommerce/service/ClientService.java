package fr.cda.ecommerce.service;

import java.util.List;

import fr.cda.ecommerce.dto.UserDto;
import fr.cda.ecommerce.model.Client;

public interface ClientService {
	public List<Client> getAllClients();

	public Client getClientById(Long clientId);

	public Client save(Client client);

	public Client registerNewUserAccount(UserDto userDto);
}
