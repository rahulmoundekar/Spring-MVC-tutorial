package com.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dto.AddressDto;
import com.app.dto.EmployeeDto;
import com.app.entity.Address;
import com.app.entity.Employee;
import com.app.repo.EmployeeRepo;
import com.app.transformer.AddressTransformer;
import com.app.transformer.EmployeeTransformer;
import com.app.validators.EmployeeValidators;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepo employeeRepo;

	@RequestMapping(value = "/")
	public String viewHome(Model model) {
		EmployeeDto employee = new EmployeeDto();

		AddressDto local = new AddressDto();
		AddressDto parm = new AddressDto();

		List<AddressDto> addresses = new ArrayList<AddressDto>();
		addresses.add(local);
		addresses.add(parm);

		employee.setAddresses(addresses);

		model.addAttribute("employeeForm", employee);
		return "registration";
	}

	@PostMapping("save")
	public String save(Model model, @ModelAttribute("employeeForm") @Validated EmployeeDto employeeDto,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("employeeForm", employeeDto);
			return "registration";
		} else {

			List<Address> addresses = new ArrayList<>();

			Employee employee = EmployeeTransformer.employeeBeanToEnity(employeeDto);

			for (AddressDto addressDto : employeeDto.getAddresses()) {
				Address address = AddressTransformer.addressBeanToEntity(addressDto);
				address.setEmployee(employee);
				addresses.add(address);
			}
			employee.setAddresses(addresses);

			Boolean flag = employeeRepo.saveEmployee(employee);
			return "redirect:/";
		}
	}

	@InitBinder("employeeForm")
	public void formBinding(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(new EmployeeValidators());
	}

}
