package fr.todd.ecommerce.service;

import fr.todd.ecommerce.exception.ResourceNotFoundException;
import fr.todd.ecommerce.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    private final List<Client> allClients = new ArrayList<>();

    @Override
    public List<Client> getAllClient() {
        return this.allClients;
    }

    @Override
    public Client getClientById(Long clientId) throws ResourceNotFoundException {
        Optional<Client> optionalClient = this.allClients
                .stream()
                .filter(client -> client.getId().equals(clientId))
                .findFirst();

        if (!optionalClient.isPresent()) {
            throw new ResourceNotFoundException();
        } else {
            return optionalClient.get();
        }
    }

    @Override
    public Client save(Client client) {
        boolean clientExists = this.allClients
                .stream()
                .anyMatch(existingProduct -> existingProduct.equals(client));
        if (!clientExists) {
            this.allClients.add(client);
            return client;
        }
        return null;
    }
}
