package fr.todd.ecommerce.service;

import fr.todd.ecommerce.exception.EmailAlreadyExistsException;
import fr.todd.ecommerce.exception.ResourceNotFoundException;
import fr.todd.ecommerce.exception.UsernameAlreadyExistsException;
import fr.todd.ecommerce.model.Client;
import fr.todd.ecommerce.service.dto.ClientDTO;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    Client getClientById(Long clientId) throws ResourceNotFoundException;
    List<Client> getClientByUsername(String username) throws ResourceNotFoundException;
    List<Client> getClientsByUsernameSearch(String username);
    Client save(Client client);
    void addNewClient(ClientDTO clientDTO) throws UsernameAlreadyExistsException, EmailAlreadyExistsException;
}
