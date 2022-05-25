package fr.todd.ecommerce.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller de la page Home et d'autres pages publiques
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        System.out.println("/ : Home page");
        return "home";
    }

    /**
     * Page apparaissant après une authentification réussie
     * @return
     */
    @GetMapping("/bonjour")
    public String printBonjour() {
        System.out.println("/ : Bonjour page");
        return "bonjour";
    }

    /**
     * Page accessible uniquement à l'utilisateur de username "jeannine"
     * @return
     */
    @PreAuthorize("authentication.principal.username == 'jeannine'")
    @GetMapping("/jeannine")
    public String helloJeannine() {
        System.out.println("/ Page spéciale Jeannine");
        return "jeannine";
    }
}
