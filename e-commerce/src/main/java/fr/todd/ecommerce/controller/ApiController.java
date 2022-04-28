package fr.todd.ecommerce.controller;

import fr.todd.ecommerce.model.Client;
import fr.todd.ecommerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/clients")
    public List<Client> getClients(Model model) {
        System.out.println("/clients : get all clients");

        return clientService.getAllClients();
    }
}
