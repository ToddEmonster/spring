package fr.todd.ecommerce.controller;

import fr.todd.ecommerce.exception.EmailAlreadyExistsException;
import fr.todd.ecommerce.exception.UsernameAlreadyExistsException;
import fr.todd.ecommerce.service.ClientService;
import fr.todd.ecommerce.service.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value="")
    public String index(Model model) {
        System.out.println("Register page");

        ClientDTO clientDto = new ClientDTO();
        model.addAttribute("newClient", clientDto);

        return "register";
    }

    @PostMapping(value="/addNewClient")
    public String register(@ModelAttribute("newClient") ClientDTO clientDto) {
        System.out.println("/: POST register new client");

        // TOEVOL vérification username exists en 1er

        if (!clientDto.passwordsMatch()) {
            // TODO popup passwords don't match
        }

        try {
            this.clientService.addNewClient(clientDto);
        } catch (UsernameAlreadyExistsException usernameException) {
            // TODO afficher popup erreur
            System.out.println(usernameException.getMessage());
        } catch (EmailAlreadyExistsException emailException) {
            // TODO afficher popup erreur
            System.out.println(emailException.getMessage());
        }

        return "/"; // redirection vers Home
    }
}
