package org.julian.reviewsiteproject.controller;

import org.julian.reviewsiteproject.entities.Review;
import org.julian.reviewsiteproject.entities.ReviewComment;
import org.julian.reviewsiteproject.entities.Tag;
import org.julian.reviewsiteproject.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TagController {
	
	@Autowired
	private TagRepository tagRepo;
	
	@RequestMapping("/tags")
	public String getTags(Model model)
	{
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}
	
	@RequestMapping("/tags/{name}")
	public String getListOfMoviesFromTag(@PathVariable(name="name")String name, Model model)
	{
		model.addAttribute("tag", tagRepo.findByName(name));
		return "tag";
	}
}
