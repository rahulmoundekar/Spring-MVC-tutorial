package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ModelAttribute("employees")
	public List<Employee> listOfEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping(value = "/signup")
	public String viewHome() {
		return "registration";
	}

	@PostMapping(value = "save")
	public String saveOrUpdateEmployee(Model model, @ModelAttribute Employee employee,
			RedirectAttributes redirectAttributes) {
		Boolean result = employeeService.saveOrUpdate(employee);
		if (result)
			redirectAttributes.addFlashAttribute("success", "Employee saved");
		else
			redirectAttributes.addFlashAttribute("error", "employee not saved.try again");
		return "redirect:/signup";
	}

	@GetMapping(value = "delete")
	public String deleteEmployee(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
		Boolean result = employeeService.deleteEmployee(id);
		if (result)
			redirectAttributes.addFlashAttribute("success", "Employee Deleted");
		else
			redirectAttributes.addFlashAttribute("error", "employee not Deleted.try again");
		return "redirect:/signup";
	}

}
