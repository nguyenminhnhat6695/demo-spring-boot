package com.laptrinhjavaweb.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.SecurityService;
import com.laptrinhjavaweb.service.UserService;
import com.laptrinhjavaweb.validator.UserValidator;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/login")
	public String loginPage(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("error", "Your username and password is invalid.");
		}

		if (logout != null) {
			model.addAttribute("message", "You have been logged out successfully.");
		}

		return "login";
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new UserEntity());

		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") UserDTO userDTO, BindingResult bindingResult) {

		UserEntity userForm = new UserEntity();
		userForm.setUsername(userDTO.getUsername());
		userForm.setPassword(userDTO.getPassword());
		userForm.setPassword_confirm(userDTO.getPassword_confirm());
		userForm.setRoles(userDTO.getRoles());

		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		securityService.autoLogin(userForm.getUsername(), userForm.getPassword_confirm());

		return "switch_authorization";
	}

	@RequestMapping(value = "/")
	public ModelAndView homePage() {

		ModelAndView view = new ModelAndView("switch_authorization");
		return view;
	}

	@GetMapping(value = "/access-denied")
	public ModelAndView errorPage() {

		ModelAndView view = new ModelAndView("login");
		view.addObject("message", "Permission denied - please login");
		return view;
	}

}
