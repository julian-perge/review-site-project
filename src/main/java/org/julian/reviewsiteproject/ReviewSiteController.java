package org.julian.reviewsiteproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewSiteController
{
	@Autowired
	private ReviewRepository reviewRepo;
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private TagRepository tagRepo;
	
	// localhost:8080/reviews
	// thuglyfe
	
	
	@RequestMapping("/reviews")
	public String getReviews(Model model)
	{
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}
	
	@RequestMapping("/reviews/{id}")
	public String getReview(@PathVariable(name="id")Long id, Model model)
	{
		model.addAttribute("review", reviewRepo.findOne(id));
		return "review";
	}
	
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
	
	@RequestMapping("/reviews/tags")
	public String getTags(Model model)
	{
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}
	
	@RequestMapping("/reviews/tags/{id}")
	public String getListOfMoviesFromTag(@PathVariable(name="id")Long id,  Model model)
	{
		model.addAttribute("tag", tagRepo.findOne(id).toString());
		return "tag";
	}
}
