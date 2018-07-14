package org.julian.reviewsiteproject.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {
  @Id @GeneratedValue private Long id;

  private String title;
  private String imgUrl;

  @ManyToMany private Collection<Tag> tags;

  @ManyToOne private Category category;

  @Embedded
  private Set<ReviewComment> reviewComments;

  @Lob private String content;

  protected Review() {}

  public Review(String title, String imgUrl, String content, Category category, Tag... tags) {
    this.title = title;
    this.imgUrl = imgUrl;
    this.content = content;
    this.category = category;
    this.tags = Arrays.asList(tags);
  }

  @Override
  public String toString() {
    return title;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public Category getCategory() {
    return category;
  }

  public String getContent() {
    return content;
  }

  public Collection<Tag> getTags() {
    return tags;
  }

  public void addReviewComment(ReviewComment comment) {
    reviewComments.add(comment);
  }

  public Collection<ReviewComment> getReviewComments() {
    return reviewComments;
  }
}
