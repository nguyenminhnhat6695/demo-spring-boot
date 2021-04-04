package com.laptrinhjavaweb.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfWeb")
@RequestMapping("/user/")
public class HomeController {

	@RequestMapping(value = "")
	public ModelAndView homePage() {
		ModelAndView view = new ModelAndView("web/home");
		return view;
	}
	


}
