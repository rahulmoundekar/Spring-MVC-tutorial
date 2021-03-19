package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.bean.ColorDto;
import com.app.bean.ColorTransformer;
import com.app.bean.ProductDto;
import com.app.entity.ColorEntity;
import com.app.repo.ColorRepo;

@Controller
public class ProductController {

	@Autowired
	private ColorRepo colorRepo;

	@GetMapping(value = "/")
	public String viewHome(Model model) {
		List<ColorDto> colorDtos = new ArrayList<ColorDto>();
		ProductDto productDto = new ProductDto();

		List<ColorEntity> colorEntities = colorRepo.getColors();
		for (ColorEntity colorEntity : colorEntities) {
			colorDtos.add(ColorTransformer.transformEntityToBean(colorEntity));
		}
		productDto.setColors(colorDtos);
		model.addAttribute("productForm", productDto);
		return "registration";
	}

	@PostMapping(value = "add")
	public String addProducts(Model model, @ModelAttribute("productForm") ProductDto productDto,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		System.out.println(productDto.getName() + "\t" + productDto.getPrice());
		productDto.getColors().forEach(System.out::println);
		
		return "redirect:/";
	}

}
