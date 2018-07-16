package org.julian.reviewsiteproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class ReviewComment {
  @Id @GeneratedValue private Long id;

  private String title;
  @Lob private String description;

  @ManyToOne private Review review;

  public ReviewComment() {}

  public ReviewComment(String title, String description, Review review) {
    this.title = title;
    this.description = description;
    this.review = review;
  }

  @Override
  public String toString() {
    return title;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((review == null) ? 0 : review.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ReviewComment other = (ReviewComment) obj;
    if (description == null) {
      if (other.description != null) return false;
    } else if (!description.equals(other.description)) return false;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    if (review == null) {
      if (other.review != null) return false;
    } else if (!review.equals(other.review)) return false;
    if (title == null) {
      if (other.title != null) return false;
    } else if (!title.equals(other.title)) return false;
    return true;
  }

  public Review getReview() {
    return review;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }
}
