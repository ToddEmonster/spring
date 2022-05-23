package fr.todd.ecommerce.controller;

import fr.todd.ecommerce.model.Client;
import fr.todd.ecommerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class LoginController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value="")
    public Client getCurrentClient(Model model) {
        System.out.println("");
        return (Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
