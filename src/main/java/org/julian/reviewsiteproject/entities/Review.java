package org.julian.reviewsiteproject.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Review {
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;

  private String title;
  private String imgUrl;

  @ManyToMany(targetEntity=org.julian.reviewsiteproject.entities.Tag.class)
  private Collection<Tag> tags;

  public Collection<Tag> getTags() {
    return tags;
  }

  @ManyToOne private Category category;

  @OneToMany(mappedBy = "review")
  private Collection<ReviewComment> reviewComments;

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

  public Collection<ReviewComment> getReviewComments() {
    return reviewComments;
  }

  public void addTag(Tag tag) {
    this.tags.add(tag);
    if (!tag.getReviews().contains(this)) {
    	tag.addReview(this);
    }
  }
}
