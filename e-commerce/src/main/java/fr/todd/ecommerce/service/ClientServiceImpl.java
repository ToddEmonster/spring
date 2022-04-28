package fr.todd.ecommerce.service;

import fr.todd.ecommerce.exception.ResourceNotFoundException;
import fr.todd.ecommerce.model.Client;
import fr.todd.ecommerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("clients")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

//    private final List<Client> allClients = new ArrayList<>();

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

    @Override
    public Client save(Client client) {
        boolean clientExists = this.clientRepository.existsById(client.getId());

        if (!clientExists) {
            this.clientRepository.save(client);
            return client;
        }
        return null;
    }
}
