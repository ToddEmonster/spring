package fr.cda.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import fr.cda.ecommerce.dto.UserDto;
import fr.cda.ecommerce.exception.UserAlreadyExistException;
import fr.cda.ecommerce.security.MyClientPrincipal;
import fr.cda.ecommerce.service.ClientService;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	public ClientService clientService;
	
	@GetMapping("/")
	public String index() {
		System.out.println("/ : Home page");
		return "home";
	}

	@GetMapping("/principal")
	public String principal(Model model) {
		System.out.println("/ : principal page");

		MyClientPrincipal clientPrincipal = (MyClientPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		model.addAttribute("principal_object", clientPrincipal);

		return "principal";
	}

	@GetMapping("/login")
	public String login() {
		System.out.println("/ : login page");
		return "login";
	}

	@GetMapping("/registration")
	public String showRegistrationForm(WebRequest request, Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "registration";
	}

	@PostMapping("/registration")
	public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("-----> "+bindingResult.toString());
			return "registration";
		}

		try {
			clientService.registerNewUserAccount(userDto);	
		} catch (UserAlreadyExistException e) {
			// Ajout dans le model les infos de l'erreur
			
			return "registration";
		}

		return "home";

	}

}
