package org.julian.reviewsiteproject.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.julian.reviewsiteproject.entities.Review;
import org.julian.reviewsiteproject.entities.ReviewComment;
import org.julian.reviewsiteproject.entities.Tag;
import org.julian.reviewsiteproject.repository.ReviewCommentRepository;
import org.julian.reviewsiteproject.repository.ReviewRepository;
import org.julian.reviewsiteproject.repository.TagRepository;
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
  @Autowired private ReviewCommentRepository commentRepo;
  @Autowired private TagRepository tagRepo;

  // localhost:8080/reviews
  // thuglyfe

  @RequestMapping("/")
  public String home() {
    return "redirect:/reviews";
  }

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

  @RequestMapping(value = "/reviews/{title}/addTag", method = RequestMethod.POST)
  public String addTag(
      @PathVariable(name = "title") String reviewTitle, @RequestParam String tagName) {
    Review review = reviewRepo.findByTitle(reviewTitle);
    if (review != null) {
      if (tagRepo.findByName(tagName) == null) {
        review.addTag(tagRepo.save(new Tag(tagName)));
//        review.getTags().addAll(reviewTagsPlusOne);
      }
    }
    return "redirect:/reviews/{title}";
  }

  // I cry. NullPointer when adding a comment to a review
  @RequestMapping(value = "/reviews/{title}", method = RequestMethod.POST)
  public String postComment(
      @PathVariable(name = "title") String reviewTitle,
      @RequestParam String title,
      @RequestParam String description) {
    Review review = reviewRepo.findByTitle(reviewTitle);
    if (review != null) {
      ReviewComment comment = commentRepo.save(new ReviewComment(title, description, review));
    }
    return "redirect:/reviews/{title}";
  }
}
