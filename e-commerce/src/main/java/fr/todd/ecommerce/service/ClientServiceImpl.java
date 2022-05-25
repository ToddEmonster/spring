package fr.todd.ecommerce.service;

import fr.todd.ecommerce.exception.EmailAlreadyExistsException;
import fr.todd.ecommerce.exception.ResourceNotFoundException;
import fr.todd.ecommerce.exception.UsernameAlreadyExistsException;
import fr.todd.ecommerce.model.Client;
import fr.todd.ecommerce.model.Role;
import fr.todd.ecommerce.repository.ClientRepository;
import fr.todd.ecommerce.repository.RoleRepository;
import fr.todd.ecommerce.service.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implémentation du service ClientService
 */
@Service("clients")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long clientId) throws ResourceNotFoundException {
        Optional<Client> optionalClient = this.clientRepository.findById(clientId);

        if (!optionalClient.isPresent()) {
            throw new ResourceNotFoundException();
        } else {
            return optionalClient.get();
        }
    }

    public List<Client> getClientByUsername(String searchedUsername) throws ResourceNotFoundException {
        Optional<Client> optionalClient = this.clientRepository.findByUsername(searchedUsername);

        if (!optionalClient.isPresent()) {
            throw new ResourceNotFoundException();
        } else {
            List<Client> clientList = new ArrayList<>();
            clientList.add(optionalClient.get());
            return clientList;
        }
    }

    public List<Client> getClientsByUsernameSearch(String searchedUsername) {

        List<Client> clients = new ArrayList<>();
        for (Client client: this.getAllClients()) {

            if (client.getUsername().contains(searchedUsername)) {
                clients.add(client);
            }
        }
        return clients;

    }

    @Override
    public Client save(Client client) {
        boolean clientExists = this.clientRepository.existsById(client.getId());

        if (!clientExists) {
            this.clientRepository.save(client);
            return client;
        }
        return null;
    }

    @Override
    public void addNewClient(ClientDTO clientDTO) throws UsernameAlreadyExistsException, EmailAlreadyExistsException {
        if (this.clientRepository.existsClientByUsername(clientDTO.getUsername())) {
            throw new UsernameAlreadyExistsException();
        }
        if (this.clientRepository.existsClientByEmail(clientDTO.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        ArrayList<Role> defaultRole = new ArrayList<>();
        defaultRole.add(this.roleRepository.findByName("ROLE_CLIENT").get());

        Client newClient = new Client();

        newClient.setUsername(clientDTO.getUsername());
        newClient.setEmail(clientDTO.getEmail());
        newClient.setPassword(passwordEncoder.encode(clientDTO.getPassword()));
        newClient.setRoles(defaultRole);

        this.clientRepository.save(newClient);
    }

}
