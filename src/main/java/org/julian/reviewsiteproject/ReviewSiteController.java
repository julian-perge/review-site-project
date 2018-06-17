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
	ReviewSiteRepository reviewRepository;
	
	// localhost:8080/reviews
	// thuglyfe
	
	@RequestMapping("/reviews")
	public String getReviews(Model model)
	{
		model.addAttribute("reviews", reviewRepository.getReviews());
		return "reviews";
	}
	
	@RequestMapping("/reviews/{id}")
	public String getReview(@PathVariable(name="id")Long id, Model model)
	{
		model.addAttribute("review", reviewRepository.findById(id));
		return "review";
	}
	
	@RequestMapping("/reviews/tags")
	public String getTags(Model model)
	{
		model.addAttribute("tags", reviewRepository.getAllTags());
		return "tags";
	}
	
	@RequestMapping("/reviews/tags/{tag}")
	public String getListOfMoviesFromTag(@PathVariable(name="tag")String tag,  Model model)
	{
		model.addAttribute("reviews", reviewRepository.findReviewsByTag(tag));
		return "tag";
	}
}
