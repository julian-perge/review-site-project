package org.julian.reviewsiteproject.entities;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Embeddable
public class ReviewComment {
  private String title;
  @Lob private String description;

  protected ReviewComment() {}

  public ReviewComment(String title, String description) {
    this.title = title;
    this.description = description;
  }

  @Override
  public String toString() {
    return title;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }
}
