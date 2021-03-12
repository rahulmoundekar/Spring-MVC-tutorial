package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String userLogin(@ModelAttribute User user) {
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		return "redirect:/index";
	}

	@ModelAttribute("names")
	public List<String> getNames() {
		List<String> list = new ArrayList<String>();
		list.add("Rahul");
		list.add("Mukesh");
		list.add("Rakesh");

		return list;
	}

}
