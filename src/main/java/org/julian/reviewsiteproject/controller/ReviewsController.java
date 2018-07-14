package org.julian.reviewsiteproject.controller;

import org.julian.reviewsiteproject.entities.Review;
import org.julian.reviewsiteproject.entities.ReviewComment;
import org.julian.reviewsiteproject.repository.ReviewCommentRepository;
import org.julian.reviewsiteproject.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class ReviewsController {
  @Autowired private ReviewRepository reviewRepo;
  @Autowired private ReviewCommentRepository commentRepo;

  // localhost:8080/reviews
  // thuglyfe

  @RequestMapping("/reviews")
  public String getReviews(Model model) {
    model.addAttribute("reviews", reviewRepo.findAll());
    return "reviews";
  }

  @RequestMapping("/reviews/{title}")
  public String getReview(@PathVariable(name = "title") String title, Model model) {
    model.addAttribute("review", reviewRepo.findByTitle(title));
    model.addAttribute("reviewComment", new ReviewComment());
    return "review";
  }

  // I cry. NullPointer when adding a comment to a review
  @RequestMapping(value = "/reviews/{title}", method = RequestMethod.POST)
  public String postComment(
      @PathVariable(name = "title") String reviewTitle,
      @RequestAttribute("reviewComment") ReviewComment reviewComment) {
    Review review = reviewRepo.findByTitle(reviewTitle);
    if (review == null) {
      // do nothing
    } else {
      commentRepo.save(reviewComment);
      System.out.println("COMMENT BEFORE ADDING: ");
      //      review.getRevComEmbed().add(embed);
      System.out.println(review.getRevComEmbed());
      //      embed = null;
    }
    return "redirect:/reviews/{title}";
  }
}
