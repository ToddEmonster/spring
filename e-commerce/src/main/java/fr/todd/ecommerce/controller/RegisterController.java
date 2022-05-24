package fr.todd.ecommerce.controller;

import fr.todd.ecommerce.service.dto.ContactDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping(value="")
    public String index(Model model) {
        System.out.println("Register page");

        ContactDTO contactDto = new ContactDTO();
        model.addAttribute("contact", contactDto);

        return "register";
    }

    @PostMapping(value="")
    public void register() {

    }
    // TODO PostMapping register
}
