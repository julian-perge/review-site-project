package org.julian.reviewsiteproject.controller;

import org.julian.reviewsiteproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository catRepo;
	
	@RequestMapping("/categories")
	public String getCategories(Model model)
	{
		model.addAttribute("categories", catRepo.findAll());
		return "categories";
	}
	
	@RequestMapping("/categories/{id}")
	public String getCategory(@PathVariable(name="id")Long id, Model model)
	{
		model.addAttribute("category", catRepo.findOne(id));
		return "category";
	}
}
