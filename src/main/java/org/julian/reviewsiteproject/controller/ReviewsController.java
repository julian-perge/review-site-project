package org.julian.reviewsiteproject.controller;

import org.julian.reviewsiteproject.entities.Review;
import org.julian.reviewsiteproject.entities.ReviewComment;
import org.julian.reviewsiteproject.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class ReviewsController {
  @Autowired private ReviewRepository reviewRepo;

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
    return "review";
  }

  // I cry. NullPointer when adding a comment to a review
//  @RequestMapping(value = "/reviews/{title}", method = RequestMethod.POST)
//  public String postComment(
//      @PathVariable(name = "title") String reviewTitle,
//      @RequestParam(value = "commentTitle") String commentTitle,
//      @RequestParam(value = "commentDescription") String commentDescription) {
//    Review review = reviewRepo.findByTitle(reviewTitle);
//    ReviewComment comment = new ReviewComment(commentTitle, commentDescription);
//    if (review == null) {
//      // do nothing
//    } else {
//        review.addReviewComment(comment);
//    }
//    return "redirect:/reviews/{title}";
//  }
}
