package fr.todd.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller de la page d'authentification
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * Méthode d'ouverture de la page Login
     * @return
     */
    @GetMapping(value="")
    public String index() {
        System.out.println("Login page");
        return "login";
    }

    // TODO : redirection si user déjà authentifié

    // Pas besoin de mettre une méthode POST pour l'authentification, c'est géré par Spring
}
