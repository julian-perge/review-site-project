package org.julian.reviewsiteproject.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Review {
  @Id @GeneratedValue private Long id;

  private String title;
  private String imgUrl;

  @ManyToMany private Collection<Tag> tags;

  @ManyToOne private Category category;

  @OneToMany(mappedBy = "review")
  private Collection<ReviewComment> reviewComments;
  
  @ElementCollection
  private Collection<ReviewCommentEmbed> revComEmbed;

  @Lob private String content; 

  protected Review() {}

  public Review(String title, String imgUrl, String content, Category category, Tag... tags) {
    this.title = title;
    this.imgUrl = imgUrl;
    this.content = content;
    this.category = category;
    this.tags = Arrays.asList(tags);
  }
  
  public void addReviewCommentEmbed(ReviewCommentEmbed comment) {
	  revComEmbed.add(comment);
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
  
  public Collection<ReviewCommentEmbed> getRevComEmbed() {
	  return revComEmbed;
  }

  public Collection<ReviewComment> getReviewComments() {
    return reviewComments;
  }
}
