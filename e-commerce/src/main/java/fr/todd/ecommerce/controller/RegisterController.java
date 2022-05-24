package fr.todd.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping(value="")
    public String index() {
        System.out.println("Register page");
        return "register";
    }

    // TODO PostMapping register
}
