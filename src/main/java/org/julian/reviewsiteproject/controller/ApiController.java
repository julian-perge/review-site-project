package org.julian.reviewsiteproject.controller;

import java.util.Collection;

import org.julian.reviewsiteproject.entities.Category;
import org.julian.reviewsiteproject.entities.Review;
import org.julian.reviewsiteproject.entities.Tag;
import org.julian.reviewsiteproject.repository.CategoryRepository;
import org.julian.reviewsiteproject.repository.ReviewRepository;
import org.julian.reviewsiteproject.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

  @Autowired ReviewRepository reviewRepo;
  @Autowired CategoryRepository catRepo;
  @Autowired private TagRepository tagRepo;

  @RequestMapping("/reviews")
  public Collection<Review> getReviews() {
    return (Collection<Review>) reviewRepo.findAll();
  }

  @RequestMapping("/reviews/{title}")
  public Review getReview(@PathVariable(name = "title") String title) {
    return reviewRepo.findByTitle(title);
  }

  @RequestMapping(value = "/reviews/{title}/{tagName}", method = RequestMethod.DELETE)
  public Collection<Tag> deleteTagFromReview(
      @PathVariable(name = "title") String title, @PathVariable(value = "tagName") String tagName) {
    Tag tagToDelete = tagRepo.findByName(tagName);
    reviewRepo.findAll().forEach(review -> review.getTags().remove(tagToDelete));
    tagRepo.delete(tagToDelete.getId());
    return reviewRepo.findByTitle(title).getTags();
  }
  
  @RequestMapping(value = "/reviews/{title}/add-tag", method = RequestMethod.POST)
  public Collection<Tag> addTag(@PathVariable(name="title") String reviewTitle,
		  @RequestParam String tagName) {
	  Tag tagToAdd = tagRepo.save(new Tag(tagName, reviewRepo.findByTitle(reviewTitle)));
	  return (Collection<Tag>) tagRepo.findAll();
  }

  /* Category Repository */

  @RequestMapping("/categories")
  public Collection<Category> getCategories() {
    return (Collection<Category>) catRepo.findAll();
  }

  @RequestMapping("/category/{name}")
  public Category getCategory(@PathVariable(name = "name") String name, Model model) {
    return catRepo.findByName(name);
  }

  /* Tag Repository */

  @RequestMapping("/tags")
  public Collection<Tag> getTags() {
    return (Collection<Tag>) tagRepo.findAll();
  }

  @RequestMapping("/tags/{name}") // /api/courses
  public Tag getCourse(@PathVariable(name = "name") String name) {
    return tagRepo.findByName(name);
  }


  @RequestMapping(value = "/tags/{name}", method = RequestMethod.DELETE)
  public Collection<Tag> deleteTag(@PathVariable(value = "name") String name) {
    Tag searchedTag = tagRepo.findByName(name);
    for (Review review : reviewRepo.findAll()) {
      if (review.getTags().contains(searchedTag)) {
        review.getTags().remove(searchedTag);
      }
    }
    tagRepo.delete(searchedTag.getId());
    return (Collection<Tag>) tagRepo.findAll();
  }
}
