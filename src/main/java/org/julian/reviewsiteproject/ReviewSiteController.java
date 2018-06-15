package org.julian.reviewsiteproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewSiteController
{
	@Autowired
	ReviewSiteRepository reviewRepository;
	
	// localhost:8080/reviews
	// thuglyfe
	@RequestMapping("/reviews")
	public String getReviews(Model model)
	{
		model.addAttribute("reviews", reviewRepository.getReviews());
		return "reviews";
	}
	
	
}
