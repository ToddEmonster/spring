package fr.todd.ecommerce.service;

import fr.todd.ecommerce.exception.ResourceNotFoundException;
import fr.todd.ecommerce.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    Client getClientById(Long clientId) throws ResourceNotFoundException;
    Client save(Client client);
}
