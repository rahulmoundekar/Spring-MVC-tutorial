package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String viewWelcomePage(Model model) {
		String str = "CONCEPT LEARNING CENTRE";
		model.addAttribute("msg", str);
		return "welcome";
	}

	@PostMapping("/login")
	public String userLogin(HttpServletRequest request) {
		System.out.println(request.getParameter("username") + "\t" + request.getParameter("password"));
		return "redirect:/index";
	}
}
