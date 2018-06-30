package org.julian.reviewsiteproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewsController
{
	@Autowired
	private ReviewRepository reviewRepo;

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
}
